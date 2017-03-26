/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.UserRoleService.java
 * Class:			UserRoleService
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.main;

import java.util.List;

import com.whp.framework.entity.main.UserRole;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午5:08:51 
 */

public interface UserRoleService {
	UserRole get(Long id);
	
	/**
	 * 根据userId，找到已分配的角色。
	 * 描述
	 * @param userId
	 * @return
	 */
	List<UserRole> find(Long userId);

	void save(UserRole userRole);

	void delete(Long userRoleId);

}
