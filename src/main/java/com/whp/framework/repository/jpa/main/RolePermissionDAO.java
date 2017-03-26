/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.RolePermissionDao.java
 * Class:			RolePermissionDao
 * Date:			2013-4-16
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.repository.jpa.main;

import java.util.List;

import com.whp.framework.entity.main.RolePermission;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:10:57 
 */

public interface RolePermissionDAO extends BaseJpaDao<RolePermission, Long> {
	List<RolePermission> findByRoleId(Long roleId);
}
