/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.entity.component.StoreType.java
 * Class:			StoreType
 * Date:			2013-7-1
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          3.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.entity.component;

/** 
 * 资源存储类型，存入数据库DB，存入文件FILE。	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  3.1.0
 * @since   2013-7-1 下午3:04:58 
 */

public enum StoreType {
	DB("db"), FILE("file");
	
	private String value;
	
	StoreType(String value) {
		this.value = value;
	}
	
	public String value() {
		return this.value;
	}
}
