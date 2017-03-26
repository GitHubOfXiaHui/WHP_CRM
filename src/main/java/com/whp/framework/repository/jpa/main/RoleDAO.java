/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.RoleDao.java
 * Class:			RoleDao
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.repository.jpa.main;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whp.framework.entity.main.Role;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午5:03:07 
 */

public interface RoleDAO extends BaseJpaDao<Role, Long> {
	Page<Role> findByNameContaining(String name, Pageable pageable);
}
