package com.whp.framework.repository.jpa.sys;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.whp.framework.entity.sys.Constant;
import com.whp.framework.repository.jpa.BaseJpaDao;

/**
 * 系统常量Dao
 * @author  zpfox
 * @version  [版本号, 2013-2-10]
 */
public interface ConstantDao extends BaseJpaDao<Constant, Long>
{
    org.springframework.data.domain.Page<Constant> findByParentId(Long parentId, Pageable createPageable);
    
    org.springframework.data.domain.Page<Constant> findByParentIdAndNameContaining(Long parentId, String name,
        Pageable createPageable);
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = "com.wondersgroup.framework.entity.sys")})
    @Query("from Constant c order by c.id ASC")
    List<Constant> findAllWithCache();
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = "com.wondersgroup.framework.entity.sys")})
    Constant findByCode(String code);
    
    List<Constant> findByParentId(Long parentId);
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = "com.wondersgroup.framework.entity.sys")})
    List<Constant> findByParentCode(String parentCode);
    
    @QueryHints(value = {@QueryHint(name = "org.hibernate.cacheable", value = "true"),
        @QueryHint(name = "org.hibernate.cacheRegion", value = "com.wondersgroup.framework.entity.sys")})
    Constant findByName(String type);
}