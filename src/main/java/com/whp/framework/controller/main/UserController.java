/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.controller.UserController.java
 * Class:			UserController
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.whp.framework.controller.main;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Lists;
import com.whp.framework.SecurityConstants;
import com.whp.framework.entity.main.Organization;
import com.whp.framework.entity.main.Role;
import com.whp.framework.entity.main.User;
import com.whp.framework.entity.main.UserRole;
import com.whp.framework.exception.ExistedException;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.log.Log;
import com.whp.framework.log.LogMessageObject;
import com.whp.framework.log.impl.LogUitl;
import com.whp.framework.service.main.OrganizationService;
import com.whp.framework.service.main.RoleService;
import com.whp.framework.service.main.UserRoleService;
import com.whp.framework.service.main.UserService;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-7 下午3:12:23 
 */
@Controller
@RequestMapping("/management/security/user")
public class UserController
{
    
    @Autowired
    private UserService userService;
    
    @Autowired
    UserRoleService userRoleService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private OrganizationService organizationService;
    
    @Autowired
    private Validator validator;
    
    private static final String CREATE = "management/security/user/create";
    
    private static final String UPDATE = "management/security/user/update";
    
    private static final String LIST = "management/security/user/list";
    
    private static final String LOOK_UP_ROLE = "management/security/user/assign_user_role";
    
    private static final String LOOK_USER_ROLE = "management/security/user/delete_user_role";
    
    private static final String LOOK_ORG = "management/security/user/lookup_org";
    
    @RequiresPermissions("User:save")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String preCreate()
    {
        return CREATE;
    }
    
    @Log(message = "添加了{0}用户。")
    @RequiresPermissions("User:save")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    String create(User user)
    {
        BeanValidators.validateWithException(validator, user);
        user.setCreateTime(new Date());
        try
        {
            user.setUsername(user.getUsername().trim());
            userService.save(user);
        }
        catch (ExistedException e)
        {
            return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
        }
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {user.getUsername()}));
        return AjaxObject.newOk("添加用户成功！").toString();
    }
    
    @ModelAttribute("preloadUser")
    public User getOne(@RequestParam(value = "id", required = false)
    Long id)
    {
        if (id != null)
        {
            User user = userService.get(id);
            user.setOrganization(null);
            return user;
        }
        return null;
    }
    
    @RequiresPermissions("User:edit")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String preUpdate(@PathVariable
    Long id, Map<String, Object> map)
    {
        User user = userService.get(id);
        
        map.put("user", user);
        return UPDATE;
    }
    
    @Log(message = "修改了{0}用户的信息。")
    @RequiresPermissions("User:edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    String update(@ModelAttribute("preloadUser")
    User user)
    {
        BeanValidators.validateWithException(validator, user);
        userService.update(user);
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {user.getUsername()}));
        return AjaxObject.newOk("修改用户成功！").toString();
    }
    
    @Log(message = "删除了{0}用户。")
    @RequiresPermissions("User:delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public @ResponseBody
    String delete(@PathVariable
    Long id)
    {
        User user = null;
        try
        {
            user = userService.get(id);
            userService.delete(user.getId());
        }
        catch (ServiceException e)
        {
            return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
        }
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {user.getUsername()}));
        return AjaxObject.newOk("删除用户成功！").setCallbackType("").toString();
    }
    
    @Log(message = "删除了{0}用户。")
    @RequiresPermissions("User:delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    String deleteMany(Long[] ids)
    {
        String[] usernames = new String[ids.length];
        try
        {
            for (int i = 0; i < ids.length; i++)
            {
                User user = userService.get(ids[i]);
                userService.delete(user.getId());
                
                usernames[i] = user.getUsername();
            }
        }
        catch (ServiceException e)
        {
            return AjaxObject.newError(e.getMessage()).setCallbackType("").toString();
        }
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {Arrays.toString(usernames)}));
        return AjaxObject.newOk("删除用户成功！").setCallbackType("").toString();
    }
    
    @RequiresPermissions("User:view")
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Page page, Map<String, Object> map, HttpServletRequest request)
    {
        List<User> users = null;
        
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        User user = (User)request.getSession().getAttribute(SecurityConstants.LOGIN_USER);
        page.setOrderField("createTime");
        if (!user.getIsSupervisor())
        {
            
            if (null == user.getUserb() || user.getUserb().equals("1"))
            {
                if (null != user && null != user.getUsername())
                {
                    if (null == searchParams.get("EQ_username"))
                    {
                        searchParams.put("EQ_username", user.getUsername());
                    }
                }
            }
            else if (user.getUserb().equals("2"))
            {
                if (null != user && null != user.getOrgb())
                {
                    if (null == searchParams.get("EQ_orgb"))
                    {
                        searchParams.put("EQ_orgb", user.getOrganization().getCode());
                    }
                }
            }
            
        }
        
        if (searchParams.size() > 0)
        {
            map.putAll(searchParams);
            users = userService.findByFilterJpa(page, searchParams);
        }
        else
        {
            users = userService.findAll(page);
        }
        
        map.put("page", page);
        map.put("users", users);
        //map.put("keywords", keywords);
        return LIST;
    }
    
    @Log(message = "{0}用户{1}")
    @RequiresPermissions("User:reset")
    @RequestMapping(value = "/reset/{type}/{userId}", method = RequestMethod.POST)
    public @ResponseBody
    String reset(@PathVariable
    String type, @PathVariable
    Long userId)
    {
        //得到当前用户信息
        User user = userService.get(userId);
        
        AjaxObject ajaxObject = new AjaxObject();
        ajaxObject.setCallbackType("");
        
        if (type.equals("password"))
        {
//             user.setPassword("123456");
            //重置密码为123456 并且加密保存
            userService.restPaw(user);
            if (StringUtils.isNotBlank(user.getAuthKey()))
            {
                SecurityConstants.userAuthKeyHashMap.remove(user.getAuthKey());
                user.setAuthKey(null);
            }
            ajaxObject.setMessage("重置密码成功，默认为123456！");
        }
        else if (type.equals("status"))
        {
            if (user.getStatus().equals("enabled"))
            {
                user.setStatus("disabled");
                if (StringUtils.isNotBlank(user.getAuthKey()))
                {
                    SecurityConstants.userAuthKeyHashMap.remove(user.getAuthKey());
                    user.setAuthKey(null);
                }
            }
            else
            {
                user.setStatus("enabled");
            }
            
            ajaxObject.setMessage("更新状态成功，当前为" + (user.getStatus().equals("enabled") ? "可用" : "不可用"));
        }
        
        userService.update(user);
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {user.getUsername(),
            ajaxObject.getMessage()}));
        return ajaxObject.toString();
    }
    
    @Log(message = "向{0}用户分配了{1}的角色。")
    @RequiresPermissions("User:assign")
    @RequestMapping(value = "/create/userRole", method = {RequestMethod.POST})
    public @ResponseBody
    void assignRole(UserRole userRole)
    {
        userRoleService.save(userRole);
        
        User user = userService.get(userRole.getUser().getId());
        Role role = roleService.get(userRole.getRole().getId());
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {user.getUsername(), role.getName()}));
    }
    
    @RequiresPermissions("User:assign")
    @RequestMapping(value = "/lookup2create/userRole/{userId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String listUnassignRole(Map<String, Object> map, @PathVariable
    Long userId)
    {
        Page page = new Page();
        page.setNumPerPage(Integer.MAX_VALUE);
        
        List<UserRole> userRoles = userRoleService.find(userId);
        List<Role> roles = roleService.findAll(page);
        
        List<Role> rentList = Lists.newArrayList();
        // 删除已分配roles
        for (Role role : roles)
        {
            boolean isHas = false;
            for (UserRole or : userRoles)
            {
                if (or.getRole().getId().equals(role.getId()))
                {
                    isHas = true;
                    break;
                }
            }
            if (isHas == false)
            {
                rentList.add(role);
            }
        }
        
        map.put("userRoles", userRoles);
        map.put("roles", rentList);
        
        map.put("userId", userId);
        return LOOK_UP_ROLE;
    }
    
    @RequiresPermissions("User:assign")
    @RequestMapping(value = "/lookup2delete/userRole/{userId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String listUserRole(Map<String, Object> map, @PathVariable
    Long userId)
    {
        List<UserRole> userRoles = userRoleService.find(userId);
        map.put("userRoles", userRoles);
        return LOOK_USER_ROLE;
    }
    
    @Log(message = "撤销了{0}用户的{1}角色。")
    @RequiresPermissions("User:assign")
    @RequestMapping(value = "/delete/userRole/{userRoleId}", method = {RequestMethod.POST})
    public @ResponseBody
    void deleteUserRole(@PathVariable
    Long userRoleId)
    {
        UserRole userRole = userRoleService.get(userRoleId);
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {userRole.getUser().getUsername(),
            userRole.getRole().getName()}));
        
        userRoleService.delete(userRoleId);
    }
    
    @RequiresPermissions(value = {"User:edit", "User:save"}, logical = Logical.OR)
    @RequestMapping(value = "/lookup2org", method = {RequestMethod.GET})
    public String lookup(Map<String, Object> map)
    {
        Organization org = organizationService.getTree();
        
        map.put("org", org);
        return LOOK_ORG;
    }
}
