package com.whp.framework.entity.main;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.base.Objects;
import com.whp.framework.entity.IdLongEntity;

// TODO: Auto-generated Javadoc
/**
 * 角色与权限关系 Version 2.0.0
 * 
 * @since 2013-4-16 下午1:47:51
 */
@Entity
@Table(name = "security_role_permission")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class RolePermission extends IdLongEntity {

	/** 描述. */
	private static final long serialVersionUID = -7679139844716398059L;

	/** 角色外键. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleId")
	private Role role;

	/** 权限外键. */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "permissionId")
	private Permission permission;

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
	 * Gets the 权限外键.
	 * 
	 * @return the 权限外键
	 */
	public Permission getPermission() {
		return permission;
	}

	/**
	 * Sets the 权限外键.
	 * 
	 * @param permission
	 *            the new 权限外键
	 */
	public void setPermission(Permission permission) {
		this.permission = permission;
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

		if (obj instanceof RolePermission) {
			RolePermission that = (RolePermission) obj;
			return Objects.equal(id, that.getId());
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
		return Objects.hashCode(id);
	}
}
