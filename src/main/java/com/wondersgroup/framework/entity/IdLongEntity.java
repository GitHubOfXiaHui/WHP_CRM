package com.wondersgroup.framework.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略. 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 */
// JPA 基类的标识
@MappedSuperclass
public abstract class IdLongEntity implements Serializable
{
    /** 描述 */
    private static final long serialVersionUID = 8430941165882152228L;
    
    // 当主键ID类型为Long并使用Oracle数据库时使用序列存储主键值
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    
    public Long getId()
    {
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
}
