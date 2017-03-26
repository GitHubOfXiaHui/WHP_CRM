/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.ketayao.sample.service.impl.TaskServiceImpl.java
 * Class:			TaskServiceImpl
 * Date:			2013-4-21
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.component.Task;
import com.whp.framework.repository.jpa.component.TaskDAO;
import com.whp.framework.service.component.TaskService;
import com.whp.framework.utils.dwz.Page;
import com.whp.framework.utils.dwz.PageUtils;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.0.0
 * @since   2013-4-21 下午7:56:11 
 */
@Service
@Transactional
public class TaskServiceImpl implements TaskService {
	
	@Autowired
	private TaskDAO taskDAO;

	/**   
	 * @param page
	 * @param name
	 * @return  
	 * @see com.whp.framework.service.component.TaskService#find(com.whp.framework.utils.dwz.Page, java.lang.String)  
	 */
	@Override
	public List<Task> find(Page page, String title) {
		org.springframework.data.domain.Page<Task> springDataPage = 
				(org.springframework.data.domain.Page<Task>)taskDAO.findByTitleContaining(title, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**   
	 * @param task  
	 * @see com.whp.framework.service.component.TaskService#save(com.whp.framework.entity.component.Task)  
	 */
	@Override
	public void save(Task task) {
		taskDAO.save(task);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.whp.framework.service.component.TaskService#get(java.lang.Long)  
	 */
	@Override
	public Task get(String id) {
		return taskDAO.findOne(id);
	}

	/**   
	 * @param task  
	 * @see com.whp.framework.service.component.TaskService#update(com.whp.framework.entity.component.Task)  
	 */
	@Override
	public void update(Task task) {
		taskDAO.save(task);
	}

	/**   
	 * @param id  
	 * @see com.whp.framework.service.component.TaskService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(String id) {
		taskDAO.delete(id);
	}

	/**   
	 * @param page
	 * @return  
	 * @see com.whp.framework.service.component.TaskService#findAll(com.whp.framework.utils.dwz.Page)  
	 */
	@Override
	public List<Task> findAll(Page page) {
		org.springframework.data.domain.Page<Task> springDataPage = taskDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

}
