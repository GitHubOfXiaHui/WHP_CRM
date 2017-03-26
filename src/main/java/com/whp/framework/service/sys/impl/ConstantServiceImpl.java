package com.whp.framework.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.sys.Constant;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.repository.jpa.sys.ConstantDao;
import com.whp.framework.service.BaseServiceImpl;
import com.whp.framework.service.sys.ConstantService;
import com.whp.framework.utils.dwz.Page;
import com.whp.framework.utils.dwz.PageUtils;

/**
 * 系统常量服务接口实现类
 * @author  zpfox
 * @version  [版本号, 2013-2-10]
 */
@Service
@Transactional
public class ConstantServiceImpl extends BaseServiceImpl<Constant, Long> implements ConstantService
{
    private ConstantDao dao;
    
    @Autowired
    public ConstantServiceImpl(ConstantDao dao)
    {
        super(dao);
        this.dao = dao;
    }
    
    @Override
    public void delete(Long id)
    {
        if (isRoot(id))
        {
            throw new ServiceException("不允许删除根节点。");
        }
        dao.exists(id);
        Constant constant = this.get(id);
        
        //先判断是否存在子模块，如果存在子模块，则不允许删除
        if (constant.getChildren().size() > 0)
        {
            throw new ServiceException(constant.getName() + "分类下存在子节点，不允许删除。");
        }
        
        dao.delete(constant);
    }
    
    private boolean isRoot(Long id)
    {
        return id == 1;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Constant> find(Long parentId)
    {
        return dao.findByParentId(parentId);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Constant> find(Long parentId, Page page)
    {
        org.springframework.data.domain.Page<Constant> p = dao.findByParentId(parentId, PageUtils.createPageable(page));
        PageUtils.injectPageProperties(page, p);
        return p.getContent();
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Constant> find(Long parentId, String name, Page page)
    {
        org.springframework.data.domain.Page<Constant> p =
            dao.findByParentIdAndNameContaining(parentId, name, PageUtils.createPageable(page));
        PageUtils.injectPageProperties(page, p);
        return p.getContent();
    }
    
    @Override
    public Constant getTree()
    {
        List<Constant> list = dao.findAllWithCache();
        
        List<Constant> rootList = makeTree(list);
        if (null == rootList.get(0))
            return null;
        return rootList.get(0);
    }
    
    private List<Constant> makeTree(List<Constant> list)
    {
        List<Constant> parent = new ArrayList<Constant>();
        // get parentId = null;
        for (Constant e : list)
        {
            if (e.getParent() == null)
            {
                e.setChildren(new ArrayList<Constant>(0));
                parent.add(e);
            }
        }
        // 删除parentId = null;
        list.removeAll(parent);
        
        makeChildren(parent, list);
        
        return parent;
    }
    
    private void makeChildren(List<Constant> parent, List<Constant> children)
    {
        if (children.isEmpty())
        {
            return;
        }
        
        List<Constant> tmp = new ArrayList<Constant>();
        for (Constant c1 : parent)
        {
            for (Constant c2 : children)
            {
                c2.setChildren(new ArrayList<Constant>(0));
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
    @Transactional(readOnly = true)
    public Constant findByCode(String code)
    {
        
        Constant obj = dao.findByCode(code);
        if (null == obj)
        {
            throw new ServiceException("没有找到代码:'" + code + "'对应的系统变量！");
        }
        return obj;
    }
    
    @Override
    @Transactional(readOnly = true)
    public boolean existsByCode(String code)
    {
        Constant obj = dao.findByCode(code);
        return null != obj;
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Constant> findByParentCode(String code)
    {
        return dao.findByParentCode(code);
    }
    
    @Override
    public Constant findByName(String type)
    {
        
        return dao.findByName(type);
    }
    
    @Override
    public List<Constant> findByParendId(Long parentId)
    {
        return dao.findByParentId(parentId);
    }
}
