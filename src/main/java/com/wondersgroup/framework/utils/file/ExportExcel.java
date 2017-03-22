package com.wondersgroup.framework.utils.file;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * 利用开源组件POI3.0.2动态导出EXCEL文档 转载时请保留以下信息，注明出处！
 * 
 * @author leno
 * @version v1.0
 * @param <T>
 *            应用泛型，代表任意一个符合javabean风格的类
 *            注意这里为了简单起见，boolean型的属性xxx的get器方式为getXxx(),而不是isXxx()
 *            byte[]表jpg格式的图片数据
 * @author zpfox
 * @version v1.1
 * @param <T>
 */
public class ExportExcel<T> {
	/**
	 * 预设列宽
	 */
	public static final Integer DEFAULTCOLUMNWIDTH = 15;

	/**
	 * 预设字体大小
	 */
	public static final Short FONTHEIGHTINPOINTS = 12;

	/**
	 * 预设表头起始行索引值
	 */
	public static final Short TITLE_ROW_INDEX = 0;

	/**
	 * 预设表体起始行索引值
	 */
	public static final Short BODY_ROW_INDEX = 1;

	public void exportExcel(List<T> dataset, OutputStream out) throws IOException {
		exportExcel("导出EXCEL文档", null, dataset, out, "yyyy-MM-dd");
	}

	public void exportExcel(Map<String, String> headers, List<T> dataset, OutputStream out) throws IOException {
		exportExcel("导出EXCEL文档", headers, dataset, out, "yyyy-MM-dd");
	}

	public void exportExcel(Map<String, String> headers, List<T> dataset, OutputStream out,
			String pattern) throws IOException {
		exportExcel("导出EXCEL文档", headers, dataset, out, pattern);
	}

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出到指定IO设备上
	 * 
	 * @param sheetName
	 *            表格标题名
	 * @param headers
	 *            表格属性列名数组
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象。此方法支持的
	 *            javabean属性的数据类型有基本数据类型及String,Date,byte[](图片数据)
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 * @param pattern
	 *            如果有时间数据，设定输出格式。默认为"yyy-MM-dd"
	 * @throws IOException 
	 */
	public void exportExcel(String sheetName, Map<String, String> headers, List<T> dataset,
			OutputStream out, String pattern) throws IOException {
		// 声明一个工作薄
		HSSFWorkbook workbook = new HSSFWorkbook();
		try {
			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(sheetName);
			// 设置表格默认列宽度为15个字节
			sheet.setDefaultColumnWidth(DEFAULTCOLUMNWIDTH);
			// 生成表头样式
			HSSFCellStyle titleStyle = setTitleStyle(workbook);
			// 生成表体样式
			HSSFCellStyle bodyStyle = setBodyStyle(workbook);
			// 声明一个画图的顶级管理器
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
			// 定义注释的大小和位置,详见文档
			HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0,
					(short) 4, 2, (short) 6, 5));
			// 设置注释内容
			comment.setString(new HSSFRichTextString("请勿修改首行顺序与文字内容！"));
			// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
			comment.setAuthor("hcbmp");
			// 产生表格标题行
			HSSFRow row = sheet.createRow(TITLE_ROW_INDEX);
			HSSFCell cell = null;
			HSSFRichTextString text = null;

			int i = 0;
			for (String header : headers.keySet()) {
				cell = row.createCell(i);
				cell.setCellStyle(titleStyle);
				text = new HSSFRichTextString(headers.get(header));
				cell.setCellValue(text);
				i++;
			}
			Method[] methods = null;
			String fieldName = null;
			Object value = null;
			if (null != dataset) {
				// 生成表体数据
				for (int j = 0; j < dataset.size(); j++) {
					// 创建表体行
					row = sheet.createRow(j + 1);
					// 获得所有方法
					methods = dataset.get(j).getClass().getDeclaredMethods();
					int cellIndex = 0;
					// 按表头顺序添加单元格
					for (String header : headers.keySet()) {
						for (Method method : methods) {
							fieldName = StringUtils.substringAfter(method.getName(), "get");
							if (StringUtils.equalsIgnoreCase(header, fieldName)) {
								// 创建单元格
								cell = row.createCell(cellIndex);
								cell.setCellStyle(bodyStyle);
								// 设置单元格数值
								value = method.invoke(dataset.get(j));
								if (null == value) {
									value = "";
								}
								setCellValue(cell, value, pattern, patriarch);
							}
						}
						cellIndex++;
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			workbook.write(out);
            out.flush();
            out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置单元格数值
	 * 
	 * @param cell
	 * @param value
	 * @param pattern
	 * @param patriarch
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private HSSFCell setCellValue(HSSFCell cell, Object value, String pattern,
			HSSFPatriarch patriarch) {
		// 判断值的类型后进行强制类型转换
		String textValue = null;
		if (value instanceof Integer) {
			int intValue = (Integer) value;
			cell.setCellValue(intValue);
		} else if (value instanceof Float) {
			float fValue = (Float) value;
			cell.setCellValue(new HSSFRichTextString(String.valueOf(fValue)));
		} else if (value instanceof Double) {
			double dValue = (Double) value;
			cell.setCellValue(new HSSFRichTextString(String.valueOf(dValue)));
		} else if (value instanceof Long) {
			long longValue = (Long) value;
			cell.setCellValue(longValue);
		} else if (value instanceof Date) {
			Date date = (Date) value;
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			textValue = sdf.format(date);
		} else if (value instanceof byte[]) {
			// 有图片时，设置行高为60px;
			cell.getRow().setHeightInPoints(60);
			// 设置图片所在列宽度为80px,注意这里单位的一个换算
			cell.getSheet().setColumnWidth(cell.getColumnIndex(), (short) (35.7 * 80));
			// sheet.autoSizeColumn(i);
			byte[] bsValue = (byte[]) value;
			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 255, (short) 6,
					cell.getRowIndex(), (short) 6, cell.getRowIndex());
			anchor.setAnchorType(2);
			patriarch.createPicture(
					anchor,
					cell.getSheet().getWorkbook()
							.addPicture(bsValue, HSSFWorkbook.PICTURE_TYPE_JPEG));
		} else {
			// 其它数据类型都当作字符串简单处理
			textValue = value.toString();
		}
		// 如果不是图片数据，就利用正则表达式判断textValue是否全部由数字组成
		if (textValue != null) {
			Pattern p = Pattern.compile("^//d+(//.//d+)?{1}quot;");
			Matcher matcher = p.matcher(textValue);
			if (matcher.matches()) {
				// 是数字当作double处理
				cell.setCellValue(Double.parseDouble(textValue));
			} else {
				HSSFRichTextString richString = new HSSFRichTextString(textValue);
				HSSFFont font3 = cell.getSheet().getWorkbook().createFont();
				font3.setColor(HSSFColor.BLUE.index);
				richString.applyFont(font3);
				cell.setCellValue(richString);
			}
		}
		return cell;
	}

	/**
	 * 设置表体样式
	 * 
	 * @param workbook
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private HSSFCellStyle setBodyStyle(HSSFWorkbook workbook) {
		HSSFCellStyle bodyStyle = workbook.createCellStyle();
		bodyStyle.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		bodyStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		bodyStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
		bodyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		bodyStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		bodyStyle.setFont(font2);
		return bodyStyle;
	}

	/**
	 * 设置表头样式
	 * 
	 * @param workbook
	 * @return
	 * @see [类、类#方法、类#成员]
	 */
	private HSSFCellStyle setTitleStyle(HSSFWorkbook workbook) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setFontHeightInPoints(FONTHEIGHTINPOINTS);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		return style;
	}

	public static void main(String[] args) {
		// // 测试学生
		// ExportExcel<Student> ex = new ExportExcel<Student>();
		// String[] headers = { "学号", "姓名", "年龄", "性别", "出生日期" };
		// List<Student> dataset = new ArrayList<Student>();
		// dataset.add(new Student(10000001, "张三", 20, true, new Date()));
		// dataset.add(new Student(20000002, "李四", 24, false, new Date()));
		// dataset.add(new Student(30000003, "王五", 22, true, new Date()));
		// // 测试图书
		// ExportExcel<Book> ex2 = new ExportExcel<Book>();
		// String[] headers2 = { "图书编号", "图书名称", "图书作者", "图书价格", "图书ISBN",
		// "图书出版社", "封面图片" };
		// List<Book> dataset2 = new ArrayList<Book>();
		// try {
		// BufferedInputStream bis = new BufferedInputStream(
		// new FileInputStream("book.jpg"));
		// byte[] buf = new byte[bis.available()];
		// while ((bis.read(buf)) != -1) {
		// //
		// }
		// dataset2.add(new Book(1, "jsp", "leno", 300.33f, "1234567",
		// "清华出版社", buf));
		// dataset2.add(new Book(2, "java编程思想", "brucl", 300.33f, "1234567",
		// "阳光出版社", buf));
		// dataset2.add(new Book(3, "DOM艺术", "lenotang", 300.33f, "1234567",
		// "清华出版社", buf));
		// dataset2.add(new Book(4, "c++经典", "leno", 400.33f, "1234567",
		// "清华出版社", buf));
		// dataset2.add(new Book(5, "c#入门", "leno", 300.33f, "1234567",
		// "汤春秀出版社", buf));
		//
		// OutputStream out = new FileOutputStream("E://a.xls");
		// OutputStream out2 = new FileOutputStream("E://b.xls");
		// ex.exportExcel(headers, dataset, out);
		// ex2.exportExcel(headers2, dataset2, out2);
		// out.close();
		// JOptionPane.showMessageDialog(null, "导出成功!");
		// System.out.println("excel导出成功！");
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}
}
