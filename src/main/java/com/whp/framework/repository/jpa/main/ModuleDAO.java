/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.ModuleDao.java
 * Class:			ModuleDao
 * Date:			2012-8-6
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.repository.jpa.main;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.whp.framework.entity.main.Module;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-6 上午9:31:03 
 */

public interface ModuleDAO extends BaseJpaDao<Module, Long> {
	Page<Module> findByParentId(Long parentId, Pageable pageable);
	
	Page<Module> findByParentIdAndNameContaining(Long parentId, String name, Pageable pageable);
	
	@QueryHints(value={
			@QueryHint(name="org.hibernate.cacheable",value="true"),
			@QueryHint(name="org.hibernate.cacheRegion",value="com.wondersgroup.framework.entity.main")
		}
	)
	@Query("from Module m order by m.priority ASC")
	List<Module> findAllWithCache();
	
	/**
	 * 根据sn，查找Module
	 * 描述
	 * @param sn
	 * @return
	 */
	List<Module> findBySn(String sn);
}
