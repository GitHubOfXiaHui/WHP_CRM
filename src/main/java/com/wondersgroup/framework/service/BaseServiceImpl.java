package com.wondersgroup.framework.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.framework.entity.main.Organization;
import com.wondersgroup.framework.exception.ServiceException;
import com.wondersgroup.framework.repository.jpa.BaseJpaDao;
import com.wondersgroup.framework.utils.dwz.Page;
import com.wondersgroup.framework.utils.dwz.PageUtils;
import com.wondersgroup.framework.utils.jpa.MyDynamicSpecifications;
import com.wondersgroup.framework.utils.jpa.MySearchFilter;

/** 
 * 	
 * @author 	<a href="mailto:zpfox@163.com">zpfox</a>
 * Version  1.1.0
 * @since   2012-10-30 上午11:22:53 
 */
/**
 * 业务处理基类
 * 
 * @author zpfox
 * @version [版本号, 2013-3-26]
 */
@Transactional
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID>
{
    
    private BaseJpaDao<T, ID> baseJpaDao;
    
    public BaseServiceImpl(BaseJpaDao<T, ID> baseJpaDao)
    {
        try
        {
            this.baseJpaDao = baseJpaDao;
        }
        catch (Exception e)
        {
            throw new ServiceException(e);
        }
    }
    
    /**
     * @param entity
     * @see com.zpfox.bms.service.BaseService#save(java.lang.Object)
     */
    @Transactional
    @Override
    public void save(T entity)
    {
        try
        {
            baseJpaDao.save(entity);
        }
        catch (HibernateOptimisticLockingFailureException e)
        {
            throw new ServiceException("当前数据已被更新，请更新后重试！");
        }
        catch (Exception e)
        {
            throw new ServiceException(e);
        }
    }
    
    /**
    * @param entity
    * @see com.zpfox.bms.service.BaseService#save(java.lang.Object)
    */
    @Transactional
    @Override
    public T saveAndReturn(T entity)
    {
        try
        {
            return baseJpaDao.save(entity);
        }
        catch (HibernateOptimisticLockingFailureException e)
        {
            throw new ServiceException("当前数据已被更新，请更新后重试！");
        }
        catch (Exception e)
        {
            throw new ServiceException(e);
        }
    }
    
    /**
     * @param entity
     * @see com.zpfox.bms.service.BaseService#update(java.lang.Object)
     */
    @Transactional
    @Override
    public void update(T entity)
    {
        try
        {
            baseJpaDao.save(entity);
        }
        catch (Exception e)
        {
            throw new ServiceException(e);
        }
    }
    
    /**
     * @param id
     * @see com.zpfox.bms.service.BaseService#delete(java.io.Serializable)
     */
    @Transactional
    @Override
    public void delete(ID id)
    {
        try
        {
            baseJpaDao.delete(id);
        }
        catch (Exception e)
        {
            throw new ServiceException(e);
        }
        
    }
    
    /**
     * 批量删除
     */
    @Override
    public int deleteMany(ID[] ids)
    {
        for (ID id : ids)
        {
            baseJpaDao.delete(id);
        }
        return ids.length;
    }
    
    /**
     * @param id
     * @return
     * @see com.zpfox.bms.service.BaseService#get(java.io.Serializable)
     */
    @Override
    @Transactional(readOnly = true)
    public T get(ID id)
    {
        return baseJpaDao.findOne(id);
    }
    
    /**
     * @return
     * @see com.zpfox.bms.service.BaseService#findAll()
     */
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll()
    {
        return baseJpaDao.findAll();
    }
    
    /**
     * @param page
     * @return
     * @see com.zpfox.bms.service.BaseService#findAll(com.zpfox.util.dwz.Page)
     */
    @Override
    @Transactional(readOnly = true)
    public List<T> findAll(Page page)
    {
        org.springframework.data.domain.Page<T> springDataPage = baseJpaDao.findAll(PageUtils.createPageable(page));
        PageUtils.injectPageProperties(page, springDataPage);
        return springDataPage.getContent();
    }
    
    @Override
    public <S extends T> List<S> save(Iterable<S> entities)
    {
        return baseJpaDao.save(entities);
    }
    
    /**
     * 创建分页请求.
     */
    protected PageRequest buildPageRequest(int pageNum, int numPerPage, String orderField)
    {
        Sort sort = null;
        if (StringUtils.isBlank(orderField) || "".equals(orderField))
        {
            sort = new Sort(Direction.DESC, "id");
        }
        else
        {
            sort = new Sort(Direction.ASC, orderField);
        }
        
        return new PageRequest(pageNum - 1, numPerPage, sort);
    }
    
    /**
     * 创建分页请求--方法重载-将页面的dwz.Page对象转为Spring 的PageRequest对象.
     */
    protected PageRequest buildPageRequest(Page page)
    {
        return this.buildPageRequest(page.getPageNum(), page.getNumPerPage(), page.getOrderField());
    }
    
    /**
     * JPA方式--创建动态查询条件组合.
     * 
     * @param searchParams
     * @return
     */
    protected Specification<T> buildSpecification(Map<String, Object> searchParams, Class<T> clazz)
    {
        Map<String, MySearchFilter> filters = MySearchFilter.parse(searchParams);
        Specification<T> spec = MyDynamicSpecifications.byMySearchFilter(filters.values(), clazz);
        return spec;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<T> findByFilterJpa(Page page, Map<String, Object> searchParams)
    {
        Specification<T> spec = buildSpecification(searchParams, getObjClass());
        org.springframework.data.domain.Page<T> springDataPage =
            baseJpaDao.findAll(spec, PageUtils.createPageable(page));
        page.setTotalCount(springDataPage.getTotalElements());
        return springDataPage.getContent();
    }
    
    /**
     * 获得泛型的Class
     * 
     * @return
     */
    @SuppressWarnings("unchecked")
    protected Class<T> getObjClass()
    {
        return (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    /**
     * Verify.
     * 
     * @param id
     *            the id
     * @return the reg medical org
     */
    protected T verify(ID id)
    {
        
        if (StringUtils.isEmpty(String.valueOf(id)))
        {
            throw new ServiceException("参数不能为空！");
        }
        T obj = get(id);
        if (null == obj)
        {
            throw new ServiceException("对象已删除或不存在，请重新查询！");
        }
        return obj;
    }
    
    /**
     * Verify.
     * 
     * @param ids
     *            the ids
     * @return the list
     */
    protected List<T> verify(String[] ids)
    {
        if (ids.length == 0)
        {
            throw new ServiceException("参数不能为空！");
        }
        List<T> objList = baseJpaDao.findByIdIn(ids);
        if (ids.length == objList.size())
        {
            return objList;
        }
        else
        {
            throw new ServiceException("对象中存在已删除或不存在的数据，请重新查询！");
        }
    }
    
    /**
     * Verify.
     * 
     * @param obj
     *            the obj
     */
    protected void verify(T obj)
    {
        if (null == obj)
        {
            throw new ServiceException("参数不能为空！");
        }
    }
    
    /**
     * 辅助方法，找到用户的跟组织并取值
     * @param organization
     * @param resultMap 
     * @return
     */
    protected Map<String, String> getValues(Organization organization, Map<String, String> resultMap)
    {
        if (organization.getCode().length() > 9 && StringUtils.contains(organization.getCode(), "_"))
        {
            getValues(organization.getParent(), resultMap);
        }
        else
        {
            resultMap.put("areaCode", organization.getAreaCode());
            resultMap.put("orgcode", organization.getCode());
            resultMap.put("orgname", organization.getName());
        }
        return resultMap;
    }
    
    @Override
    public void delete(T entity)
    {
        baseJpaDao.delete(entity);
    }
    
    @Override
    public void deleteMany(Iterable<T> entities)
    {
        baseJpaDao.delete(entities);
    }
    
    @Override
    public void analysisFile(String dataType)
    {
        System.out.println("哈哈!!!哥什么都不做！");
    }
}