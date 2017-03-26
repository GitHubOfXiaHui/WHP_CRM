package com.whp.framework.repository.jpa.main;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.whp.framework.entity.main.User;
import com.whp.framework.repository.jpa.BaseJpaDao;

public interface UserDAO extends BaseJpaDao<User, Long> {
	// 根据登录名查找用户
	User findByUsername(String Username);
	
	// 根据实名查找用户
	User findByRealname(String realname);
	
	// 根据包含登录名(类似like)查找用户
	Page<User> findByUsernameContaining(String Username, Pageable pageable);
	
	/**
	 * 根据组织id查找用户。
	 * 描述
	 * @param organizationId
	 * @return
	 */
	List<User> findByOrganizationId(Long organizationId);

	// 根据KEY查找用户
    User findByAuthKey(String authKey);
}