package com.wondersgroup.framework.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class CookieAuthUtil
{
    protected static Logger logger = Logger.getLogger(CookieAuthUtil.class);
    
    /**
     * 从session中获取卡号
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getKh(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String kh = null;
        if (null != session.getAttribute("kh"))
        {
            kh = (String)session.getAttribute("kh");
        }
        else
        {
            logger.error("session kh is null !");
        }
        return kh;
    }
    
    /**
     * 从session中获取patientID
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getPatientID(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String patientID = null;
        if (null != session.getAttribute("patientID"))
        {
            patientID = (String)session.getAttribute("patientID");
        }
        else
        {
            logger.error("session patientID is null !");
        }
        return patientID;
    }
    
    public static void clearSession(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        session.removeAttribute("kh");
        session.removeAttribute("xpxlh");
        //session.removeAttribute("machineCode");
        // session.removeAttribute("samCode");
        session.removeAttribute("patientID");
        session.removeAttribute("readCardLog");
    }
    
    public static void writeSession(HttpServletRequest request, String Kh, String xpxlh)
    {
        HttpSession session = request.getSession();
        session.setAttribute("kh", Kh);
        session.setAttribute("xpxlh", xpxlh);
        //session.setAttribute("machineCode", request.getParameter("machineCode"));
        // session.setAttribute("samCode", request.getParameter("samCode"));
    }
    
    /**
     * 2002.CardTypeID（身份识别）
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getCardType(HttpServletRequest request)
    {
        HttpSession session = request.getSession();
        String cardTypeId = null;
        if (null != session.getAttribute("cardTypeId"))
        {
            cardTypeId = (String)session.getAttribute("cardTypeId");
        }
        else
        {
            logger.error("session getCardType is null,his error!");
        }
        return cardTypeId;
    }
}
