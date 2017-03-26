package com.whp.framework.repository.jpa;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 集成自spring-data-JPA 的两个结构实现CRUD、分页、以及JPA动态组合查询等功能
 * @author  zpfox
 */
public interface BaseJpaDao<T, ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T>
{

	List<T> findByIdIn(String[] ids);
}          
