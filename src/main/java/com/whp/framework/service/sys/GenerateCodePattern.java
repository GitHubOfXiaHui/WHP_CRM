package com.whp.framework.service.sys;

import java.text.DecimalFormat;

import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.sys.CodeNotes;

/**
 * Code生成样式抽象类
 * 
 * @author zpfox
 * 
 */
@Transactional
public abstract class GenerateCodePattern
{
    /**
     * 默认日期字符串样式
     */
    protected static final String DATE_STRING_PATTERN = "yyyyMMdd";
    
    /**
     * 流水号初始值
     */
    protected static final Integer INITIAL_VALUE = 0;
    
    /**
     * 默认流水号占位数
     */
    protected static final Integer SPACE_OCCUPYING = 3;
    
    /**
     * 将流水号转化成字符串，并按位数补零
     * 
     * @return
     */
    protected String intToString(CodeNotes codeNotes)
    {
        if (null == codeNotes)
        {
            return null;
        }
        StringBuilder strPattern = new StringBuilder();
        // 并按位数补零
        for (int i = 0; i < codeNotes.getSpaceOccupying(); i++)
        {
            strPattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(strPattern.toString());
        return df.format(codeNotes.getLastSerialNum());
    }
    
    /**
     * 将流水号转化成字符串，并按位数补零
     * 
     * @return
     */
    protected String lastNumToString(Integer lastSerialNum)
    {
        StringBuilder strPattern = new StringBuilder();
        // 并按位数补零
        for (int i = 0; i < getSpaceOccupying(); i++)
        {
            strPattern.append("0");
        }
        DecimalFormat df = new DecimalFormat(strPattern.toString());
        return df.format(lastSerialNum);
    }
    
    /**
     * 抽象方法 由子类实现 子类可以根据自身逻辑选择性的初始化CodeNotes对象，
     * 但CodeNotes对象的prefix字段不能为空，并且在数据库中唯一. 初始化的值可以使用父类提供的默认值，如有特殊需求可以自行定义。
     * 建议不要修改父类，将特殊需求封装在子类内部 可参考DefaultCodePattern默认实现类
     * 
     * @param codeNotes
     *            Code生成辅助类，其记录了code的组成
     * @return
     */
    abstract public CodeNotes newCodeNotes(CodeNotes codeNotes);
    
    /**
     * 抽象方法 由子类实现 子类可根据自身逻辑计算后返回CodeNotes对象， 可参考DefaultCodePattern默认实现类
     * 
     * @param codeNotes
     *            Code生成辅助类，其必须是从数据库中查到的对象
     * @return
     */
    abstract public CodeNotes generateNextCode(CodeNotes codeNotes);
    
    /**
     * 抽象方法 由子类实现 将传入的CodeNotes对象，</br>
     * 按照自身逻辑拼装成字符串返回 可参考DefaultCodePattern默认实现类
     * @param codeObj
     * @return
     */
    abstract public String getCodeString(CodeNotes codeObj);
    
    /**
     * 返回该样式中流水号站位长度
     * @param codeObj
     * @return
     */
    abstract public Integer getSpaceOccupying();
    
    /**
     * Gets the 流水号递增量.
     * 
     * @return the 流水号递增量
     */
    abstract public Integer getIncrementStep();
    
}
