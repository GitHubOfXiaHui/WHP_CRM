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
 
package com.wondersgroup.framework.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.framework.entity.component.Task;
import com.wondersgroup.framework.repository.jpa.component.TaskDAO;
import com.wondersgroup.framework.service.component.TaskService;
import com.wondersgroup.framework.utils.dwz.Page;
import com.wondersgroup.framework.utils.dwz.PageUtils;

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
	 * @see com.wondersgroup.framework.service.component.TaskService#find(com.wondersgroup.framework.utils.dwz.Page, java.lang.String)  
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
	 * @see com.wondersgroup.framework.service.component.TaskService#save(com.wondersgroup.framework.entity.component.Task)  
	 */
	@Override
	public void save(Task task) {
		taskDAO.save(task);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.wondersgroup.framework.service.component.TaskService#get(java.lang.Long)  
	 */
	@Override
	public Task get(String id) {
		return taskDAO.findOne(id);
	}

	/**   
	 * @param task  
	 * @see com.wondersgroup.framework.service.component.TaskService#update(com.wondersgroup.framework.entity.component.Task)  
	 */
	@Override
	public void update(Task task) {
		taskDAO.save(task);
	}

	/**   
	 * @param id  
	 * @see com.wondersgroup.framework.service.component.TaskService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(String id) {
		taskDAO.delete(id);
	}

	/**   
	 * @param page
	 * @return  
	 * @see com.wondersgroup.framework.service.component.TaskService#findAll(com.wondersgroup.framework.utils.dwz.Page)  
	 */
	@Override
	public List<Task> findAll(Page page) {
		org.springframework.data.domain.Page<Task> springDataPage = taskDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

}
