/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.UserService.java
 * Class:			UserService
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.main;

import java.util.List;
import java.util.Map;

import com.whp.framework.entity.main.User;
import com.whp.framework.exception.ExistedException;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午3:03:59 
 */

public interface UserService {
	
	User getByUsername(String username);
	
	List<User> find(Page page, String name);

	void update(User user);
	
	void updatePwd(User user, String newPwd) throws ServiceException;

	void save(User user) throws ExistedException;

	void restPaw(User user) throws ExistedException;
	
	User get(Long id);

	void delete(Long id) throws ServiceException;

	List<User> findAll(Page page);
	
	/**
	 * 判断是否超级管理员.
	 */
	boolean isSupervisor(Long id);
	
	List<User> findAll();

    User findByAuthKey(String authKey);
    
    /**
	 * Find by filter jpa.
	 * 
	 * @param page
	 *            the page
	 * @param searchParams
	 *            the search params
	 * @return the list
	 */
	List<User> findByFilterJpa(Page page, Map<String, Object> searchParams);

	
}
