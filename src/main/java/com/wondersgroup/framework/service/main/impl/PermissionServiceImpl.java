/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.RolePermissionImpl.java
 * Class:			RolePermissionImpl
 * Date:			2013-4-16
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.service.main.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.framework.entity.main.Permission;
import com.wondersgroup.framework.repository.jpa.main.PermissionDAO;
import com.wondersgroup.framework.service.main.PermissionService;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:12:41 
 */
@Service
@Transactional
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private PermissionDAO permissionDAO;

	/**   
	 * @param permission  
	 * @see com.wondersgroup.framework.service.main.PermissionService#save(com.wondersgroup.framework.entity.main.Permission)  
	 */
	@Override
	public void save(Permission permission) {
		permissionDAO.save(permission);
	}

	/**   
	 * @param id
	 * @return  
	 * @see com.wondersgroup.framework.service.main.PermissionService#get(java.lang.Long)  
	 */
	@Override
	public Permission get(Long id) {
		return permissionDAO.findOne(id);
	}

	/**   
	 * @param permission  
	 * @see com.wondersgroup.framework.service.main.PermissionService#update(com.wondersgroup.framework.entity.main.Permission)  
	 */
	@Override
	public void update(Permission permission) {
		permissionDAO.save(permission);
	}

	/**   
	 * @param id  
	 * @see com.wondersgroup.framework.service.main.PermissionService#delete(java.lang.Long)  
	 */
	@Override
	public void delete(Long id) {
		permissionDAO.delete(id);
	}
}
