package com.wondersgroup.framework.utils;

import java.util.Calendar;

/**
 * 身份证验证的工具（支持15位或18位省份证）<br/>
 * 身份证号码结构：
 * <ol>
 * <li>17位数字和1位校验码：6位地址码数字，8位生日数字，3位出生时间顺序号，1位校验码。</li>
 * <li>地址码（前6位）：表示对象常住户口所在县（市、镇、区）的行政区划代码，按GB/T2260的规定执行。</li> 
 * <li>出生日期码，（第七位 至十四位）：表示编码对象出生年、月、日，按GB按GB/T7408的规定执行，年、月、日代码之间不用分隔符。</li> 
 * <li>顺序码（第十五位至十七位）：表示在同一地址码所标示的区域范围内，对同年、同月、同日出生的人编订的顺序号，
 * 顺序码的奇数分配给男性，偶数分配给女性。</li>  
 * <li>校验码（第十八位数）：<br/>  
 * <ul>
 * <li>十七位数字本体码加权求和公式 s = sum(Ai*Wi), i = 0,,16，先对前17位数字的权求和；   
 *  Ai:表示第i位置上的身份证号码数字值.Wi:表示第i位置上的加权因.Wi: 7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2；</li>
 *<li>计算模 Y = mod(S, 11)</li> 
 *<li>通过模得到对应的校验码 Y: 0 1 2 3 4 5 6 7 8 9 10 校验码: 1 0 X 9 8 7 6 5 4 3 2</li>  
 *</ul>
 *</li>
 *</ol>
 *
 *@author cxy
 *@since 2011-1-7
 */
public class IdcardUtil
{
    
    public static final int MAX_MAINLAND_AREACODE = 659004; //大陆地区地域编码最大值
    
    public static final int MIN_MAINLAND_AREACODE = 110000; //大陆地区地域编码最小值
    
    public static final int HONGKONG_AREACODE = 810000; //香港地域编码值
    
    public static final int TAIWAN_AREACODE = 710000; //台湾地域编码值
    
    public static final int MACAO_AREACODE = 820000; //澳门地域编码值
    
    final static int[] PARITYBIT = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
    
    final static int[] POWER_LIST = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    
    /**
     * 验证身份证的地域编码是符合规则
     */
    private static boolean checkArea(String idCardInput)
    {
        String subStr = idCardInput.substring(0, 6);
        int areaCode = Integer.parseInt(subStr);
        if (areaCode != HONGKONG_AREACODE && areaCode != TAIWAN_AREACODE && areaCode != MACAO_AREACODE
            && (areaCode > MAX_MAINLAND_AREACODE || areaCode < MIN_MAINLAND_AREACODE))
            return false;
        return true;
    }
    
    /**
     * 
     * 身份证验证
     * 
     *@param shzhm  号码内容
     *@return 是否有效 true身价证号码正确;null和"" 都是false  
     */
    public static boolean isIdcard(String shzhm)
    {
        if (shzhm == null || (shzhm.length() != 15 && shzhm.length() != 18))
            return false;
        final char[] cs = shzhm.toUpperCase().toCharArray();
        //校验位数
        int power = 0;
        for (int i = 0; i < cs.length; i++)
        {
            if (i == cs.length - 1 && cs[i] == 'X')
                break;//最后一位可以 是X或x
            if (cs[i] < '0' || cs[i] > '9')
                return false;
            if (i < cs.length - 1)
            {
                power += (cs[i] - '0') * POWER_LIST[i];
            }
        }
        
        //校验区位码
        if (!checkArea(shzhm))
        {
            return false;
        }
        
        //校验年份
        String year = shzhm.length() == 15 ? "19" + shzhm.substring(6, 8) : shzhm.substring(6, 10);
        final int iyear = Integer.parseInt(year);
        if (iyear < 1900 || iyear > Calendar.getInstance().get(Calendar.YEAR))
            return false;//1900年的PASS，超过今年的PASS
            
        //校验月份
        String month = shzhm.length() == 15 ? shzhm.substring(8, 10) : shzhm.substring(10, 12);
        final int imonth = Integer.parseInt(month);
        if (imonth < 1 || imonth > 12)
        {
            return false;
        }
        
        //校验天数
        
        String day = shzhm.length() == 15 ? shzhm.substring(10, 12) : shzhm.substring(12, 14);
        final int iday = Integer.parseInt(day);
        if (iday < 1 || iday > 31)
            return false;
        
        //校验"校验码"
        if (shzhm.length() == 15)
            return true;
        return cs[cs.length - 1] == PARITYBIT[power % 11];
    }
    
    public static void main(String[] args)
    {
        
        String s = "650106197709283017";
        System.out.println(s + " --> " + isIdcard(s));
    }
}
