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
 
package com.wondersgroup.framework.service.main.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.framework.entity.main.Role;
import com.wondersgroup.framework.repository.jpa.main.RoleDAO;
import com.wondersgroup.framework.service.main.RoleService;
import com.wondersgroup.framework.shiro.ShiroDbRealm;
import com.wondersgroup.framework.utils.dwz.Page;
import com.wondersgroup.framework.utils.dwz.PageUtils;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午5:04:52 
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDAO roleDAO;
	
	@Autowired(required = false)
	private ShiroDbRealm shiroRealm;
	
	@Override
	public void save(Role role) {
		roleDAO.save(role);
	}

	@Override
	public Role get(Long id) {
		return roleDAO.findOne(id);
	}
	
	@Override
	public List<Role> findAll(Page page) {
		org.springframework.data.domain.Page<Role> springDataPage = roleDAO.findAll(PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**   
	 * @param role  
	 * @see com.wondersgroup.framework.service.main.RoleService#update(com.wondersgroup.framework.entity.main.Role)  
	 */
	public void update(Role role) {
		roleDAO.save(role);
		shiroRealm.clearAllCachedAuthorizationInfo();
	}

	/**   
	 * @param id  
	 * @see com.wondersgroup.framework.service.main.RoleService#delete(java.lang.Long)  
	 */
	public void delete(Long id) {
		roleDAO.delete(id);
		shiroRealm.clearAllCachedAuthorizationInfo();
	}

	/**   
	 * @param page
	 * @param name
	 * @return  
	 * @see com.wondersgroup.framework.service.main.RoleService#find(com.wondersgroup.framework.utils.dwz.Page, java.lang.String)  
	 */
	public List<Role> find(Page page, String name) {
		org.springframework.data.domain.Page<Role> springDataPage = 
				(org.springframework.data.domain.Page<Role>)roleDAO.findByNameContaining(name, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

}
