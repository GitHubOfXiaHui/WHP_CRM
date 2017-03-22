/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.component.ResourceServiceImpl.java
 * Class:			ResourceServiceImpl
 * Date:			2013-6-28
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          3.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.service.component.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.framework.entity.component.Resource;
import com.wondersgroup.framework.repository.jpa.component.ResourceDAO;
import com.wondersgroup.framework.service.component.ResourceService;
import com.wondersgroup.framework.utils.dwz.Page;
import com.wondersgroup.framework.utils.dwz.PageUtils;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  3.1.0
 * @since   2013-6-28 上午10:23:05 
 */
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceDAO resourceDAO;

	/**   
	 * @param resource  
	 * @see com.wondersgroup.framework.service.component.ResourceService#save(com.wondersgroup.framework.entity.component.Resource)  
	 */
	@Override
	public void save(Resource resource) {
		resourceDAO.save(resource);
	}

	/**   
	 * @param resource  
	 * @see com.wondersgroup.framework.service.component.ResourceService#update(com.wondersgroup.framework.entity.component.Resource)  
	 */
	@Override
	public void update(Resource resource) {
		resourceDAO.save(resource);
	}

	/**   
	 * @param id  
	 * @see com.wondersgroup.framework.service.component.ResourceService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(String id) {
		resourceDAO.delete(id);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.wondersgroup.framework.service.component.ResourceService#get(java.lang.Long)  
	 */
	@Override
	public Resource get(String id) {
		return resourceDAO.findOne(id);
	}
	
	/**   
	 * @param uuid
	 * @return  
	 * @see com.wondersgroup.framework.service.component.ResourceService#get(java.lang.String)  
	 */
	@Override
	public Resource getUUID(String uuid) {
		return resourceDAO.getByUuid(uuid);
	}

	/**   
	 * @param page
	 * @return  
	 * @see com.wondersgroup.framework.service.component.ResourceService#findAll(com.wondersgroup.framework.utils.dwz.Page)  
	 */
	@Override
	public List<Resource> findAll(Page page) {
		org.springframework.data.domain.Page<Resource> springDataPage = resourceDAO.findAll(PageUtils.createPageable(page)); 
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/**
	 * 
	 * @param page
	 * @param name
	 * @return  
	 * @see com.wondersgroup.framework.service.component.ResourceService#findByName(com.wondersgroup.framework.utils.dwz.Page, java.lang.String)
	 */
	@Override
	public List<Resource> findByFileName(Page page, String name) {
		org.springframework.data.domain.Page<Resource> springDataPage = resourceDAO.findByFileNameContaining(PageUtils.createPageable(page), name); 
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**
	 * 
	 * @param page
	 * @return  
	 * @see com.wondersgroup.framework.service.component.ResourceService#find(com.wondersgroup.framework.utils.dwz.Page)
	 */
	@Override
	public List<Resource> find(Page page) {
		org.springframework.data.domain.Page<Resource> springDataPage = resourceDAO.findAll(PageUtils.createPageable(page)); 
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

}
