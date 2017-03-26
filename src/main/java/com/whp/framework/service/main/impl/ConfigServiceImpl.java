/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.RoleServiceImpl.java
 * Class:			RoleServiceImpl
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.main.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.main.Config;
import com.whp.framework.repository.jpa.main.ConfigDAO;
import com.whp.framework.service.main.ConfigService;
import com.whp.framework.shiro.ShiroDbRealm;
import com.whp.framework.utils.dwz.Page;
import com.whp.framework.utils.dwz.PageUtils;

/** 
 * 	
 * @author 	
 * Version  
 * @since    
 */
@Service
@Transactional
public class ConfigServiceImpl implements ConfigService {
	
	@Autowired
	private ConfigDAO configDAO;
	
	@Autowired(required = false)
	private ShiroDbRealm shiroRealm;
	
	@Override
	public void save(Config config){
		configDAO.save(config);
	}

	@Override
	public Config get(Long id) {
		return configDAO.findOne(id);
	}
	
	@Override
	public List<Config> findAll(Page page) {
		org.springframework.data.domain.Page<Config> springDataPage = configDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**   
	 * @param role  
	 * @see com.whp.framework.service.main.RoleService#update(com.whp.framework.entity.main.Role)  
	 */
	public void update(Config config) {
		configDAO.save(config);
		shiroRealm.clearAllCachedAuthorizationInfo();
	}

	/**   
	 * @param id  
	 * @see com.whp.framework.service.main.RoleService#delete(java.lang.Long)  
	 */
	public void delete(Long id) {
		configDAO.delete(id);
		shiroRealm.clearAllCachedAuthorizationInfo();
	}

	/**   
	 * @param page
	 * @param name
	 * @return  
	 * @see com.whp.framework.service.main.RoleService#find(com.whp.framework.utils.dwz.Page, java.lang.String)  
	 */
	public List<Config> find(String key,Page page) {
		org.springframework.data.domain.Page<Config> springDataPage = 
				(org.springframework.data.domain.Page<Config>)configDAO.findByKeyContaining(key, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	@Override
	public List<Config> findByStatusConf(String status) {
		return configDAO.findByStatus(status);
	}

	@Override
	public List<Config> findByKeyConfAndId(String key,Long id) {
		return configDAO.findByKeyAndId(key,id);
	}

	@Override
	public List<Config> findByKeyConf(String key) {
		return configDAO.findByKey(key);
	}

}
