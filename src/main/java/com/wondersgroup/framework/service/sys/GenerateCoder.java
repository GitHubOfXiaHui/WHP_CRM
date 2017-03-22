package com.wondersgroup.framework.service.sys;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.framework.entity.sys.CodeNotes;
import com.wondersgroup.framework.exception.ServiceException;
import com.wondersgroup.framework.repository.jpa.sys.CodeNotesDao;
import com.wondersgroup.framework.service.sys.impl.DefaultCodePattern;

/**
 * 线程安全的单例类 Code编号生成器
 * 
 * @author zpfox
 * 
 */
@Component
// 默认将类中的所有方法都纳入事务进行管理.
@Transactional
public class GenerateCoder
{
    
    /**
     */
    private CodeNotesDao codeNotesDao;
    
    /**
     */
    private DefaultCodePattern defaultCodePattern;
    
    /**
     * 根据传入的单据前缀,使用默认样式生成Code字符串 默认样式:前缀+年月日(8位)+流水号(3位) 例:PZ20120501001(13位)
     * 
     * @param Prefix
     *            前缀
     * @return
     */
    public synchronized String getNextCode(CodeNotes codeNotes, GenerateCodePattern pattern)
        throws ServiceException
    {
        if (null == codeNotes || StringUtils.isEmpty(codeNotes.getPrefix()))
        {
            throw new ServiceException("codeNotes或前缀字段不能为空，请检查!");
        }
        if (null == pattern)
        {
            pattern = defaultCodePattern;
        }
        String code = null;
        // 查询CodeNotes表中传入的前缀是否已经存在
        CodeNotes codeObj = codeNotesDao.findByPrefix(codeNotes.getPrefix());
        
        // 如果不存在则新增,并返回新增的code字符串
        if (null == codeObj)
        {
            codeObj = pattern.newCodeNotes(codeNotes);
            codeNotesDao.save(codeObj);
            codeNotesDao.flush();
        }
        else
        {
            // 如果存在，则按照给定的样式生成下一个code
            codeObj = pattern.generateNextCode(codeObj);
            // 更新数据库中codeNotes对象的lastSerialNum
            codeNotesDao.save(codeObj);
            codeNotesDao.flush();
        }
//        codeObj.setMiddle(codeNotes.getMiddle());
        codeObj.setSpaceOccupying(pattern.getSpaceOccupying());
        // 返回已生成的code字符串
        code = pattern.getCodeString(codeObj);
        return code;
    }
    
    /**
     * 根据num 生成一组序列
     * 
     * @param codeNotes
     * @param pattern
     * @param num
     * @return
     * @throws ServiceException
     */
    public synchronized String[] getNextCodes(CodeNotes codeNotes, GenerateCodePattern pattern)
        throws ServiceException
    {
        // 获得该样式的流水号占位长度
        Integer spaceOccupying = pattern.getSpaceOccupying();
        if (spaceOccupying < StringUtils.length("" + pattern.getIncrementStep()))
        {
            throw new ServiceException("样式中定义的流水号位数小于增量步长数！");
        }
        String[] codes = new String[pattern.getIncrementStep()];
        // 按步长生成最后一位代码并更新数据库
        String code = getNextCode(codeNotes, pattern);
        //截取流水号之前的字符串
        String preStr = StringUtils.substring(code, 0, code.length() - spaceOccupying);
        //截取流水号
        String last = StringUtils.substring(code, code.length() - spaceOccupying);
        
        if (spaceOccupying < StringUtils.length(String.valueOf(Integer.valueOf(last) + pattern.getIncrementStep())))
        {
            throw new ServiceException("流水号加增量步长数超出定义请减小增量或增大流水号位数！");
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= pattern.getIncrementStep(); i++)
        {
            sb.append(preStr);
            sb.append(pattern.lastNumToString(Integer.valueOf(last) - pattern.getIncrementStep() + i));
            codes[i - 1] = sb.toString();
            sb.setLength(0);
        }
        return codes;
    }
    
    /**
     * @param codeNotesDao
     */
    @Autowired
    public void setCodeNotesDao(CodeNotesDao codeNotesDao)
    {
        this.codeNotesDao = codeNotesDao;
    }
    
    /**
     * @param defaultCodePattern
     */
    @Autowired
    public void setDefaultCodePattern(DefaultCodePattern defaultCodePattern)
    {
        this.defaultCodePattern = defaultCodePattern;
    }
}
