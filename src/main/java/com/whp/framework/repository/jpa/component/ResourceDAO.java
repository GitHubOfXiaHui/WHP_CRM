/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.component.ResourceDAO.java
 * Class:			ResourceDAO
 * Date:			2013-6-28
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          3.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.repository.jpa.component;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whp.framework.entity.component.Resource;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  3.1.0
 * @since   2013-6-28 上午10:18:10 
 */

public interface ResourceDAO extends BaseJpaDao<Resource, String> {
	Resource getByUuid(String uuid);
	
	Page<Resource> findByFileNameContaining(Pageable pageable, String name); 
}
