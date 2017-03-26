package com.whp.framework.utils.file;

import java.io.InputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;
import com.whp.framework.exception.ServiceException;

/**
 * 操作Excel表格的功能类
 * version:1.0
 */
@Component
public class ExcelReader
{
    public static final int TITLE = 0;
    
    static NumberFormat numberFormat = NumberFormat.getNumberInstance();
    
    private Workbook wb;
    
    private Sheet sheet;
    
    private Row row;
    
    /**
     * 根据传入的Excel文件读取并转换为对象
     * @param is 输入流，该方法不负责关闭输入流，请自行关闭；
     * @param filename 需要传入完整文件名(包括扩展名),需要根据扩展名来判断是xls还是xlsx文件
     * @param itemTitle  指定首行表头信息，校验上传文件的表头是否相符(文字和顺序)，如果不符则抛出异常
     * @param checkSheetName 当该参数不为null时，将校验其是否与传入Excel的sheet[0]名称匹配，如果不匹配则抛出异常
     * @return
     * @throws Exception
     */
    public Map<String, Object> readExcel(InputStream is, String filename, String[] itemTitle, String checkSheetName)
        throws Exception
    {
        
        Map<String, Object> result = Maps.newHashMap();
        OPCPackage pkg = null;
        String[] title = null;
        if (StringUtils.equals("xls", StringUtils.substringAfter(filename, ".")))
        {
            wb = new HSSFWorkbook(new POIFSFileSystem(is));
        }
        else if (StringUtils.equals("xlsx", StringUtils.substringAfter(filename, ".")))
        {
            pkg = OPCPackage.open(is);
            wb = new XSSFWorkbook(pkg);
        }
        else
        {
            throw new ServiceException("上传文件不是excel文件，不能解析！");
        }
        sheet = wb.getSheetAt(0);
        //如果需要检查sheet
        if (StringUtils.isNotBlank(checkSheetName))
        {
            if (!StringUtils.equalsIgnoreCase(sheet.getSheetName(), StringUtils.trimToEmpty(checkSheetName)))
            {
                throw new ServiceException("上传文件第一个sheet与指定的名称不符！");
            }
        }
        title = readExcelTitle(sheet);
        //判断给定的表头是否与上传文件的表头一致
        if (!Arrays.equals(itemTitle, title))
        {
            throw new ServiceException("上传文件与导入模版不符，请按模版重新上传！");
        }
        
        result.put("title", title);
        Map<Integer, String[]> content = readExcelContent(sheet, 1);
        result.put("content", content);
        return result;
    }
    
    /**
     * 读取Excel表格sheet 表头的内容
     * @param InputStream
     * @return String 表头内容的数组
     * @throws Exception 
     */
    public String[] readExcelTitle(Sheet sheet)
        throws Exception
    {
        row = sheet.getRow(TITLE);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++)
        {
            title[i] = getStringCellValue(row.getCell(i));
        }
        return title;
    }
    
    /**读取Excel数据内容
     * @param sheet
     * @param startRowNum 从第(startRowNum+1)行开始读
     * @return  Map 包含单元格数据内容的Map对象
     * @see [类、类#方法、类#成员]
     */
    public Map<Integer, String[]> readExcelContent(Sheet sheet, int startRowNum)
    {
        Map<Integer, String[]> content = Maps.newTreeMap();
        String[] str = null;
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        int j = 0;
        //空值计数器
        int count = 0;
        // 正文内容应该从第(startRowNum+1)行开始读
        for (int i = startRowNum; i <= rowNum; i++)
        {
            str = new String[colNum];
            row = sheet.getRow(i);
            j = 0;
            //初始化计数器
            count = 0;
            while (j < colNum)
            {
                str[j] =
                    getStringCellValue(row.getCell((short)j)).trim() != null ? getStringCellValue(row.getCell((short)j)).trim()
                        : "";
                if (str[j].equals(""))
                {
                    //计数器加1
                    count++;
                }
                j++;
            }
            //加入计数器的判断
            //如果计数器等于列数，就表明这是一个空行，就跳过
            if (count == colNum)
            {
                continue;
            }
            content.put(i, str);
        }
        return content;
    }
    
    /**
     * 获取单元格数据内容为字符串类型的数据
     * @param cell Excel单元格
     * @return String 单元格数据内容
     */
    private String getStringCellValue(Cell cell)
    {
        String strCell = "";
        if (null == cell)
        {
            return "";
        }
        switch (cell.getCellType())
        {
            case Cell.CELL_TYPE_STRING:
                strCell = cell.getStringCellValue() != null ? cell.getStringCellValue() : "";
                break;
            case Cell.CELL_TYPE_NUMERIC:
                // 这里的日期类型会被转换为数字类型，需要判别后区分处理  
                if (DateUtil.isCellDateFormatted(cell))
                {
                    strCell = String.valueOf(cell.getDateCellValue());
                }
                else
                {
                    //去掉分隔符
                    if (numberFormat.isGroupingUsed())
                    {
                        numberFormat.setGroupingUsed(false);
                    }
                    strCell = numberFormat.format(cell.getNumericCellValue());
                }
                break;
            case Cell.CELL_TYPE_BOOLEAN:
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case Cell.CELL_TYPE_BLANK:
                strCell = "";
                break;
            default:
                strCell = "";
                break;
        }
        if ("".equals(strCell) || null == strCell)
        {
            return "";
        }
        return StringUtils.trimToEmpty(strCell);
    }
    
    /**
     * 根据Cell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(Cell cell)
    {
        String cellvalue = "";
        if (cell != null)
        {
            // 判断当前Cell的Type
            switch (cell.getCellType())
            {
            // 如果当前Cell的Type为NUMERIC
                case Cell.CELL_TYPE_NUMERIC:
                    // 这里的日期类型会被转换为数字类型，需要判别后区分处理  
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        cellvalue = getDataString(cell.getDateCellValue());
                    }
                    else
                    {
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_FORMULA:
                {
                    // 判断当前的cell是否为Date
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        // 如果是Date类型则，转化为Data格式
                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();
                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        cellvalue = getDataString(cell.getDateCellValue());
                    }
                    // 如果是纯数字
                    else
                    {
                        //加上分隔符
                        if (!numberFormat.isGroupingUsed())
                        {
                            numberFormat.setGroupingUsed(true);
                        }
                        cellvalue = numberFormat.format(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRING
                case Cell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = "";
            }
        }
        else
        {
            cellvalue = "";
        }
        return cellvalue;
        
    }
    
    private String getDataString(Date dateCellValue)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(dateCellValue);
    }
    
    public Map<String, Object> readExcelSam(InputStream is, String filename, String[] itemTitle, String checkSheetName)
        throws Exception
    {
        
        Map<String, Object> result = Maps.newHashMap();
        OPCPackage pkg = null;
        if (StringUtils.equals("xls", StringUtils.substringAfter(filename, ".")))
        {
            wb = new HSSFWorkbook(new POIFSFileSystem(is));
        }
        else if (StringUtils.equals("xlsx", StringUtils.substringAfter(filename, ".")))
        {
            pkg = OPCPackage.open(is);
            wb = new XSSFWorkbook(pkg);
        }
        else
        {
            throw new ServiceException("上传文件不是excel文件，不能解析！");
        }
        sheet = wb.getSheetAt(0);
        //如果需要检查sheet
        if (StringUtils.isNotBlank(checkSheetName))
        {
            if (!StringUtils.equalsIgnoreCase(sheet.getSheetName(), StringUtils.trimToEmpty(checkSheetName)))
            {
                throw new ServiceException("上传文件第一个sheet与指定的名称不符！");
            }
        }
        
        //得到申请表编号
        row = sheet.getRow(0);
        String[] titleOne = new String[row.getPhysicalNumberOfCells()];
        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++)
        {
            titleOne[i] = getStringCellValue(row.getCell(i));
        }
        /*if (!"申领表编号".equals(titleOne[0]))
        {
            throw new ServiceException("申领表编号,上传文件与导入模版不符，请按模版重新上传！");
        }
        if (StringUtils.isBlank(titleOne[2]))
        {
            throw new ServiceException("申领表编号不能为空,请重新上传！");
        }*/
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        
        String[] title = new String[colNum];
        row = sheet.getRow(1);
        for (int i = 0; i < colNum; i++)
        {
            title[i] = getStringCellValue(row.getCell(i));
        }
        //判断给定的表头是否与上传文件的表头一致
        if (!Arrays.equals(itemTitle, title))
        {
            throw new ServiceException("第二行表头，上传文件与导入模版不符，请按模版重新上传！");
        }
        
        result.put("title", title);
        result.put("slbbh", titleOne[2]);
        Map<Integer, String[]> content = readExcelContent(sheet, 2);
        result.put("content", content);
        return result;
    }
    
    public Map<String, Object> readExcelRegMedicalOrg(InputStream is, String filename, String[] itemTitle)
        throws Exception
    {
        
        Map<String, Object> result = Maps.newHashMap();
        OPCPackage pkg = null;
        String[] title = null;
        if (StringUtils.equals("xls", StringUtils.substringAfter(filename, ".")))
        {
            wb = new HSSFWorkbook(new POIFSFileSystem(is));
        }
        else if (StringUtils.equals("xlsx", StringUtils.substringAfter(filename, ".")))
        {
            pkg = OPCPackage.open(is);
            wb = new XSSFWorkbook(pkg);
        }
        else
        {
            throw new ServiceException("上传文件不是excel文件，不能解析！");
        }
        sheet = wb.getSheetAt(0);
        //如果需要检查sheet
        
        title = readExcelTitle(sheet);
        String temp1 = "";
        String temp2 = "";
        for (int i = 0; i < itemTitle.length; i++)
        {
            temp1 = temp1 + title[i];
            temp2 = temp2 + itemTitle[i];
            
        }

        //判断给定的表头是否与上传文件的表头一致
        if (!Arrays.equals(itemTitle, title))
        {
            throw new ServiceException("上传文件与导入模版不符，请按模版重新上传！");
        }
        
        result.put("title", title);
        Map<Integer, String[]> content = readExcelContent(sheet, 1);
        result.put("content", content);
        return result;
    }
}