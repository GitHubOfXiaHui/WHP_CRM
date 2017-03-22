/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.LogEntityService.java
 * Class:			LogEntityService
 * Date:			2013-5-3
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.service.component;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.wondersgroup.framework.entity.component.LogEntity;
import com.wondersgroup.framework.log.LogLevel;
import com.wondersgroup.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.1.0
 * @since   2013-5-3 下午5:07:53 
 */

public interface LogEntityService {
	void save(LogEntity logEntity);
	
	LogEntity get(String id);
	
	void update(LogEntity logEntity);
	
	void delete(String id);
	
	List<LogEntity> findByLogLevel(LogLevel logLevel, Page page);
	
	List<LogEntity> findAll();
	
	List<LogEntity> findByExample(Specification<LogEntity> specification, Page page);
}
