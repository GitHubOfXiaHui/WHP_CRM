/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.RoleService.java
 * Class:			RoleService
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.main;

import java.util.List;

import com.whp.framework.entity.main.Role;
import com.whp.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午5:04:05 
 */

public interface RoleService {
	
	List<Role> find(Page page, String name);

	void save(Role role);

	Role get(Long id);

	void update(Role role);

	void delete(Long id);

	List<Role> findAll(Page page);
}
