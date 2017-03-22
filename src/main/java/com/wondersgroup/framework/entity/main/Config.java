package com.wondersgroup.framework.entity.main;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import com.wondersgroup.framework.entity.IdLongEntity;

/**
 * 页面配置.
 * 
 * 
 */
@Entity
@Table(name = "tb_config")
// 默认的缓存策略.
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class Config extends IdLongEntity
{
    /**
     * 
     */
    private static final long serialVersionUID = -5571317632773270591L;
    
    /** key值. */
    @Length(max = 64)
    @Column(name = "keyConf", length = 64)
    private String key;
    
    /** value值. */
    @Length(max = 1024)
    @Column(name = "valueConf", length = 1024)
    private String value;
    
    /** 有效状态. */
    @Length(max = 1)
    @Column(name = "statusConf", length = 1)
    private String status;
    
    /** 最后更新时间. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatetime")
    private Date updatetime;
    
    /** 描述. */
    @Length(max = 256)
    @Column(name = "descriptionConf", length = 256)
    private String description;
    
    public String getKey()
    {
        return key;
    }
    
    public void setKey(String key)
    {
        this.key = key;
    }
    
    public String getValue()
    {
        return value;
    }
    
    public void setValue(String value)
    {
        this.value = value;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    public Date getUpdatetime()
    {
        return updatetime;
    }
    
    public void setUpdatetime(Date updatetime)
    {
        this.updatetime = updatetime;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
}
