/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.ketayao.sample.service.TaskService.java
 * Class:			TaskService
 * Date:			2013-4-21
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.component;

import java.util.List;

import com.whp.framework.entity.component.Task;
import com.whp.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.0.0
 * @since   2013-4-21 下午7:55:07 
 */

public interface TaskService {
	
	void save(Task task);
	
	void delete(String id);

	Task get(String id);

	void update(Task task);
	
	List<Task> find(Page page, String title);

	List<Task> findAll(Page page);
}
