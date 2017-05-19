package com.whp.framework.controller;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observer;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Maps;
import com.whp.framework.entity.ObservableEntity;
import com.whp.framework.entity.main.Organization;
import com.whp.framework.exception.ExistedException;
import com.whp.framework.shiro.ShiroDbRealm;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.framework.utils.springmvc.DateEditor;
import com.whp.framework.utils.springmvc.DoubleEditor;
import com.whp.framework.utils.springmvc.IntegerEditor;
import com.whp.framework.utils.springmvc.LongEditor;

// TODO: Auto-generated Javadoc
/**
 * The Class BaseController.
 * 
 * @param <T>
 *            the generic type
 * @param <ID>
 *            the generic type
 * @param <S>
 *            the generic type
 */
public abstract class BaseController
{
    protected Logger logger = Logger.getLogger(getClass());
    
    /**
     * 验证Bean是否满足字段约束
     */
    @Autowired
    protected Validator validator;
    
    /**
     * 初始化常用页面路径 页面路径初始化方法<br>
     * 根据路径构造页面路径，例如：将"/management/register/regMedical"重新构造成
     * "management/register/regMedical/regMedical_create"
     */
    protected static String GET_PAGE_PATH(String requestMapping, String pageType)
    {
        if (StringUtils.isBlank(requestMapping))
        {
            throw new ExistedException("requestMapping参数不能为空!");
        }
        String temp = null;
        StringBuffer sb = new StringBuffer();
        // 判断requestMapping是否以"/"开头，如果是就去掉
        if (StringUtils.startsWith(requestMapping, "/"))
        {
            temp = StringUtils.substringAfter(requestMapping, "/");
        }
        else
        {
            temp = requestMapping;
        }
        
        // 根据路径构造页面路径，例如：将"/management/register/regMedical"重新构造成"management/register/regMedical/regMedical_"
        sb.append(temp).append("/").append(StringUtils.substringAfterLast(requestMapping, "/")).append("_");
        // 构造页面路径
        return sb.toString() + pageType;
    }
    
    /**
     * Inits the binder.
     * 
     * @param request
     *            the request
     * @param binder
     *            the binder
     * @throws Exception
     *             the exception
     */
    @InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
        throws Exception
    {
        
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
    
    /**
     * Ajax done.
     * 
     * @param statusCode
     *            the status code
     * @param message
     *            the message
     * @return the model and view
     */
    protected ModelAndView ajaxDone(int statusCode, String message)
    {
        ModelAndView mav = new ModelAndView("ajaxDone");
        mav.addObject("statusCode", statusCode);
        mav.addObject("message", message);
        return mav;
    }
    
    /**
     * Ajax done success.
     * 
     * @param message
     *            the message
     * @return the model and view
     */
    protected ModelAndView ajaxDoneSuccess(String message)
    {
        return ajaxDone(200, message);
    }
    
    /**
     * Ajax done error.
     * 
     * @param message
     *            the message
     * @return the model and view
     */
    protected ModelAndView ajaxDoneError(String message)
    {
        return ajaxDone(200, message);
    }
    
    /**
     * Gets the message.
     * 
     * @param code
     *            the code
     * @return the message
     */
    protected String getMessage(String code)
    {
        return this.getMessage(code, new Object[] {});
    }
    
    /**
     * Gets the message.
     * 
     * @param code
     *            the code
     * @param arg0
     *            the arg0
     * @return the message
     */
    protected String getMessage(String code, Object arg0)
    {
        return getMessage(code, new Object[] {arg0});
    }
    
    /**
     * Gets the message.
     * 
     * @param code
     *            the code
     * @param arg0
     *            the arg0
     * @param arg1
     *            the arg1
     * @return the message
     */
    protected String getMessage(String code, Object arg0, Object arg1)
    {
        return getMessage(code, new Object[] {arg0, arg1});
    }
    
    /**
     * Gets the message.
     * 
     * @param code
     *            the code
     * @param arg0
     *            the arg0
     * @param arg1
     *            the arg1
     * @param arg2
     *            the arg2
     * @return the message
     */
    protected String getMessage(String code, Object arg0, Object arg1, Object arg2)
    {
        return getMessage(code, new Object[] {arg0, arg1, arg2});
    }
    
    /**
     * Gets the message.
     * 
     * @param code
     *            the code
     * @param arg0
     *            the arg0
     * @param arg1
     *            the arg1
     * @param arg2
     *            the arg2
     * @param arg3
     *            the arg3
     * @return the message
     */
    protected String getMessage(String code, Object arg0, Object arg1, Object arg2, Object arg3)
    {
        return getMessage(code, new Object[] {arg0, arg1, arg2, arg3});
    }
    
    /**
     * 将指定对象转为json对象，并根据removeProp 删除指定的字段.
     * 
     * @param removeProp
     *            删除指定的字段集合
     * @param srcBean
     *            the src bean
     * @return the json object by entity
     * @throws Exception
     *             the exception
     */
    protected JSONObject getJsonObjectByEntity(Set<String> removeProp, Object srcBean)
        throws Exception
    {
        
        return getJsonObjectByEntity(removeProp, null, srcBean);
    }
    
    /**
     * 将指定对象转为json对象，并根据params 去除或指定转换的对象字段.
     * 
     * @param params
     *            the params
     * @param flag
     *            true:params为删除集合，false为指定字段集合 默认：true
     * @param srcBean
     *            the src bean
     * @return the json object by entity
     * @throws Exception
     *             the exception
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("unchecked")
    protected JSONObject getJsonObjectByEntity(Set<String> params, Boolean flag, Object srcBean)
        throws Exception
    {
        // true:params为删除集合，false为指定字段集合 默认：true
        if (null == flag)
        {
            flag = true;
        }
        Map<String, Object> describeMap = null;
        Map<String, Object> tempMap = Maps.newHashMap();
        describeMap = BeanUtils.describe(srcBean);
        Set<Entry<String, Object>> set = describeMap.entrySet();
        // 将null的属性用""代替
        for (Entry<String, Object> entry : set)
        {
            if (null == entry.getValue())
            {
                entry.setValue("");
            }
        }
        
        if (null != params && params.size() > 0)
        {
            for (String key : params)
            {
                // flag为true时params为指定删除字段的集合
                if (describeMap.containsKey(key) && flag)
                {
                    describeMap.remove(key);
                }
                else
                {// 否则flag为false时params为指定转换josn串的字段集合
                    tempMap.put(key, describeMap.get(key));
                }
            }
        }
        // 如果flag为false时将原有的参数集合替换
        if (!flag)
        {
            describeMap = tempMap;
        }
        return new JSONObject(describeMap);
    }
    
    /**
     * 获得当前登录用户
     * 
     * @return
     */
    protected ShiroUser getShiroUser()
    {
        Subject subject = SecurityUtils.getSubject();
        ShiroDbRealm.ShiroUser shiroUser = (ShiroDbRealm.ShiroUser)subject.getPrincipal();
        return shiroUser;
    }
    
    /**
     * 通知观察者被观察对象已发生变化
     * 
     * @param obj
     * @param service
     * @param message
     */
    protected <T extends ObservableEntity, V extends Observer> void noticeObserver(T obj, V service, Object message)
    {
        obj.addObserver(service);
        obj.changed(message);
        obj.deleteObservers();
    }
    
    /**
     * list 页面数据权限控制，查找的实体类必需有userb：登录用户名，orgb:登录机构代码,如果是超级管理员则无需要控制
     * @param searchParams
     * @return false无权限，true有权限
     * @see [类、类#方法、类#成员]
     */
    protected boolean dataAuth(Map<String, Object> searchParams)
    {
        ShiroUser user = getShiroUser();
        //如果不是超级管理员
        if (!user.getUser().getIsSupervisor())
        {
            
            Organization organization = user.getUser().getOrganization();
            if (null == organization)
            {
                return false;
            }

                if (user.getUser().getUserb().equals("1"))
                {
                    if (null != user.getUser().getUsername())
                    {
                        if (null == searchParams.get("EQ_userAuth"))
                        {
                            searchParams.put("EQ_userAuth", user.getUser().getUsername());
                        }
                    }
                }
                else if (user.getUser().getUserb().equals("2"))
                {
                    if (null != user.getUser().getOrgb())
                    {
                        if (null == searchParams.get("EQ_orgAuth"))
                        {
                            searchParams.put("EQ_orgAuth", user.getUser().getOrganization().getId().toString());
                        }
                    }
                }
            }
        return true;
    }
}
