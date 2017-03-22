package com.wondersgroup.framework.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.wondersgroup.framework.entity.StatusObj;
import com.wondersgroup.framework.shiro.ShiroDbRealm.ShiroUser;
import com.wondersgroup.framework.utils.dwz.Page;

/**
 * 默认审核业务流程服务接口定义
 * @author zpfox
 */
public interface DefaultAuditFlowService<T extends StatusObj,ID extends Serializable>  {
	/**
	 * 注册.
	 * 
	 * @param obj
	 *            the obj
	 * @param shiroUser
	 *            the shiro user
	 */
	void register(T obj, ShiroUser shiroUser);

	/**
	 * 提交操作.
	 * 
	 * @param id
	 *            the id
	 */
	void submit(ID id, ShiroUser shiroUser);

	/**
	 * 批量提交.
	 * 
	 * @param ids
	 *            the ids
	 * @param shiroUser
	 *            the shiro user
	 */
	void batchSubmit(String[] ids, ShiroUser shiroUser);

	/**
	 * 审核操作.
	 * 
	 * @param id
	 *            the id
	 * @param shiroUser
	 *            the shiro user
	 * @return the reg supplier
	 */
	T auditing(ID id, ShiroUser shiroUser);

	/**
	 * 驳回操作.
	 * 
	 * @param obj
	 *            the obj
	 * @param shiroUser
	 *            the shiro user
	 */
	void rejecting(T obj, ShiroUser shiroUser);

	/**
	 * 作废操作.
	 * 
	 * @param obj
	 *            the obj
	 * @param shiroUser
	 *            the shiro user
	 */
	void obsolete(T obj, ShiroUser shiroUser);

	/**
	 * 更新操作.
	 * 
	 * @param entity
	 *            the entity
	 */
	void update(T entity);

	/**
	 * 删除单个对象.
	 * 
	 * @param id
	 *            the id
	 */
	void delete(ID id);

	/**
	 * 批量删除.
	 * 
	 * @param ids
	 *            the ids
	 */
	void batchDelete(ID[] ids);

	/**
	 * Find by id.
	 * 
	 * @param id
	 *            the id
	 * @return the reg medical org
	 */
	T findById(ID id);

	/**
	 * Find by filter jpa.
	 * 
	 * @param page
	 *            the page
	 * @param searchParams
	 *            the search params
	 * @return the list
	 */
	List<T> findByFilterJpa(Page page, Map<String, Object> searchParams);

	/**
	 * Find all by page.
	 * @param page
	 *            the page
	 * @return the list
	 */
	List<T> findAllByPage(Page page);
    /**
     * 根据对象Id获得唯一对象
     * @param id
     * @return
     */
    T get(ID id);
}
