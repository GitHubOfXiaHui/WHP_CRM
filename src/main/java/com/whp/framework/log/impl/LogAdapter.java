/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.log.LogAdapter.java
 * Class:			LogTemplateAdapter
 * Date:			2013-5-3
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.log.impl;

import java.util.Map;

import com.google.common.collect.Maps;
import com.whp.framework.log.LogAPI;
import com.whp.framework.log.LogLevel;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.1.0
 * @since   2013-5-3 下午5:21:07 
 */

public class LogAdapter implements LogAPI {

	/**   
	 * @param message
	 * @param logLevel  
	 * @see com.whp.framework.log.LogAPI#log(java.lang.String, com.whp.framework.log.LogLevel)  
	 */
	@Override
	public void log(String message, LogLevel logLevel) {
		log(message, null, logLevel);
	}

	/**   
	 * @param message
	 * @param objects
	 * @param logLevel  
	 * @see com.whp.framework.log.LogAPI#log(java.lang.String, java.lang.Object[], com.whp.framework.log.LogLevel)  
	 */
	@Override
	public void log(String message, Object[] objects, LogLevel logLevel) {
		
	}
	
	/**   
	 * @return  
	 * @see com.whp.framework.log.LogAPI#getRootLogLevel()  
	 */
	@Override
	public LogLevel getRootLogLevel() {
		return LogLevel.ERROR;
	}

	/**   
	 * @return  
	 * @see com.whp.framework.log.LogAPI#getCustomLogLevel()  
	 */
	@Override
	public Map<String, LogLevel> getCustomLogLevel() {
		return Maps.newHashMap();
	}
}
