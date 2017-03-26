package com.whp.framework.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.whp.framework.entity.RecordObject;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.repository.jpa.BaseJpaDao;
import com.whp.framework.service.StatusDefinition.RegStatus;
import com.whp.framework.shiro.ShiroDbRealm.ShiroUser;
import com.whp.framework.utils.dwz.Page;

@Transactional
public abstract class DefaultAuditFlowServiceImpl<T extends RecordObject, ID extends Serializable> extends
    BaseServiceImpl<T, ID> implements DefaultAuditFlowService<T, ID>
{
    @Autowired
    protected StatusDefinition<T> flowProcess;
    
    public DefaultAuditFlowServiceImpl(BaseJpaDao<T, ID> baseJpaDao)
    {
        super(baseJpaDao);
    }
    
    @Override
    public void register(T obj, ShiroUser shiroUser)
    {
        
        if (!StringUtils.equals(obj.getStatus(), RegStatus.OPER_SAVE.getCode()))
        {
            throw new ServiceException("该对象的状态为:" + RegStatus.getName(obj.getStatus()) + "不能重新注册!");
        }
        T entity = makeCode(obj, shiroUser.getUser().getOrganization().getAreaCode());
        entity.setCreateUser(shiroUser.getLoginName());
        entity.setCreateDate(new Date());
        super.save(entity);
    }
    
    @Override
    public void submit(ID id, ShiroUser shiroUser)
    {
        T obj = flowProcess.manageOper(verify(id), RegStatus.OPER_SUBMIT.getCode());
        obj.setSubmitUser(shiroUser.getLoginName());
        obj.setSubmitDate(new Date());
        super.save(obj);
    }
    
    @Override
    public void batchSubmit(String[] ids, ShiroUser shiroUser)
    {
        List<T> objList = Lists.newArrayList();
        // 对已验证过的对象集合操作
        for (T obj : verify(ids))
        {
            obj = flowProcess.manageOper(obj, RegStatus.OPER_SUBMIT.getCode());
            obj.setSubmitDate(new Date());// 设置提交日期
            obj.setSubmitUser(shiroUser.getLoginName());
            objList.add(obj);// 默认提交流程处理
        }
        super.save(objList);
    }
    
    @Override
    public T auditing(ID id, ShiroUser shiroUser)
    {
        // 默认审核流程处理
        T obj = flowProcess.manageOper(verify(id), RegStatus.OPER_AUDIT.getCode());
        obj.setAuditUser(shiroUser.getLoginName());// 设置审核人
        obj.setAuditDate(new Date());// 设置审核日期
        super.save(obj);
        return obj;
    }
    
    @Override
    public void rejecting(T obj, ShiroUser shiroUser)
    {
        verify(obj);
        //驳回操作必须输入驳回原因
        if (StringUtils.isBlank(obj.getRejectExplain()))
        {
            throw new ServiceException("驳回操作必须输入驳回原因！");
        }
        // 默认审核流程处理
        obj = flowProcess.manageOper(obj, RegStatus.OPER_REJECT.getCode());
        obj.setRejectUser(shiroUser.getLoginName());// 设置驳回人
        obj.setRejectDate(new Date());// 设置驳回日期
        super.save(obj);
    }
    
    @Override
    public void obsolete(T obj, ShiroUser shiroUser)
    {
        verify(obj);//验证传入参数是否为null
        //作废操作必须输入作废原因
        if (StringUtils.isBlank(obj.getObsoleteExplain()))
        {
            throw new ServiceException("作废操作必须输入作废原因！");
        }
        // 默认审核流程处理
        obj = flowProcess.manageOper(obj, RegStatus.OPER_OBSOLETE.getCode());
        obj.setObsoleteUser(shiroUser.getLoginName());// 设置作废操作人
        obj.setObsoleteDate(new Date());// 设置作废日期
        super.save(obj);
    }
    
    @Override
    public void update(T entity)
    {
        super.update(entity);
    }
    
    @Override
    public void delete(ID id)
    {
        super.delete(id);
    }
    
    @Override
    public void batchDelete(ID[] ids)
    {
        super.deleteMany(ids);
    }
    
    @Override
    @Transactional(readOnly = true)
    public T findById(ID id)
    {
        return super.get(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<T> findByFilterJpa(Page page, Map<String, Object> searchParams)
    {
        if (null != searchParams)
        {
            String startDate = (String)searchParams.get("startDate");
            String endDate = (String)searchParams.get("endDate");
            String status = (String)searchParams.get("EQ_status");
            searchParams.remove("startDate");
            searchParams.remove("endDate");
            try
            {
                if (StringUtils.isBlank(status) || "10".equals(status))
                {
                    if (StringUtils.isNotBlank(startDate))
                    {
                        searchParams.put("GTE_createDate", startDate);
                    }
                    if (StringUtils.isNotBlank(endDate))
                    {
                        searchParams.put("LTE_createDate", endDate);
                    }
                }
                else if ("20".equals(status))
                {
                    if (StringUtils.isNotBlank(startDate))
                    {
                        searchParams.put("GTE_submitDate", startDate);
                    }
                    if (StringUtils.isNotBlank(endDate))
                    {
                        searchParams.put("LTE_submitDate", endDate);
                    }
                }
                else if ("30".equals(status))
                {
                    if (StringUtils.isNotBlank(startDate))
                    {
                        searchParams.put("GTE_auditDate", startDate);
                    }
                    if (StringUtils.isNotBlank(endDate))
                    {
                        searchParams.put("LTE_auditDate", endDate);
                    }
                }
                else
                {
                    if (StringUtils.isNotBlank(startDate))
                    {
                        searchParams.put("GTE_obsoleteDate", startDate);
                    }
                    if (StringUtils.isNotBlank(endDate))
                    {
                        searchParams.put("LTE_obsoleteDate", endDate);
                    }
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return super.findByFilterJpa(page, searchParams);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<T> findAllByPage(Page page)
    {
        return super.findAll(page);
    }
    
    /**
     * 由子类完成对传入的对象设置生成代码的操作；
     * @param obj
     * @param param 可为空,用于生成代码时的组成部分
     * @return
     */
    protected abstract T makeCode(T obj, String param);
}
