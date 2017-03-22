package com.wondersgroup.framework.utils;

import org.apache.commons.lang3.StringUtils;

import com.wondersgroup.framework.SecurityConstants;

public class ConstantUtil
{
    public static int getZzjPageSize()
    {
        int pageSize = 5;
        String temp = SecurityConstants.configMap.get("zzjPageSize");
        if (StringUtils.isNotBlank(temp))
        {
            pageSize = Integer.parseInt(temp);
        }
        return pageSize;
    }
    
    public static int getDeptPageSize()
    {
        int pageSize = 15;
        String temp = SecurityConstants.configMap.get("deptPageSize");
        if (StringUtils.isNotBlank(temp))
        {
            pageSize = Integer.parseInt(temp);
        }
        return pageSize;
    }
    
    public static int getDoctorPageSize()
    {
        int pageSize = 6;
        String temp = SecurityConstants.configMap.get("doctorPageSize");
        if (StringUtils.isNotBlank(temp))
        {
            pageSize = Integer.parseInt(temp);
        }
        return pageSize;
    }
    
    public static int getPrintPageSize()
    {
        int pageSize = 5;
        String temp = SecurityConstants.configMap.get("printPageSize");
        if (StringUtils.isNotBlank(temp))
        {
            pageSize = Integer.parseInt(temp);
        }
        return pageSize;
    }
    
    /**
     * 待缴费的PageSize
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int getPaymentPageSize()
    {
        int pageSize = 7;
        String temp = SecurityConstants.configMap.get("paymentPageSize");
        if (StringUtils.isNotBlank(temp))
        {
            pageSize = Integer.parseInt(temp);
        }
        return pageSize;
    }
    
    /**
     * 得到金额，保留的小数位
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static int getPayScale()
    {
        int scale = 5;
        String temp = SecurityConstants.configMap.get("payScale");
        if (StringUtils.isNotBlank(temp))
        {
            scale = Integer.parseInt(temp);
        }
        return scale;
    }
}
