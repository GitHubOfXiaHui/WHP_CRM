package com.whp.framework.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.whp.framework.utils.CookieAuthUtil;


public class CookieAuthFilter implements HandlerInterceptor
{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)
        throws Exception
    {
        String kh = CookieAuthUtil.getKh(request);
        
        if (StringUtils.isBlank(kh))
        {
            response.sendRedirect(request.getContextPath() + "/sst/index");
            return false;
        }
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView)
        throws Exception
    {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e)
        throws Exception
    {
    }
}
