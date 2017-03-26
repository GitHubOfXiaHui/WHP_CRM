package com.whp.framework.entity.main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.whp.framework.entity.IdLongEntity;

// TODO: Auto-generated Javadoc
/** 
 * 权限定义 	
 * Version  2.0.0
 * @since   2013-4-16 下午1:34:54 
 */
@Entity
@Table(name="security_permission")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="com.wondersgroup.framework.entity.main")
public class Permission extends IdLongEntity {
	
	/** 描述. */
	private static final long serialVersionUID = -7905701060290158981L;
	
	/** 操作. */
	public final static String PERMISSION_CREATE = "save";
	
	/** The Constant PERMISSION_READ. */
	public final static String PERMISSION_READ = "view";
	
	/** The Constant PERMISSION_UPDATE. */
	public final static String PERMISSION_UPDATE = "edit";
	
	/** The Constant PERMISSION_DELETE. */
	public final static String PERMISSION_DELETE = "delete";
	
	/** 权限名称. */
	@NotBlank
	@Length(min=1, max=32)
	@Column(nullable=false, length=32)
	private String name;
	
	/** 简称. */
	@NotBlank
	@Length(min=1, max=16)
	@Column(nullable=false, length=16)
	private String shortName;
	
	/** 描述. */
	@Length(max=255)
	@Column(length=255)
	private String description;
	
	/** 模块外键. */
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="moduleId")
	private Module module;
	
	/** 角色与权限对应关系列表. */
	@OneToMany(mappedBy="permission", cascade={CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval=true)
	private List<RolePermission> rolePermissiones = Lists.newArrayList();

	/**
	 * Gets the 权限名称.
	 *
	 * @return the 权限名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the 权限名称.
	 *
	 * @param name the new 权限名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the 简称.
	 *
	 * @return the 简称
	 */
	public String getShortName() {
		return shortName;
	}

	/**
	 * Sets the 简称.
	 *
	 * @param shortName the new 简称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	/**
	 * Gets the 描述.
	 *
	 * @return the 描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the 描述.
	 *
	 * @param description the new 描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the 模块外键.
	 *
	 * @return the 模块外键
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * Sets the 模块外键.
	 *
	 * @param module the new 模块外键
	 */
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * Gets the 角色与权限对应关系列表.
	 *
	 * @return the 角色与权限对应关系列表
	 */
	public List<RolePermission> getRolePermissiones() {
		return rolePermissiones;
	}

	/**
	 * Sets the 角色与权限对应关系列表.
	 *
	 * @param rolePermissiones the new 角色与权限对应关系列表
	 */
	public void setRolePermissiones(List<RolePermission> rolePermissiones) {
		this.rolePermissiones = rolePermissiones;
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
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
			Permission that = (Permission) obj; 
            return Objects.equal(id, that.getId()) 
                    && Objects.equal(name, that.getName())
                    && Objects.equal(shortName, that.getShortName());
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
