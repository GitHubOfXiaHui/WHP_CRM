package com.wondersgroup.framework.entity.main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.wondersgroup.framework.entity.IdLongEntity;

/**
 * 系统菜单资源.
 * 
 * @since 2012-8-2 下午5:36:39
 */
@Entity
@Table(name = "security_module")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class Module extends IdLongEntity implements Comparable<Module> {

	/** 描述. */
	private static final long serialVersionUID = -6926690440815291509L;

	/** 模块名称. */
	@NotBlank
	@Length(min = 1, max = 32)
	@Column(nullable = false, length = 32)
	private String name;

	/** 是否是根节点:默认false. */
	@Column
	private Boolean isRoot = false;

	/** 模块的入口地址. */
	@NotBlank
	@Length(min = 1, max = 255)
	@Column(nullable = false, length = 255)
	private String url;

	/** 描述. */
	@Length(max = 255)
	@Column(length = 255)
	private String description;

	/** 标志符，用于授权名称（类似module:save）. */
	@NotBlank
	@Length(min = 1, max = 32)
	@Column(nullable = false, length = 32, unique = true, updatable = false)
	private String sn;

	/** 模块的排序号,越小优先级越高. */
	@NotNull
	@Range(min = 1, max = 99)
	@Column(length = 2)
	private Integer priority = 99;

	/** 父类关联ID. */
	@ManyToOne
	@JoinColumn(name = "parentId")
	private Module parent;

	/** 子模块集合. */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parent")
	@OrderBy("priority DESC")
	private List<Module> children = Lists.newArrayList();

	/** 权限集合. */
	// 因为hibernate更新使用的是merge方法，会自动新增关联的瞬时对象，如果再次配置CascadeType.MERGE，会插入两条数据。<br/>
	@OneToMany(mappedBy = "module", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
	private List<Permission> permissions = Lists.newArrayList();

	/**
	 * Gets the 模块名称.
	 * 
	 * @return the 模块名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the 模块名称.
	 * 
	 * @param name
	 *            the new 模块名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the 是否是根节点:默认false.
	 * 
	 * @return the 是否是根节点:默认false
	 */
	public Boolean getIsRoot() {
		return isRoot;
	}

	/**
	 * Sets the 是否是根节点:默认false.
	 * 
	 * @param isRoot
	 *            the new 是否是根节点:默认false
	 */
	public void setIsRoot(Boolean isRoot) {
		this.isRoot = isRoot;
	}

	/**
	 * Gets the 模块的入口地址.
	 * 
	 * @return the 模块的入口地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the 模块的入口地址.
	 * 
	 * @param url
	 *            the new 模块的入口地址
	 */
	public void setUrl(String url) {
		this.url = url;
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
	 * @param description
	 *            the new 描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the 标志符，用于授权名称（类似module:save）.
	 * 
	 * @return the 标志符，用于授权名称（类似module:save）
	 */
	public String getSn() {
		return sn;
	}

	/**
	 * Sets the 标志符，用于授权名称（类似module:save）.
	 * 
	 * @param sn
	 *            the new 标志符，用于授权名称（类似module:save）
	 */
	public void setSn(String sn) {
		this.sn = sn;
	}

	/**
	 * Gets the 模块的排序号,越小优先级越高.
	 * 
	 * @return the 模块的排序号,越小优先级越高
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets the 模块的排序号,越小优先级越高.
	 * 
	 * @param priority
	 *            the new 模块的排序号,越小优先级越高
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * Gets the 父类关联ID.
	 * 
	 * @return the 父类关联ID
	 */
	public Module getParent() {
		return parent;
	}

	/**
	 * Sets the 父类关联ID.
	 * 
	 * @param parent
	 *            the new 父类关联ID
	 */
	public void setParent(Module parent) {
		this.parent = parent;
	}

	/**
	 * Gets the 子模块集合.
	 * 
	 * @return the 子模块集合
	 */
	public List<Module> getChildren() {
		return children;
	}

	/**
	 * Sets the 子模块集合.
	 * 
	 * @param children
	 *            the new 子模块集合
	 */
	public void setChildren(List<Module> children) {
		this.children = children;
	}

	/**
	 * Gets the 权限集合.
	 * 
	 * @return the 权限集合
	 */
	public List<Permission> getPermissions() {
		return permissions;
	}

	/**
	 * Sets the 权限集合.
	 * 
	 * @param permissions
	 *            the new 权限集合
	 */
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Module m) {
		if (m == null) {
			return -1;
		} else if (m == this) {
			return 0;
		} else if (this.priority < m.getPriority()) {
			return -1;
		} else if (this.priority > m.getPriority()) {
			return 1;
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(id).addValue(name)
				.addValue(parent == null ? null : parent.getName()).addValue(children.size())
				.toString();
	}
}
