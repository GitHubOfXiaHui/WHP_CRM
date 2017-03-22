/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.OrganizationRoleDao.java
 * Class:			OrganizationRoleDao
 * Date:			2013-4-15
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.repository.jpa.main;

import java.util.List;

import com.wondersgroup.framework.entity.main.OrganizationRole;
import com.wondersgroup.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.0.0
 * @since   2013-4-15 下午4:11:05 
 */

public interface OrganizationRoleDAO extends BaseJpaDao<OrganizationRole, Long> {
	List<OrganizationRole> findByOrganizationId(Long organizationId);
}
