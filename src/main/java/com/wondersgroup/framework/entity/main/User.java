package com.wondersgroup.framework.entity.main;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.google.common.collect.Lists;
import com.wondersgroup.framework.entity.IdLongEntity;

/**
 * 用户信息.
 * 
 * @since 2012-8-2 下午2:44:58
 */
@Entity
@Table(name = "security_user")
// 默认的缓存策略.
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class User extends IdLongEntity
{
    
    /** 描述. */
    private static final long serialVersionUID = -4277639149589431277L;
    
    /** 用户真实姓名. */
    @NotBlank
    @Length(min = 1, max = 32)
    @Column(nullable = false, length = 32, updatable = false)
    private String realname;
    
    /** 系统用户名. */
    @NotBlank
    @Length(min = 1, max = 32)
    @Column(nullable = false, length = 32, unique = true, updatable = false)
    private String username;
    
    /** 用户密码. */
    @Column(nullable = false, length = 64)
    private String password;
    
    /** 确认密码. */
    @Transient
    private String plainPassword;
    
    /** 加密盐值. */
    @Column(nullable = false, length = 32)
    private String salt;
    
    /** 用户电话. */
    @Length(max = 32)
    @Column(length = 32)
    private String phone;
    
    /** The email地址. */
    @Email
    @Length(max = 128)
    @Column(length = 128)
    private String email;
    
    /** 是否是超级用户:默认为false. */
    @Column
    private Boolean isSupervisor = false;
    
    /** 帐号创建时间. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createTime;
    
    /** 使用状态disabled，enabled. */
    @NotBlank
    @Length(max = 16)
    @Column(nullable = false, length = 16)
    private String status = "enabled";
    
    /** 用户归属机构别. 1:操作员，2管理员*/
    @Length(max = 16)
    @Column(length = 16)
    private String userb;
    
    /** 组织归属机构代码. */
    @Length(max = 16)
    @Column(length = 16)
    private String orgb;
    
    /** 用户拥有的角色集合. */
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    @OrderBy("priority ASC")
    private List<UserRole> userRoles = Lists.newArrayList();
    
    /** 用户关联的组织--外键. */
    @ManyToOne
    @JoinColumn(name = "orgId")
    private Organization organization;
    
    /** 接口用户调用接口时对应的验证码. */
    @Column(name = "auth_Key", length = 64)
    private String authKey;
    
    /**
     * Gets the 用户真实姓名.
     * 
     * @return the 用户真实姓名
     */
    public String getRealname()
    {
        return realname;
    }
    
    /**
     * Sets the 用户真实姓名.
     * 
     * @param realname
     *            the new 用户真实姓名
     */
    public void setRealname(String realname)
    {
        this.realname = realname;
    }
    
    /**
     * Gets the 系统用户名.
     * 
     * @return the 系统用户名
     */
    public String getUsername()
    {
        return username;
    }
    
    /**
     * Sets the 系统用户名.
     * 
     * @param username
     *            the new 系统用户名
     */
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    /**
     * Gets the 用户密码.
     * 
     * @return the 用户密码
     */
    public String getPassword()
    {
        return password;
    }
    
    /**
     * Sets the 用户密码.
     * 
     * @param password
     *            the new 用户密码
     */
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    /**
     * Gets the 确认密码.
     * 
     * @return the 确认密码
     */
    public String getPlainPassword()
    {
        return plainPassword;
    }
    
    /**
     * Sets the 确认密码.
     * 
     * @param plainPassword
     *            the new 确认密码
     */
    public void setPlainPassword(String plainPassword)
    {
        this.plainPassword = plainPassword;
    }
    
    /**
     * Gets the 加密盐值.
     * 
     * @return the 加密盐值
     */
    public String getSalt()
    {
        return salt;
    }
    
    /**
     * Sets the 加密盐值.
     * 
     * @param salt
     *            the new 加密盐值
     */
    public void setSalt(String salt)
    {
        this.salt = salt;
    }
    
    /**
     * Gets the 用户电话.
     * 
     * @return the 用户电话
     */
    public String getPhone()
    {
        return phone;
    }
    
    /**
     * Sets the 用户电话.
     * 
     * @param phone
     *            the new 用户电话
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    /**
     * Gets the email地址.
     * 
     * @return the email地址
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Sets the email地址.
     * 
     * @param email
     *            the new email地址
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Gets the 是否是超级用户:默认为false.
     * 
     * @return the 是否是超级用户:默认为false
     */
    public Boolean getIsSupervisor()
    {
        return isSupervisor;
    }
    
    /**
     * Sets the 是否是超级用户:默认为false.
     * 
     * @param isSupervisor
     *            the new 是否是超级用户:默认为false
     */
    public void setIsSupervisor(Boolean isSupervisor)
    {
        this.isSupervisor = isSupervisor;
    }
    
    /**
     * Gets the 帐号创建时间.
     * 
     * @return the 帐号创建时间
     */
    public Date getCreateTime()
    {
        return createTime;
    }
    
    /**
     * Sets the 帐号创建时间.
     * 
     * @param createTime
     *            the new 帐号创建时间
     */
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    /**
     * Gets the 使用状态disabled，enabled.
     * 
     * @return the 使用状态disabled，enabled
     */
    public String getStatus()
    {
        return status;
    }
    
    /**
     * Sets the 使用状态disabled，enabled.
     * 
     * @param status
     *            the new 使用状态disabled，enabled
     */
    public void setStatus(String status)
    {
        this.status = status;
    }
    
    /**
     * Gets the 用户归属机构别. 1:操作员，2管理员
     * 
     * @return the 用户归属机构别
     */
    public String getUserb()
    {
        return userb;
    }
    
    /**
     * Sets the 用户归属机构别. 1:操作员，2管理员
     * 
     * @param userb
     *            the new 用户归属机构别
     */
    public void setUserb(String userb)
    {
        this.userb = userb;
    }
    
    /**
     * Gets the 组织归属机构别.
     * 
     * @return the 组织归属机构别
     */
    public String getOrgb()
    {
        return orgb;
    }
    
    /**
     * Sets the 组织归属机构别.
     * 
     * @param orgb
     *            the new 组织归属机构别
     */
    public void setOrgb(String orgb)
    {
        this.orgb = orgb;
    }
    
    /**
     * Gets the 用户拥有的角色集合.
     * 
     * @return the 用户拥有的角色集合
     */
    public List<UserRole> getUserRoles()
    {
        return userRoles;
    }
    
    /**
     * Sets the 用户拥有的角色集合.
     * 
     * @param userRoles
     *            the new 用户拥有的角色集合
     */
    public void setUserRoles(List<UserRole> userRoles)
    {
        this.userRoles = userRoles;
    }
    
    /**
     * Gets the 用户关联的组织--外键.
     * 
     * @return the 用户关联的组织--外键
     */
    public Organization getOrganization()
    {
        return organization;
    }
    
    /**
     * Sets the 用户关联的组织--外键.
     * 
     * @param organization
     *            the new 用户关联的组织--外键
     */
    public void setOrganization(Organization organization)
    {
        this.organization = organization;
    }
    
    /**
     * Gets the 接口用户调用接口时对应的验证码.
     * 
     * @return the 接口用户调用接口时对应的验证码
     */
    public String getAuthKey()
    {
        return authKey;
    }
    
    /**
     * Sets the 接口用户调用接口时对应的验证码.
     * 
     * @param authKey
     *            the new 接口用户调用接口时对应的验证码
     */
    public void setAuthKey(String authKey)
    {
        this.authKey = authKey;
    }
    
    // 在做debug测试时，可能hibernate默认会调用toString方法，该方法包装了集合的样式，在未打开sessionInView时会造成延迟加载错误，
    // @Override
    // public String toString() {
    // return ToStringBuilder.reflectionToString(this);
    // }
    /**
     * 对部分重要字段做非空验证
     * Organization,Organization().getCode(),Organization().getAreaCode()
     * @return
     * @see [类、类#方法、类#成员]
     */
    public boolean verify()
    {
        if (null != this.getOrganization() && StringUtils.isNotBlank(this.getOrganization().getCode())
            && StringUtils.isNotBlank(this.getOrganization().getAreaCode())
            && StringUtils.isNotBlank(this.getOrganization().getJglx()))
        {
            return true;
        }
        return false;
    }
}
