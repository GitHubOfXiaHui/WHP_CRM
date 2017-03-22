package com.wondersgroup.framework.utils.jpa;

import java.text.ParseException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.google.common.collect.Maps;
import com.wondersgroup.framework.exception.ServiceException;
import com.wondersgroup.framework.utils.DateUtil;

public class MySearchFilter
{
    
    public enum Operator
    {
        EQ, LIKE, GT, LT, GTE, LTE,NEQ
    }
    
    public String fieldName;
    
    public Object value;
    
    public Operator operator;
    
    public MySearchFilter(String fieldName, Operator operator, Object value)
    {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }
    
    /**
     * searchParams中key的格式为OPERATOR_FIELDNAME
     */
    public static Map<String, MySearchFilter> parse(Map<String, Object> searchParams)
    {
        Map<String, MySearchFilter> filters = Maps.newHashMap();
        //对日期类型判断并做相应处理,过滤掉空值
        searchParams = paramTypeDecide(searchParams);
        String key = "";
        Object value = null;
        for (Entry<String, Object> entry : searchParams.entrySet())
        {
            
            key = entry.getKey();
            value = entry.getValue();
            // 拆分operator与filedAttribute
            String[] names = StringUtils.split(key, "_");
            if (names.length != 2)
            {
                throw new IllegalArgumentException(key + " is not a valid search filter name");
            }
            String filedName = names[1];
            Operator operator = Operator.valueOf(names[0]);
            
            // 创建searchFilter
            MySearchFilter filter = new MySearchFilter(filedName, operator, value);
            filters.put(key, filter);
        }
        return filters;
    }
    
    /**
     * 对查询对象的参数类型做相应判断
     * @param searchParams
     * @param clazz 
     * @return
     */
    private static Map<String, Object> paramTypeDecide(Map<String, Object> searchParams)
    {
        Map<String, Object> filterParams = Maps.newHashMap();
        String key = "";
        // 过滤掉空值
        Object value = null;
        for (Entry<String, Object> entry : searchParams.entrySet())
        {
            key = entry.getKey();
            // 过滤掉空值
            value = entry.getValue();
            if (StringUtils.isBlank(String.valueOf(value)))
            {
                continue;
            }
            //如果数据是合法的日期类型
            if (DateUtil.validate(String.valueOf(value)))
            {
                try
                {
                    String date = (String)value;
                    String operator = key.split("_")[0];
                    //如果是大于某个日期默认格式为(某日期 00:00:00)
                    if (MySearchFilter.Operator.GT.name().equals(operator)
                        || MySearchFilter.Operator.GTE.name().equals(operator))
                    {
                        date += " 00:00:00";
                    }
                    //如果是小于某个日期默认格式为(某日期 23:59:59)
                    else if (MySearchFilter.Operator.LT.name().equals(operator)
                        || MySearchFilter.Operator.LTE.name().equals(operator))
                    {
                        date += " 23:59:59";
                    }
                    value = DateUtils.parseDate(date, new String[] {"yyyy-MM-dd HH:mm:ss"});
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                    throw new ServiceException(value + ":查询筛选器日期数值转换错误！");
                }
                
            }
            filterParams.put(key, value);
        }
        return filterParams;
    }
}
