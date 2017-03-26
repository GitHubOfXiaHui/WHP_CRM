/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.entity.main.Organization.java
 * Class:			Organization
 * Date:			2012-8-27
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.whp.framework.entity.main;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * 组织机构.
 * 
 * @since 2012-8-27 下午3:25:15
 */
@Entity
@Table(name = "security_organization")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class Organization extends IdLongEntity {

	/** 描述. */
	private static final long serialVersionUID = -7324011210610828114L;

	/** 机构名称. */
	@NotBlank
	@Length(min = 1, max = 64)
	@Column(nullable = false, length = 64)
	private String name;

	/** 机构代码. */
	@Column(name = "code", length = 20)
	private String code;

	/** 是否是根节点:默认false. */
	@Column
	private Boolean isRoot = false;

	/** 行政区划代码. */
	@Length(max = 10)
	@Column(length = 10)
	private String areaCode;

	/** 行政区划名称. */
	@Length(max = 64)
	@Column(length = 64)
	private String areaName;

	/** 平台自编码,卡号前9位. */
	@Column(name = "ptzbm", length = 20)
	private String ptzbm;

	/** 机构类型. 1、医疗机构 2、供应商 3、银行 4、区级管理机构5、市级管理机构 */
	@Column(name = "jglx", length = 2)
	private String jglx;

	/** 机构描述. */
	@Length(max = 255)
	@Column(length = 255)
	private String description;

	/** 数据初始化标志 1:初始化完成 0:初始化未完成 默认为1. */
	@Column(name = "sjcshbz", length = 1, columnDefinition = "char default '1'")
	private String sjcshbz;

	/** 父机构. */
	@ManyToOne
	@JoinColumn(name = "parentId")
	private Organization parent;

	/** 子机构列表. */
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "parent")
	private List<Organization> children = Lists.newArrayList();

	/** 本机构所属用户列表. */
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "organization")
	private List<User> users = Lists.newArrayList();

	/** 本机构拥有的权限集合. */
	@OneToMany(mappedBy = "organization", cascade = { CascadeType.PERSIST, CascadeType.REMOVE }, orphanRemoval = true)
	@OrderBy("priority ASC")
	private List<OrganizationRole> organizationRoles = Lists.newArrayList();

	/** 流水号. */
	@Column(name = "lsh", columnDefinition = "INT default 0")
	private long lsh;
	
	
	/** 同步标志 1:同步完成 0:未同步 默认为0. */
    @Column(name = "tbbz", length = 1, columnDefinition = "char default '0'")
    private String tbbz;


	/**
	 * Gets the 机构名称.
	 *
	 * @return the 机构名称
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the 机构名称.
	 *
	 * @param name the new 机构名称
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
	 * Gets the 机构描述.
	 *
	 * @return the 机构描述
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Sets the 机构描述.
	 *
	 * @param description the new 机构描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * Gets the 父机构.
	 *
	 * @return the 父机构
	 */
	public Organization getParent() {
		return parent;
	}


	/**
	 * Sets the 父机构.
	 *
	 * @param parent the new 父机构
	 */
	public void setParent(Organization parent) {
		this.parent = parent;
	}


	/**
	 * Gets the 子机构列表.
	 *
	 * @return the 子机构列表
	 */
	public List<Organization> getChildren() {
		return children;
	}


	/**
	 * Sets the 子机构列表.
	 *
	 * @param children the new 子机构列表
	 */
	public void setChildren(List<Organization> children) {
		this.children = children;
	}


	/**
	 * Gets the 本机构所属用户列表.
	 *
	 * @return the 本机构所属用户列表
	 */
	public List<User> getUsers() {
		return users;
	}


	/**
	 * Sets the 本机构所属用户列表.
	 *
	 * @param users the new 本机构所属用户列表
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}


	/**
	 * Gets the 本机构拥有的权限集合.
	 *
	 * @return the 本机构拥有的权限集合
	 */
	public List<OrganizationRole> getOrganizationRoles() {
		return organizationRoles;
	}


	/**
	 * Sets the 本机构拥有的权限集合.
	 *
	 * @param organizationRoles the new 本机构拥有的权限集合
	 */
	public void setOrganizationRoles(List<OrganizationRole> organizationRoles) {
		this.organizationRoles = organizationRoles;
	}

	/**
	 * Gets the 行政区划代码.
	 * 
	 * @return the 行政区划代码
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * Sets the 行政区划代码.
	 * 
	 * @param areaCode
	 *            the new 行政区划代码
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * 得到 行政区划名称.
	 * 
	 * @return 返回 areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * 设置 行政区划名称.
	 *
	 * @param areaName the new 行政区划名称
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 得到 机构代码.
	 *
	 * @return 返回 code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置 机构代码.
	 *
	 * @param code the new 机构代码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 得到 平台自编码卡号前9位.
	 *
	 * @return 返回 ptzbm
	 */
	public String getPtzbm() {
		return ptzbm;
	}

	/**
	 * 设置 平台自编码卡号前9位.
	 *
	 * @param ptzbm the new 平台自编码,卡号前9位
	 */
	public void setPtzbm(String ptzbm) {
		this.ptzbm = ptzbm;
	}

	/**
	 * 得到 机构类型.1、医疗机构2、供应商3、银行4、区级管理机构5、市级管理机构
	 * 
	 * @return 返回 jglx
	 */
	public String getJglx() {
		return jglx;
	}

	/**
	 * 设置 机构类型.1、医疗机构2、供应商3、银行4、区级管理机构5、市级管理机构
	 *
	 * @param jglx the new 机构类型
	 */
	public void setJglx(String jglx) {
		this.jglx = jglx;
	}

	/**
	 * 得到 数据初始化标志1:初始化完成0:初始化未完成默认为1.
	 *
	 * @return 返回 sjcshbz
	 */
	public String getSjcshbz() {
		return sjcshbz;
	}

	/**
	 * 设置 数据初始化标志1:初始化完成0:初始化未完成默认为1.
	 *
	 * @param sjcshbz the new 数据初始化标志 1:初始化完成 0:初始化未完成 默认为1
	 */
	public void setSjcshbz(String sjcshbz) {
		this.sjcshbz = sjcshbz;
	}

	/**
	 * 得到 流水号.
	 *
	 * @return 返回 lsh
	 */
	public long getLsh() {
		return lsh;
	}

	/**
	 * 设置 流水号.
	 *
	 * @param lsh the new 流水号
	 */
	public void setLsh(long lsh) {
		this.lsh = lsh;
	}
	

    /**
     * @return 返回 tbbz
     */
    public String getTbbz()
    {
        return tbbz;
    }


    /**
     * @param 对tbbz进行赋值
     */
    public void setTbbz(String tbbz)
    {
        this.tbbz = tbbz;
    }
    

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Objects.toStringHelper(this).addValue(id).addValue(name)
				.addValue(parent == null ? null : parent.getName())
				// .addValue(children.size())
				.toString();
	}


	
	
}
