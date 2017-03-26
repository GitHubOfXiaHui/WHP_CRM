package com.whp.framework.service.sys.impl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.sys.CodeNotes;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.service.sys.GenerateCodePattern;
import com.whp.framework.utils.DateUtil;

/**
 * code默认样式
 * 
 * @author zpfox
 * 
 */
@Component
// 默认将类中的所有方法都纳入事务进行管理.
@Transactional
public class DefaultCodePattern extends GenerateCodePattern
{
    /**
     * 默认描述
     */
    private final String SYS_DESCRIPTION = "系统按默认策略自动生成";
    
    /**
     * 流水号增量步长
     */
    private Integer incrementStep = 1;
    
    /**
     * 新增默认样式 前缀+YYYYMMDD+流水号(3位)
     */
    @Override
    public CodeNotes newCodeNotes(CodeNotes codeNotes)
    {
        if (null == codeNotes || StringUtils.isEmpty(codeNotes.getPrefix()))
        {
            throw new ServiceException("codeNotes或前缀字段不能为空，请检查!");
        }
        if (null == codeNotes.getCountDate())
        {
            codeNotes.setCountDate(new Date());
        }
        // 设置流水号默认初始值
        codeNotes.setLastSerialNum(INITIAL_VALUE + getIncrementStep());
        // 设置流水号默认占位数
        codeNotes.setSpaceOccupying(SPACE_OCCUPYING);
        // 设置描述
        codeNotes.setDescription(SYS_DESCRIPTION);
        
        return codeNotes;
    }
    
    /**
     * 按默认日期样式设置当前系统时间,流水号加1
     */
    @Override
    public CodeNotes generateNextCode(CodeNotes codeNotes)
    {
        Date currentDate = new Date();
        String currentDateStr = DateUtil.date2String(currentDate,"yyyyMMdd");
        
        if (null == codeNotes || StringUtils.isEmpty(codeNotes.getPrefix()))
        {
            throw new ServiceException("codeNotes或前缀字段不能为空，请检查!");
        }
        // 如果当前日期在上次计数日期之后，流水号需要重新开始计数，并将计数日期更新为当前日期
        String lastDateStr = DateUtil.date2String(codeNotes.getCountDate(),"yyyyMMdd");
        
        if (Integer.parseInt(currentDateStr) > Integer.parseInt(lastDateStr))
        {
            codeNotes.setCountDate(currentDate);
            codeNotes.setLastSerialNum(INITIAL_VALUE);
        }
        else
        {// 否则流水号需要加上步长向下计数
            // 将从数据库中查询到的最后流水号加默认步长得到下一个流水号
            codeNotes.setLastSerialNum(codeNotes.getLastSerialNum() + getIncrementStep());
        }
        return codeNotes;
    }
    
    /**
     * 默认样式 前缀+YYYYMMDD+流水号
     */
    @Override
    public String getCodeString(CodeNotes codeNotes)
    {
        if (null == codeNotes)
        {
            return null;
        }
        String serialNumStr = super.intToString(codeNotes);
        StringBuilder codeString = new StringBuilder();
        codeString.append(codeNotes.getPrefix())
            .append(new DateTime(codeNotes.getCountDate()).toString(DATE_STRING_PATTERN))
            .append(serialNumStr);
        return codeString.toString();
    }
    
    @Override
    public Integer getSpaceOccupying()
    {
        return SPACE_OCCUPYING;
    }
    
    public void setIncrementStep(Integer incrementStep)
    {
        this.incrementStep = incrementStep;
    }
    
    @Override
    public Integer getIncrementStep()
    {
        return this.incrementStep;
    }
    
}
