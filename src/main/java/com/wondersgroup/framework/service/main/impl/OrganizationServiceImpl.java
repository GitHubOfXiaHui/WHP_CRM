/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.OrganizationServiceImpl.java
 * Class:			OrganizationServiceImpl
 * Date:			2012-8-27
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.wondersgroup.framework.service.main.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;

import javax.validation.Validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.beanvalidator.BeanValidators;

import com.wondersgroup.framework.SecurityConstants;
import com.wondersgroup.framework.entity.main.Organization;
import com.wondersgroup.framework.exception.ServiceException;
import com.wondersgroup.framework.log.LogMessageObject;
import com.wondersgroup.framework.log.impl.LogUitl;
import com.wondersgroup.framework.repository.jpa.main.OrganizationDAO;
import com.wondersgroup.framework.repository.jpa.main.UserDAO;
import com.wondersgroup.framework.service.BaseServiceImpl;
import com.wondersgroup.framework.service.main.OrganizationService;
import com.wondersgroup.framework.utils.dwz.AjaxObject;
import com.wondersgroup.framework.utils.dwz.Page;
import com.wondersgroup.framework.utils.dwz.PageUtils;
import com.wondersgroup.framework.utils.file.ExcelReader;

/**
 * 
 * @author <a href="mailto:yang-hui@wondersgroup.com">cms</a> Version 1.1.0
 * @since 2012-8-27 下午3:56:46
 */
@Service
@Transactional
public class OrganizationServiceImpl extends BaseServiceImpl<Organization, Long> implements OrganizationService
{
    @Autowired
    public OrganizationServiceImpl(OrganizationDAO organizationDAO)
    {
        super(organizationDAO);
        this.organizationDAO = organizationDAO;
    }
    
    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private OrganizationDAO organizationDAO;
    
    @Autowired
    private ExcelReader excelReader;
    
    @Override
    public void save(Organization organization)
    {
        organizationDAO.save(organization);
    }
    
    @Override
    public Organization get(Long id)
    {
        return organizationDAO.findOne(id);
    }
    
    @Override
    public void update(Organization organization)
    {
        organizationDAO.save(organization);
    }
    
    @Autowired
    private Validator validator;
    
    /**
     * @param id
     * @throws ServiceException
     * @see com.wondersgroup.framework.service.main.OrganizationService#delete(java.lang.Long)
     */
    public void delete(Long id)
        throws ServiceException
    {
        if (isRoot(id))
        {
            throw new ServiceException("不允许删除根组织。");
        }
        
        Organization organization = this.get(id);
        
        // 先判断是否存在子模块，如果存在子模块，则不允许删除
        if (organization.getChildren().size() > 0)
        {
            throw new ServiceException(organization.getName() + "组织下存在子组织，不允许删除。");
        }
        
        if (userDAO.findByOrganizationId(id).size() > 0)
        {
            throw new ServiceException(organization.getName() + "组织下存在用户，不允许删除。");
        }
        
        organizationDAO.delete(organization);
    }
    
    /**
     * @param parentId
     * @param page
     * @return
     * @see com.wondersgroup.framework.service.main.OrganizationService#find(java.lang.Long,
     *      com.wondersgroup.framework.utils.dwz.Page)
     */
    public List<Organization> find(Long parentId, Page page)
    {
        org.springframework.data.domain.Page<Organization> springDataPage =
            organizationDAO.findByParentId(parentId, PageUtils.createPageable(page));
        page.setTotalCount(springDataPage.getTotalElements());
        return springDataPage.getContent();
    }
    
    /**
     * @param parentId
     * @param name
     * @param page
     * @return
     * @see com.wondersgroup.framework.service.main.OrganizationService#find(java.lang.Long,
     *      java.lang.String, com.wondersgroup.framework.utils.dwz.Page)
     */
    public List<Organization> find(Long parentId, String name, Page page)
    {
        org.springframework.data.domain.Page<Organization> springDataPage =
            organizationDAO.findByParentIdAndNameContaining(parentId, name, PageUtils.createPageable(page));
        page.setTotalCount(springDataPage.getTotalElements());
        return springDataPage.getContent();
    }
    
    /**
     * 判断是否是根组织.
     */
    private boolean isRoot(Long id)
    {
        Organization org = organizationDAO.findOne(id);
        if (null != org)
        {
            return org.getIsRoot();
        }
        throw new ServiceException("组织不存在!");
    }
    
    /**
     * 
     * @return
     * @see com.wondersgroup.framework.service.main.OrganizationService#getTree()
     */
    public Organization getTree()
    {
        List<Organization> list = organizationDAO.findAllWithCache();
        
        List<Organization> rootList = makeTree(list);
        
        return rootList.get(0);
    }
    
    public List<Organization> makeTree(List<Organization> list)
    {
        List<Organization> parent = new ArrayList<Organization>();
        // get parentId = null;
        for (Organization e : list)
        {
            if (e.getParent() == null)
            {
                e.setChildren(new ArrayList<Organization>(0));
                parent.add(e);
            }
        }
        // 删除parentId = null;
        list.removeAll(parent);
        
        makeChildren(parent, list);
        
        return parent;
    }
    
    private void makeChildren(List<Organization> parent, List<Organization> children)
    {
        if (children.isEmpty())
        {
            return;
        }
        
        List<Organization> tmp = new ArrayList<Organization>();
        for (Organization c1 : parent)
        {
            for (Organization c2 : children)
            {
                c2.setChildren(new ArrayList<Organization>(0));
                if (c1.getId().equals(c2.getParent().getId()))
                {
                    c1.getChildren().add(c2);
                    tmp.add(c2);
                }
            }
        }
        
        children.removeAll(tmp);
        
        makeChildren(tmp, children);
    }
    
    @Override
    public Organization findByCode(String orgCode)
    {
        return organizationDAO.findByCode(orgCode);
    }
    
    /**
     * 由被观察对象变更而触发的业务逻辑<br>
     * 该类只监测机构注册流程中，已审核的机构
     */
    public void update(Observable obj, Object arg)
    {
        /*        Organization target = null;
                String status = "";
                target = new Organization();*/
        //只监控医疗机构注册对象的 变更
        /*        User user = null;
                if (arg instanceof User)
                {
                    user = (User)arg;
                }
                if (obj instanceof RegAccess)
                {
                    RegAccess temp = new RegAccess();
                    BeanUtils.copyProperties(obj, temp);
                    status = temp.getStatus();
                    if (!"99".equals(status))
                    {
                        target.setCode(temp.getOrgCode());
                        target.setAreaCode(temp.getZipCode());
                        target.setJglx(temp.getJglx());
                        target.setName(temp.getOrgName());
                        target.setSjcshbz("1");
                        Organization parent = null;
                        if ("1".equals(temp.getJglx()))
                        {
                            parent = organizationDAO.findByCode("JG0001");
                            if (null == parent)
                            {
                                parent = new Organization();
                                parent.setName("管理机构");
                                parent.setCode("JG0001");
                                parent.setParent(user.getOrganization().getParent());
                                this.save(parent);
                            }
                        }
                        else if ("2".equals(temp.getJglx()))
                        {
                            parent = organizationDAO.findByCode(user.getOrganization().getParent().getCode() + "_MED");
                            if (null == parent)
                            {
                                parent = new Organization();
                                parent.setName("医疗机构");
                                parent.setCode(user.getOrganization().getParent().getCode() + "_MED");
                                parent.setParent(user.getOrganization().getParent());
                                this.save(parent);
                            }
                        }
                        else if ("3".equals(temp.getJglx()))
                        {
                            parent = organizationDAO.findByCode(user.getOrganization().getParent().getCode() + "_BK");
                            if (null == parent)
                            {
                                parent = new Organization();
                                parent.setName("银行");
                                parent.setCode(user.getOrganization().getParent().getCode() + "_BK");
                                parent.setParent(user.getOrganization().getParent());
                                this.save(parent);
                            }
                        }
                        else if ("4".equals(temp.getJglx()))
                        {
                            parent = organizationDAO.findByCode("JG0004");
                            if (null == parent)
                            {
                                parent = new Organization();
                                parent.setName("供应商");
                                parent.setCode("JG0004");
                                parent.setParent(get(1L));
                                this.save(parent);
                            }
                        }
                        target.setParent(parent);
                    }
                }
                Organization org = organizationDAO.findByCode(target.getCode());
                if (org == null)
                {
                    save(target);
                }
                else
                {
                    if ("99".equals(status))
                        this.delete(org.getId());
                    
                }*/
    }
    
    @Override
    public List<Organization> findByParentId(Long parentId)
    {
        return organizationDAO.findByParentId(parentId);
    }
    
    @Override
    public List<Organization> findAll()
    {
        
        return organizationDAO.findAll();
    }
    
    @Override
    public List<Organization> findByAreaCode(String areaCode)
    {
        return organizationDAO.findByAreaCode(areaCode);
    }
    
    @Override
    public Organization findByAreaCodeAndJglx(String areaCode, String jglx)
    {
        return organizationDAO.findByAreaCodeAndJglx(areaCode, jglx);
    }
    
    @Override
    public boolean isLocal(String yycsdm)
    {
        // TODO Auto-generated method stub
        String areaCode = "%" + StringUtils.substring(yycsdm, 0, 4) + "%";
        List<Organization> list = organizationDAO.findByAreaCode(areaCode);
        if (list.isEmpty())
            return false;
        return true;
    }
    
    @Override
    public String getCityCode(String areaCode)
    {
        if (StringUtils.isNotBlank(areaCode) && areaCode.length() == 6)
        {
            return StringUtils.substring(areaCode, 0, 4) + "00";
        }
        return null;
    }
    
    @Override
    public List<Organization> findByTbbzAndIsRoot(String tbbz, Boolean flag)
    {
        return organizationDAO.findByTbbzAndIsRoot(tbbz, flag);
    }
    
    public String exportRegMedicalOrgItem(InputStream inputStream, String originalFilename, String parentid)
    {
        try
        {
            String[] itemTitle = {"行政区划名称", "行政区划代码", "组织代码", "组织名称", "机构类型", "描述"};
            
            Map<String, Object> result = excelReader.readExcelRegMedicalOrg(inputStream, originalFilename, itemTitle);
            
            Map<Integer, String[]> items = (Map<Integer, String[]>)result.get("content");
            
            String[] val = null;
            int coutSam = 0;
            
            for (Entry<Integer, String[]> entry : items.entrySet())
            {
                val = entry.getValue();
                Organization entityList = findByCode(val[2]);
                if (null != entityList)
                {
                    return AjaxObject.newError("相同代码的机构已存在！第" + (coutSam + 1) + "条数据的机构代码重复,重复的代码为:" + val[0])
                        .toString();
                }
                for (int i = 0; i < val.length; i++)
                {
                    
                    if (i == 0 || i == 1 || i == 2 || i == 3 || i == 4)
                    {
                        if (val[i] == null || "".equals(val[i]))
                        {
                            
                            return AjaxObject.newError("第" + (coutSam + 1) + "条记录的" + itemTitle[i] + "为空 ！").toString();
                        }
                    }
                }
                Organization parentOrganization = get(Long.parseLong(parentid));
                if (parentOrganization == null)
                {
                    return AjaxObject.newError("添加组织失败：id=" + entityList.getParent().getId() + "的父组织不存在！").toString();
                }
                
                coutSam = coutSam + 1;
            }
            
            coutSam = 0;
            for (Entry<Integer, String[]> entry : items.entrySet())
            {
                
                val = entry.getValue();
                Organization organization = new Organization();
                
                organization.setAreaName(val[0]);
                organization.setAreaCode(val[1]);
                organization.setCode(val[2]);
                organization.setName(val[3]);
                organization.setJglx(val[4]);
                organization.setDescription(val[5]);
                Organization parent = new Organization();
                parent.setId(Long.parseLong(parentid));
                organization.setParent(parent);
                organization.setTbbz("0");
                BeanValidators.validateWithException(validator, organization);
                this.save(organization);
                
                SecurityConstants.ptzbmHashSet.add(organization.getPtzbm());
                LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[] {organization.getName()}));
                
                coutSam = coutSam + 1;
                
            }
            
            return AjaxObject.newOk(coutSam + "条记录导入成功 ！")
                .setCallbackType(AjaxObject.CALLBACK_TYPE_CLOSE_CURRENT)
                .toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return AjaxObject.newError("导入文件出错").toString();
        }
    }
}
