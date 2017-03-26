/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.ketayao.sample.dao.TaskDAO.java
 * Class:			TaskDAO
 * Date:			2013-4-21
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.repository.jpa.component;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whp.framework.entity.component.Task;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.0.0
 * @since   2013-4-21 下午7:53:36 
 */

public interface TaskDAO extends BaseJpaDao<Task, String>{
	Page<Task> findByTitleContaining(String title, Pageable pageable);
}
