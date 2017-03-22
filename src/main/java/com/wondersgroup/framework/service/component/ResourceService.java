/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.component.ResourceService.java
 * Class:			ResourceService
 * Date:			2013-6-28
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          3.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.service.component;

import java.util.List;

import com.wondersgroup.framework.entity.component.Resource;
import com.wondersgroup.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  3.1.0
 * @since   2013-6-28 上午10:19:01 
 */

public interface ResourceService {
	void save(Resource resource);
	
	void update(Resource resource);
	
	void delete(String id);
	
	Resource get(String id);
	
	Resource getUUID(String uuid);
	
	List<Resource> findAll(Page page);
	
	List<Resource> findByFileName(Page page, String name);
	
	List<Resource> find(Page page);
}
