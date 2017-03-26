/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.UserServiceImpl.java
 * Class:			UserServiceImpl
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.whp.framework.service.main.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.main.User;
import com.whp.framework.exception.ExistedException;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.repository.jpa.main.UserDAO;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.service.main.UserService;
import com.whp.framework.shiro.ShiroDbRealm;
import com.whp.framework.shiro.ShiroDbRealm.HashPassword;
import com.whp.framework.utils.dwz.Page;
import com.whp.framework.utils.dwz.PageUtils;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午3:14:29 
 */
@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService
{
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    
    private UserDAO userDAO;
    
    @Autowired
    private ShiroDbRealm shiroRealm;
    
    /**  
     * 构造函数
     * @param jpaRepository  
     */
    @Autowired
    public UserServiceImpl(UserDAO userDAO)
    {
        super(userDAO);
        this.userDAO = userDAO;
    }
    
    @Override
    public User get(Long id)
    {
        return userDAO.findOne(id);
    }
    
    @Override
    public List<User> findAll(Page page)
    {
        org.springframework.data.domain.Page<User> springDataPage = userDAO.findAll(PageUtils.createPageable(page));
        page.setTotalCount(springDataPage.getTotalElements());
        return springDataPage.getContent();
    }
    
    /**
     * 
     * @param user
     * @throws ExistedException  
     * @see com.whp.framework.service.main.UserService#save(com.whp.framework.entity.main.User)
     */
    public void save(User user)
        throws ExistedException
    {
        if (userDAO.findByUsername(user.getUsername()) != null)
        {
            throw new ExistedException("用户添加失败，登录名：" + user.getUsername() + "已存在。");
        }
        
        if (userDAO.findByRealname(user.getRealname()) != null)
        {
            throw new ExistedException("用户添加失败，真实名：" + user.getRealname() + "已存在。");
        }
        
        //设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
        if (StringUtils.isNotBlank(user.getPlainPassword()) && shiroRealm != null)
        {
            HashPassword hashPassword = ShiroDbRealm.encryptPassword(user.getPlainPassword());
            user.setSalt(hashPassword.salt);
            user.setPassword(hashPassword.password);
        }
        
        userDAO.save(user);
        shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
    }
    
    /**
     * 重置密码为：123456
     * 
     */
    public void restPaw(User user) throws ExistedException
    {
        
        //设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
         
        HashPassword hashPassword = ShiroDbRealm.encryptPassword("123456");
        user.setSalt(hashPassword.salt);
        user.setPassword(hashPassword.password);
        
        userDAO.save(user);
        shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
    }
    
    
    /**   
     * @param user  
     * @see com.whp.framework.service.main.UserService#update(com.whp.framework.entity.main.User)  
     */
    public void update(User user)
    {
        userDAO.save(user);
        shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
    }
    
    /**
     * 
     * @param user
     * @param newPwd
     * @throws ServiceException  
     * @see com.whp.framework.service.main.UserService#updatePwd(com.whp.framework.entity.main.User, java.lang.String)
     */
    @Override
    public void updatePwd(User user, String newPwd)
        throws ServiceException
    {
        if (isSupervisor(user.getId()))
        {
            logger.warn("操作员{},尝试修改超级管理员用户", SecurityUtils.getSubject().getPrincipal());
            throw new ServiceException("不能修改超级管理员用户");
        }
        //设定安全的密码，使用passwordService提供的salt并经过1024次 sha-1 hash
        boolean isMatch = ShiroDbRealm.validatePassword(user.getPlainPassword(), user.getPassword(), user.getSalt());
        if (isMatch)
        {
            HashPassword hashPassword = ShiroDbRealm.encryptPassword(newPwd);
            user.setSalt(hashPassword.salt);
            user.setPassword(hashPassword.password);
            
            userDAO.save(user);
            shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
            
            return;
        }
        
        throw new ServiceException("用户密码错误！");
    }
    
    /**   
     * @param id  
     * @see com.whp.framework.service.main.UserService#delete(java.lang.Long)  
     */
    public void delete(Long id)
        throws ServiceException
    {
        if (isSupervisor(id))
        {
            logger.warn("操作员{}，尝试删除超级管理员用户", SecurityUtils.getSubject().getPrincipal() + "。");
            throw new ServiceException("不能删除超级管理员用户。");
        }
        User user = userDAO.findOne(id);
        userDAO.delete(user.getId());
        
        shiroRealm.clearCachedAuthorizationInfo(user.getUsername());
    }
    
    /**   
     * @param username
     * @return  
     * @see com.whp.framework.service.main.UserService#get(java.lang.String)  
     */
    public User getByUsername(String username)
    {
        return userDAO.findByUsername(username);
    }
    
    /**   
     * @param page
     * @param name
     * @return  
     * @see com.whp.framework.service.main.UserService#find(com.whp.framework.utils.dwz.Page, java.lang.String)  
     */
    public List<User> find(Page page, String name)
    {
        org.springframework.data.domain.Page<User> springDataPage =
            userDAO.findByUsernameContaining(name, PageUtils.createPageable(page));
        page.setTotalCount(springDataPage.getTotalElements());
        return springDataPage.getContent();
    }
    
    /**
     * 判断是否超级管理员.
     */
    public boolean isSupervisor(Long id)
    {
        User user = userDAO.findOne(id);
        if (null != user)
        {
            return user.getIsSupervisor();
        }
        throw new ServiceException("用户不存在!");
    }
    
    /**
     * @return
     * @see com.wondersgroup.card.service.BaseService#findAll()
     */
    @Override
    public List<User> findAll()
    {
        return userDAO.findAll();
    }
    
    @Override
    public User findByAuthKey(String authKey)
    {
        return userDAO.findByAuthKey(authKey);
    }
    
    /* (non-Javadoc)
     * @see com.wondersgroup.framework.service.main.UserService#findByFilterJpa(com.wondersgroup.framework.utils.dwz.Page, java.util.Map)
     */
    @Override
    public List<User> findByFilterJpa(Page page, Map<String, Object> searchParams)
    {
        return super.findByFilterJpa(page, searchParams);
    }
}
