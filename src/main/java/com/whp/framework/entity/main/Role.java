package com.whp.framework.entity.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.whp.framework.entity.IdLongEntity;

/**
 * 角色定义.
 * @since 2012-6-7 上午11:07:45
 */
@Entity
@Table(name = "security_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class Role extends IdLongEntity {

	/** 描述. */
	private static final long serialVersionUID = -5537665695891354775L;

	/** 角色名称. */
	@NotBlank
	@Length(min = 1, max = 32)
	@Column(nullable = false, length = 32)
	private String name;

	/** 角色描述. */
	@Length(max = 255)
	@Column(length = 255)
	private String description;

	/** 角色对应的列表. */
	@OneToMany(mappedBy = "role", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
	@OrderBy("priority ASC")
	private List<UserRole> userRoles = new ArrayList<UserRole>(0);

	/** 组织机构和角色的对应关系集合. */
	@OneToMany(mappedBy = "role", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
	@OrderBy("priority ASC")
	private List<OrganizationRole> organizationRoles = Lists.newArrayList();

	/** 角色和权限的关系集合. */
	@OneToMany(mappedBy = "role", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
	private List<RolePermission> rolePermissions = Lists.newArrayList();

	/**
	 * Gets the 角色名称.
	 * 
	 * @return the 角色名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the 角色名称.
	 * 
	 * @param name
	 *            the new 角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the 角色描述.
	 * 
	 * @return the 角色描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the 角色描述.
	 * 
	 * @param description
	 *            the new 角色描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the 角色对应的列表.
	 * 
	 * @return the 角色对应的列表
	 */
	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	/**
	 * Sets the 角色对应的列表.
	 * 
	 * @param userRoles
	 *            the new 角色对应的列表
	 */
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	/**
	 * Gets the 组织机构和角色的对应关系集合.
	 * 
	 * @return the 组织机构和角色的对应关系集合
	 */
	public List<OrganizationRole> getOrganizationRoles() {
		return organizationRoles;
	}

	/**
	 * Sets the 组织机构和角色的对应关系集合.
	 * 
	 * @param organizationRoles
	 *            the new 组织机构和角色的对应关系集合
	 */
	public void setOrganizationRoles(List<OrganizationRole> organizationRoles) {
		this.organizationRoles = organizationRoles;
	}

	/**
	 * Gets the 角色和权限的关系集合.
	 * 
	 * @return the 角色和权限的关系集合
	 */
	public List<RolePermission> getRolePermissions() {
		return rolePermissions;
	}

	/**
	 * Sets the 角色和权限的关系集合.
	 * 
	 * @param rolePermissions
	 *            the new 角色和权限的关系集合
	 */
	public void setRolePermissions(List<RolePermission> rolePermissions) {
		this.rolePermissions = rolePermissions;
	}

	/**
	 * Equals.
	 * 
	 * @param obj
	 *            the obj
	 * @return true, if successful
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (obj == this) {
			return true;
		}

		if (obj instanceof Role) {
			Role that = (Role) obj;
			return Objects.equal(id, that.getId()) && Objects.equal(name, that.getName());
		}

		return false;
	}

	/**
	 * Hash code.
	 * 
	 * @return the int
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hashCode(id, name);
	}
}
