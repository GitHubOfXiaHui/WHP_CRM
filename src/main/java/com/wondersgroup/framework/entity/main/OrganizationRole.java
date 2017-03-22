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
 * 	组织机构与角色关系
 * Version  2.0.0
 * @since   2013-4-15 下午4:01:34 
 */
@Entity
@Table(name="security_organization_role")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.wondersgroup.framework.entity.main")
public class OrganizationRole extends IdLongEntity {

	/** 描述. */
	private static final long serialVersionUID = -2216187629501296831L;

	/** 值越小，优先级越高. */
	@NotNull
	@Range(min=1, max=99)
	@Column(length=2, nullable=false)
	private Integer priority = 99;
	
	/** 角色外键. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="roleId")
	private Role role;
	
	/** 机构外键. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="organizationId")
	private Organization organization;

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
	 * @param priority
	 *            the new 值越小，优先级越高
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * Gets the 角色外键.
	 * 
	 * @return the 角色外键
	 */
	public Role getRole() {
		return role;
	}

	/**
	 * Sets the 角色外键.
	 * 
	 * @param role
	 *            the new 角色外键
	 */
	public void setRole(Role role) {
		this.role = role;
	}

	/**
	 * Gets the 机构外键.
	 * 
	 * @return the 机构外键
	 */
	public Organization getOrganization() {
		return organization;
	}

	/**
	 * Sets the 机构外键.
	 * 
	 * @param organization
	 *            the new 机构外键
	 */
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
}
