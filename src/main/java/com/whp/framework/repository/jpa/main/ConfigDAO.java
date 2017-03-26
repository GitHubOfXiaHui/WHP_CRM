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

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.whp.framework.entity.main.Config;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	
 * Version  
 * @since   
 */

public interface ConfigDAO extends BaseJpaDao<Config, Long>
{
    Page<Config> findByKeyContaining(String key, Pageable pageable);
    
    @Query(value = "  from Config a where a.status=?1")
    public List<Config> findByStatus(String status);
    
    @Query(value = " from Config a where a.key= ?1 and a.id!= ?2")
    public List<Config> findByKeyAndId(String key, Long id);
    
    @Query(value = " from Config a where a.key= ?1 ")
    public List<Config> findByKey(String key);
    
}
