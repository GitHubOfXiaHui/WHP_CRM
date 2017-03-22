/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.LogEntityServiceImpl.java
 * Class:			LogEntityServiceImpl
 * Date:			2013-5-3
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.framework.entity.component.LogEntity;
import com.wondersgroup.framework.log.LogLevel;
import com.wondersgroup.framework.repository.jpa.component.LogEntityDAO;
import com.wondersgroup.framework.service.component.LogEntityService;
import com.wondersgroup.framework.utils.dwz.Page;
import com.wondersgroup.framework.utils.dwz.PageUtils;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.1.0
 * @since   2013-5-3 下午5:08:05 
 */
@Service
@Transactional
public class LogEntityServiceImpl implements LogEntityService {
	
	@Autowired
	private LogEntityDAO logEntityDAO;

	/**   
	 * @param logEntity  
	 * @see com.wondersgroup.framework.service.component.LogEntityService#save(com.wondersgroup.framework.entity.component.LogEntity)  
	 */
	@Override
	public void save(LogEntity logEntity) {
		logEntityDAO.save(logEntity);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.wondersgroup.framework.service.component.LogEntityService#get(java.lang.Long)  
	 */
	@Override
	public LogEntity get(String id) {
		return logEntityDAO.findOne(id);
	}

	/**   
	 * @param logEntity  
	 * @see com.wondersgroup.framework.service.component.LogEntityService#update(com.wondersgroup.framework.entity.component.LogEntity)  
	 */
	@Override
	public void update(LogEntity logEntity) {
		logEntityDAO.save(logEntity);
	}

	/**   
	 * @param id  
	 * @see com.wondersgroup.framework.service.component.LogEntityService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(String id) {
		logEntityDAO.delete(id);
	}

	/**
	 * 
	 * @param logLevel
	 * @param page
	 * @return  
	 * @see com.wondersgroup.framework.service.component.LogEntityService#findByLogLevel(com.wondersgroup.framework.log.LogLevel, com.wondersgroup.framework.utils.dwz.Page)
	 */
	@Override
	public List<LogEntity> findByLogLevel(LogLevel logLevel, Page page) {
		org.springframework.data.domain.Page<LogEntity> springDataPage = 
				logEntityDAO.findByLogLevel(logLevel, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**   
	 * @return  
	 * @see com.wondersgroup.framework.service.component.LogEntityService#findAll()  
	 */
	@Override
	public List<LogEntity> findAll() {
		return logEntityDAO.findAll();
	}

	/**
	 * 
	 * @param specification
	 * @param page
	 * @return  
	 * @see com.wondersgroup.framework.service.component.LogEntityService#findByExample(org.springframework.data.jpa.domain.Specification, com.wondersgroup.framework.utils.dwz.Page)
	 */
	@Override
	public List<LogEntity> findByExample(
			Specification<LogEntity> specification, Page page) {
		org.springframework.data.domain.Page<LogEntity> springDataPage = 
				logEntityDAO.findAll(specification, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
}
