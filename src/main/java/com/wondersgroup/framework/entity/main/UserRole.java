package com.wondersgroup.framework.entity.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Range;

import com.wondersgroup.framework.entity.IdLongEntity;

// TODO: Auto-generated Javadoc
/**
 * 用户与角色关系 Version 2.1.0
 * 
 * @since 2013-5-6 下午2:29:52
 */
@Entity
@Table(name = "security_user_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class UserRole extends IdLongEntity {

	/** 描述. */
	private static final long serialVersionUID = -8888778227379780116L;

	/** 值越小，优先级越高. */
	@NotNull
	@Range(min = 1, max = 99)
	@Column(length = 2, nullable = false)
	private Integer priority = 99;
	
	/** 角色ID--外键关系. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	private Role role;
	
	/** 用户ID--外键关系. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	private User user;

	/**
	 * Gets the 值越小，优先级越高.
	 * 
	 * @return the 值越小，优先级越高
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets the 值越小，优先级越高.
	 *
	 * @param priority the new 值越小，优先级越高
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * Gets the 角色ID--外键关系.
	 *
	 * @return the 角色ID--外键关系
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the 角色ID--外键关系.
	 *
	 * @param role the new 角色ID--外键关系
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the 用户ID--外键关系.
	 *
	 * @return the 用户ID--外键关系
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Sets the 用户ID--外键关系.
	 *
	 * @param user the new 用户ID--外键关系
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
