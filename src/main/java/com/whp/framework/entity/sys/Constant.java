package com.whp.framework.entity.sys;

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
import org.hibernate.annotations.Index;

import com.google.common.collect.Lists;
import com.whp.framework.entity.IdLongEntity;

// TODO: Auto-generated Javadoc
/**
 * 初始系统变量设置.
 * @author zpfox
 * @version 1.0
 * @updated 29-七月-2014 13:01:32
 */
@Entity@Table(name = "Config_CONSTANT")@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.sys")
public class Constant extends IdLongEntity
{
    
    private static final long serialVersionUID = 1L;
    
    /** 变量编码. */
    @Column(name = "Code", nullable = false, length = 32)@Index(name = "Config_Constant_Code")
	private String code;
    
    /** 变量对应的值. */
    @Column(name = "Value", length = 32)
	private String value;
    
    /** 父对象. */
    @ManyToOne@JoinColumn(name = "parentId")
	private Constant parent;
    
    /** 自关联对象集合. */
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "parent")@OrderBy("id ASC")
	private List<Constant> children = Lists.newArrayList();
    
    /** 变量名称. */
    @Column(name = "Name", length = 32, unique = true, nullable = false)
	private String name;
    
    /** 是否是系统变量，如果是则不允许删除. */
    @Column(name = "IsSystem")
	private Boolean isSystem;
    
    /** 备注. */
    @Column(name = "Remark", length = 256)
	private String remark;
    
    /** Hibernate乐观锁由系统自动维护，无需人工干预. */
    
    /*--------------------------getter and setter-----------------------------*/

    /**
     * Gets the 变量编码.
     *
     * @return the 变量编码
     */
    public String getCode()
    {
        return code;
    }
    
    /**
     * Sets the 变量编码.
     *
     * @param code the new 变量编码
     */
    public void setCode(String code)
    {
        this.code = code;
    }
    
    /**
     * Gets the 变量对应的值.
     *
     * @return the 变量对应的值
     */
    public String getValue()
    {
        return value;
    }
    
    /**
     * Sets the 变量对应的值.
     *
     * @param value the new 变量对应的值
     */
    public void setValue(String value)
    {
        this.value = value;
    }
    
    /**
     * Gets the 变量名称.
     *
     * @return the 变量名称
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets the 变量名称.
     *
     * @param name the new 变量名称
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Gets the 是否是系统变量，如果是则不允许删除.
     *
     * @return the 是否是系统变量，如果是则不允许删除
     */
    public Boolean getIsSystem()
    {
        return isSystem;
    }
    
    /**
     * Sets the 是否是系统变量，如果是则不允许删除.
     *
     * @param isSystem the new 是否是系统变量，如果是则不允许删除
     */
    public void setIsSystem(Boolean isSystem)
    {
        this.isSystem = isSystem;
    }
    
    /**
     * Gets the 备注.
     *
     * @return the 备注
     */
    public String getRemark()
    {
        return remark;
    }
    
    /**
     * Gets the 父对象.
     *
     * @return the 父对象
     */
    public Constant getParent()
    {
        return parent;
    }
    
    /**
     * Sets the 父对象.
     *
     * @param parent the new 父对象
     */
    public void setParent(Constant parent)
    {
        this.parent = parent;
    }
    
    /**
     * Gets the 自关联对象集合.
     *
     * @return the 自关联对象集合
     */
    public List<Constant> getChildren()
    {
        return children;
    }
    
    /**
     * Sets the 自关联对象集合.
     *
     * @param children the new 自关联对象集合
     */
    public void setChildren(List<Constant> children)
    {
        this.children = children;
    }
    
    /**
     * Sets the 备注.
     *
     * @param remark the new 备注
     */
    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}
