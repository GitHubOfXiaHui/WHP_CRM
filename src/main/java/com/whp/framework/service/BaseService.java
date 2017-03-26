/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.ygsoft.security.service.GenericService.java
 * Class:			GenericService
 * Date:			2012-10-30
 * Author:			<a href="mailto:zpfox@163.com">zpfox</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.whp.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.whp.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:zpfox@163.com">zpfox</a>
 * Version  1.1.0
 * @since   2012-10-30 上午11:16:24 
 */

public interface BaseService<T, ID extends Serializable>
{
    /**
     * 保存单个的对象
     * @param entity
     */
    void save(T entity);
    
    /**
     * 批量保存给定的对象集合
     * @param entities
     * @return
     */
    <S extends T> List<S> save(Iterable<S> entities);
    
    /**
     * 更新指定对象
     * @param entity
     */
    void update(T entity);
    
    /**
     * 根据指定对象ID,删除该对象
     * @param id
     */
    void delete(ID id);
    
    /**
     * 批量删除
     * @param ids
     * @return 返回删除记录数
     */
    int deleteMany(ID[] ids);
    
    /**
     * 根据对象Id获得唯一对象
     * @param id
     * @return
     */
    T get(ID id);
    
    /**
     * 返回所有对象
     * @return
     */
    List<T> findAll();
    
    /**
     * 返回所有对象，支持分页
     * @param page
     * @return
     */
    List<T> findAll(Page page);
    
    /**
     * Jpa方式 查询筛选器，自动完成动态条件组合
     * @param page
     * @param searchParams
     * @return
     */
    public List<T> findByFilterJpa(Page page, Map<String, Object> searchParams);
    
    T saveAndReturn(T entity);
    
    /**
     * 根据指定对象,删除该对象
     * @param id
     */
    void delete(T entity);
    
    /**
     * 批量删除entity
     * @param ids
     * @return 返回删除记录数
     */
    void deleteMany(Iterable<T> entities);
    
    /**
     * 解析文件,数据同步用
     * @param dataType
     * @see [类、类#方法、类#成员]
     */
    public void analysisFile(String dataType);
}