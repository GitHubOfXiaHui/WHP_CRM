/**
 * <pre>
 * Copyright:		Copyright(C) 2012-2013, ketayao.com
 * Filename:		com.wondersgroup.framework.service.PermissionService.java
 * Class:			PermissionService
 * Date:			2013-4-16
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          2.0.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.service.main;

import com.wondersgroup.framework.entity.main.Permission;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  2.0.0
 * @since   2013-4-16 下午2:11:41 
 */

public interface PermissionService {
	
	void save(Permission permission);
	
	Permission get(Long id);
	
	void update(Permission permission);
	
	void delete(Long id);
}
