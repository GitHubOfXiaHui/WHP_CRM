package com.wondersgroup.framework.utils;

import com.wondersgroup.framework.utils.dwz.AjaxObject;

//暗文显示工具类
public class FuzzyUtil {

	
	//身份证暗文显示
	public static String getIDCardFuzzy(String idCard,int i,int j){
		
		String idCardstr = "";
		for(int a=1;a<=j-i;a++){
			idCardstr = new StringBuffer(idCardstr).append("*").toString();
		}
		return new StringBuffer(idCard).replace(i, j, idCardstr).toString();
	}
	//姓名暗文显示
	public static String getNameFuzzy(String name){
		
		StringBuffer sb = null;
		
		try{
			sb = new StringBuffer(name);
			sb = new StringBuffer(sb.toString().substring(0, 1)).append(" * *");
		}catch (Exception e) {
			e.printStackTrace();
            return AjaxObject.newError("姓名不符合规定").toString();
		}
		return sb.toString();
	} 
	public static void main(String[] arg){
		System.out.println(FuzzyUtil.getNameFuzzy("刘事情"));
	}
}
