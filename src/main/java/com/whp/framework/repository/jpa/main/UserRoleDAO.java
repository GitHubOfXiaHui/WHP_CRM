/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.UserRoleDao.java
 * Class:			UserRoleDao
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.repository.jpa.main;

import java.util.List;

import com.whp.framework.entity.main.UserRole;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午5:08:15 
 */

public interface UserRoleDAO extends BaseJpaDao<UserRole, Long> {
	List<UserRole> findByUserId(Long userId);
}
