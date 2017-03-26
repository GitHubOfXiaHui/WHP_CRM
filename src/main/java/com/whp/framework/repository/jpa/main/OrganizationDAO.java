/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.dao.OrganizationDao.java
 * Class:			OrganizationDao
 * Date:			2012-8-27
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

import com.whp.framework.entity.main.Organization;
import com.whp.framework.repository.jpa.BaseJpaDao;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-27 下午3:55:47 
 */

public interface OrganizationDAO extends BaseJpaDao<Organization, Long>
{
    Page<Organization> findByParentId(Long parentId, Pageable pageable);
    
    Page<Organization> findByParentIdAndNameContaining(Long parentId, String name, Pageable pageable);
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = "com.wondersgroup.framework.entity.main")})
    @Query("from Organization")
    List<Organization> findAllWithCache();
    
    Organization findByCodeAndJglx(String orgCode, String jglx);
    
    Organization findByCode(String code);
    
    List<Organization> findByParentId(Long parentId);
    
    @Query("from Organization o where o.areaCode like ?1")
    List<Organization> findByAreaCode(String areaCode);
    
    Organization findByAreaCodeAndJglx(String areaCode, String jglx);

    List<Organization> findByTbbzAndIsRoot(String tbbz, Boolean flag);
}
