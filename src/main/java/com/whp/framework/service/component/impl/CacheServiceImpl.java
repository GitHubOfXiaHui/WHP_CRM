/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.ServiceUtil.java
 * Class:			ServiceUtil
 * Date:			2012-9-14
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.component.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.whp.framework.service.component.CacheService;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-9-14 上午9:59:55 
 */
@Service
public class CacheServiceImpl implements CacheService {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * @see com.whp.framework.service.component.CacheService#clearAllCache()
	 */
	public void clearAllCache() {
		em.getEntityManagerFactory().getCache().evictAll();
	}

}
