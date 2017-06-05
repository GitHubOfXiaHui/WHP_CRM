/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.controller.OrganizationController.java
 * Class:			OrganizationController
 * Date:			2012-8-27
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.whp.framework.controller.main;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.web.Servlets;

import com.google.common.collect.Lists;
import com.whp.framework.SecurityConstants;
import com.whp.framework.controller.BaseController;
import com.whp.framework.entity.main.Organization;
import com.whp.framework.entity.main.OrganizationRole;
import com.whp.framework.entity.main.Role;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.log.Log;
import com.whp.framework.log.LogMessageObject;
import com.whp.framework.log.impl.LogUitl;
import com.whp.framework.service.main.OrganizationRoleService;
import com.whp.framework.service.main.OrganizationService;
import com.whp.framework.service.main.RoleService;
import com.whp.framework.utils.dwz.AjaxObject;
import com.whp.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-27 下午4:10:26 
 */
@Controller
@RequestMapping("/management/security/organization")
public class OrganizationController extends BaseController
{
    @Autowired
    private OrganizationService organizationService;
    
    @Autowired
    private OrganizationRoleService organizationRoleService;
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    private Validator validator;
    
    private static final String CREATE = "management/security/organization/create";
    
    private static final String UPDATE = "management/security/organization/update";
    
    private static final String LIST = "management/security/organization/list";
    
    private static final String TREE = "management/security/organization/tree";
    
    private static final String TREE_LIST = "management/security/organization/tree_list";
    
    private static final String LOOK_UP_ROLE = "management/security/organization/assign_organization_role";
    
    private static final String LOOK_ORGANIZATION_ROLE = "management/security/organization/delete_organization_role";
    
    private static final String LOOKUP_PARENT = "management/security/organization/lookup_parent";
    
    private static final String IMPORTINFO = GET_PAGE_PATH("/management/security/organization", "importInfo");
    
    /**行政区划信息查找带回页面. */
    protected static final String LOOKLIST = "management/security/organization/xzqh_lookuplist";
    
    @RequiresPermissions("Organization:save")
    @RequestMapping(value = "/create/{parentOrganizationId}", method = RequestMethod.GET)
    public String preCreate(@PathVariable
    Long parentOrganizationId, Map<String, Object> map)
    {
        map.put("parentOrganizationId", parentOrganizationId);
        return CREATE;
    }
    
    @Log(message = "添加了{0}组织。")
    @RequiresPermissions("Organization:save")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    String create(Organization organization)
    {
        BeanValidators.validateWithException(validator, organization);
        
        Organization parentOrganization = organizationService.get(organization.getParent().getId());
        if (parentOrganization == null)
        {
            return AjaxObject.newError("添加组织失败：id=" + organization.getParent().getId() + "的父组织不存在！").toString();
        }
        if (StringUtils.length(organization.getName()) > 15)
        {
            return AjaxObject.newError("机构名称长度不能大于15！").toString();
        }
        organization.setTbbz("0");
        organizationService.save(organization);
        
        SecurityConstants.ptzbmHashSet.add(organization.getPtzbm());
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {organization.getName()}));
        return AjaxObject.newOk("添加组织成功！").toString();
    }
    
    @RequiresPermissions("Organization:save")
    @RequestMapping(value = "/preImportInfo/{parentOrganizationId}", method = {RequestMethod.GET})
    public String IMPORTINFO(@PathVariable
    Long parentOrganizationId, Map<String, Object> map)
    {
        map.put("parentOrganizationId", parentOrganizationId);
        return IMPORTINFO;
    }
    
    /**
     * 下载导入模版
     */
    @RequiresPermissions("Organization:view")
    @RequestMapping(value = "/download/{fileName}", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String downloadTemplate(@PathVariable("fileName")
    String fileName, HttpServletResponse response, HttpServletRequest request)
        throws IOException
    {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        // 设置导出文件名
        fileName = fileName + ".xlsx";
        String ctxPath = request.getSession().getServletContext().getRealPath("/") + "\\" + "templates\\";
        String downLoadPath = ctxPath + fileName;
        try
        {
            long fileLength = new File(downLoadPath).length();
            
            response.setContentType("application/msexcel; charset=utf-8");
            response.setHeader("Content-disposition", "attachment; filename="
                + new String(fileName.getBytes("utf-8"), "ISO8859-1"));
            response.setHeader("Content-Length", String.valueOf(fileLength));
            bis = new BufferedInputStream(new FileInputStream(downLoadPath));
            bos = new BufferedOutputStream(response.getOutputStream());
            byte[] buff = new byte[2048];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length)))
            {
                bos.write(buff, 0, bytesRead);
            }
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
    
    @Log(message = "导入{0}组织。")
    @RequiresPermissions("Organization:save")
    @RequestMapping(value = "/importOrganization", method = RequestMethod.POST)
    public @ResponseBody
    String importOrganization(HttpServletRequest request, Map<String, Object> map)
    {
        
        try
        {
            // 获得页面提交的file
            MultipartHttpServletRequest multipartRequest = null;
            MultipartFile multipartFile = null;
            // 获得页面提交的file
            multipartRequest = (MultipartHttpServletRequest)request;
            multipartFile = multipartRequest.getFile("importFile");
            String result = null;
            if (multipartFile.isEmpty())
            {
                return AjaxObject.newError("没有选择上传文件！").toString();
            }
            else
            {
                result =
                    organizationService.exportRegMedicalOrgItem(multipartFile.getInputStream(),
                        multipartFile.getOriginalFilename(),
                        request.getParameter("parentid").toString());
                
            }
            
            return result;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            if (null != e.getMessage() && e.getMessage().indexOf("WindowTwoRecord") > 1)
            {
                return AjaxObject.newError("excel文件版本太老，请在本机上另存为后，重新上传!").toString();
            }
            else if (null == e.getMessage())
            {
                return AjaxObject.newError("导入文件出错").toString();
            }
            return AjaxObject.newError(e.getMessage()).toString();
        }
    }
    
    @RequiresPermissions("Organization:edit")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String preUpdate(@PathVariable
    Long id, Map<String, Object> map)
    {
        Organization organization = organizationService.get(id);
        
        map.put("organization", organization);
        return UPDATE;
    }
    
    @Log(message = "修改了{0}组织的信息。")
    @RequiresPermissions("Organization:edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    String update(Organization organization)
    {
        BeanValidators.validateWithException(validator, organization);
        if (StringUtils.length(organization.getName()) > 15)
        {
            return AjaxObject.newError("机构名称长度不能大于15！").toString();
        }
        organization.setTbbz("0");
        organizationService.update(organization);
        SecurityConstants.ptzbmHashSet.add(organization.getPtzbm());
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {organization.getName()}));
        return AjaxObject.newOk("修改组织成功！").toString();
    }
    
    @Log(message = "删除了{0}组织。")
    @RequiresPermissions("Organization:delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public @ResponseBody
    String delete(@PathVariable
    Long id)
    {
        Organization organization = organizationService.get(id);
        try
        {
            SecurityConstants.ptzbmHashSet.remove(organization.getPtzbm());
            organizationService.delete(id);
            
        }
        catch (ServiceException e)
        {
            return AjaxObject.newError("删除组织失败：" + e.getMessage()).setCallbackType("").toString();
        }
        
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {organization.getName()}));
        return AjaxObject.newOk("删除组织成功！").setCallbackType("").toString();
    }
    
    @RequiresPermissions("Organization:view")
    @RequestMapping(value = "/tree_list", method = {RequestMethod.GET, RequestMethod.POST})
    public String tree_list(Map<String, Object> map)
    {
        return TREE_LIST;
    }
    
    @RequiresPermissions("Organization:view")
    @RequestMapping(value = "/tree", method = {RequestMethod.GET, RequestMethod.POST})
    public String tree(Map<String, Object> map)
    {
        Organization organization = organizationService.getTree();
        
        map.put("organization", organization);
        return TREE;
    }
    
    @RequiresPermissions("Organization:view")
    @RequestMapping(value = "/list/{parentOrganizationId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Page page, @PathVariable
    Long parentOrganizationId, String keywords, Map<String, Object> map, ServletRequest request)
    {
        List<Organization> organizations = null;
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        
        if (searchParams.size() > 0)
        {
            map.putAll(searchParams);
            organizations = organizationService.findByFilterJpa(page, searchParams);
        }
        else
        {
            searchParams.put("EQ_parent", parentOrganizationId);
            organizations = organizationService.findByFilterJpa(page, searchParams);
        }
        
        map.put("page", page);
        map.put("organizations", organizations);
        map.put("keywords", keywords);
        map.put("parentOrganizationId", parentOrganizationId);
        
        return LIST;
    }
    
    /**
     * 给组织分配权限
     * 描述
     * @param userRole
     */
    @Log(message = "向{0}组织分配了{1}的角色。")
    @RequiresPermissions("Organization:assign")
    @RequestMapping(value = "/create/organizationRole", method = {RequestMethod.POST})
    public @ResponseBody
    void assignRole(OrganizationRole organizationRole)
    {
        organizationRoleService.save(organizationRole);
        
        Organization organization = organizationService.get(organizationRole.getOrganization().getId());
        Role role = roleService.get(organizationRole.getRole().getId());
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {organization.getName(), role.getName()}));
    }
    
    /**
     * 展示没有分配到组织的其他权限
     * 描述
     * @param map
     * @param organizationId
     * @return
     */
    @RequiresPermissions("Organization:assign")
    @RequestMapping(value = "/lookup2create/organizationRole/{organizationId}", method = {RequestMethod.GET,
        RequestMethod.POST})
    public String listUnassignRole(Map<String, Object> map, @PathVariable
    Long organizationId)
    {
        Page page = new Page();
        page.setNumPerPage(Integer.MAX_VALUE);
        
        List<OrganizationRole> organizationRoles = organizationRoleService.find(organizationId);
        List<Role> roles = roleService.findAll(page);
        
        List<Role> rentList = Lists.newArrayList();
        // 删除已分配roles
        for (Role role : roles)
        {
            boolean isHas = false;
            for (OrganizationRole or : organizationRoles)
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
        
        map.put("organizationRoles", organizationRoles);
        map.put("roles", rentList);
        
        map.put("organizationId", organizationId);
        return LOOK_UP_ROLE;
    }
    
    /**
     * 显示组织已分配的权限
     * 描述
     * @param map
     * @param organizationId
     * @return
     */
    @RequiresPermissions("Organization:assign")
    @RequestMapping(value = "/lookup2delete/organizationRole/{organizationId}", method = {RequestMethod.GET,
        RequestMethod.POST})
    public String listOrganizationRole(Map<String, Object> map, @PathVariable
    Long organizationId)
    {
        List<OrganizationRole> organizationRoles = organizationRoleService.find(organizationId);
        map.put("organizationRoles", organizationRoles);
        return LOOK_ORGANIZATION_ROLE;
    }
    
    /**
     * 删除组织分配的角色
     * 描述
     * @param organizationId
     */
    @Log(message = "撤销了{0}组织的{1}角色。")
    @RequiresPermissions("Organization:assign")
    @RequestMapping(value = "/delete/organizationRole/{organizationRoleId}", method = {RequestMethod.POST})
    public @ResponseBody
    void deleteOrganizationRole(@PathVariable
    Long organizationRoleId)
    {
        OrganizationRole organizationRole = organizationRoleService.get(organizationRoleId);
        LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {
            organizationRole.getOrganization().getName(), organizationRole.getRole().getName()}));
        
        organizationRoleService.delete(organizationRoleId);
    }
    
    @RequiresPermissions(value = {"Organization:edit", "Organization:save"}, logical = Logical.OR)
    @RequestMapping(value = "/lookupParent/{id}", method = {RequestMethod.GET})
    public String lookup(@PathVariable
    Long id, Map<String, Object> map)
    {
        Organization organization = organizationService.getTree();
        
        map.put("organization", organization);
        return LOOKUP_PARENT;
    }
    
    
    /**
     * 验证机构编码唯一
     * 
     * @param entity
     * @return
     */
    @RequiresPermissions("Organization:view")
    @RequestMapping(value = "/checkUnique", method = RequestMethod.POST)
    public @ResponseBody
    String checkUnique(String code)
    {
        
        AjaxObject ajaxObject = new AjaxObject();
        
        Organization organization = organizationService.findByCode(code);
        if (null != organization)
        {
            //            return AjaxObject.newError("相同代码的机构已存在！").toString();
            ajaxObject.setMessage("相同代码的机构已存在！");
            ajaxObject.setCallbackType("");
            ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
            return ajaxObject.toString();
        }
        ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_SUCCESS);
        return ajaxObject.toString();
    }
}
