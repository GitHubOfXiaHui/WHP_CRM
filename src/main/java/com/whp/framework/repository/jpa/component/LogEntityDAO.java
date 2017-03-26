/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.LogEntityDao.java
 * Class:			LogEntityDao
 * Date:			2013-5-3
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.repository.jpa.component;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.whp.framework.entity.component.LogEntity;
import com.whp.framework.log.LogLevel;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.1.0
 * @since   2013-5-3 下午5:06:37 
 */

public interface LogEntityDAO extends BaseJpaDao<LogEntity, String>, JpaSpecificationExecutor<LogEntity>{
	Page<LogEntity> findByLogLevel(LogLevel level, Pageable pageable);
}
