/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.impl.ModuleServiceImpl.java
 * Class:			ModuleServiceImpl
 * Date:			2012-8-6
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.whp.framework.service.main.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.main.Module;
import com.whp.framework.exception.ExistedException;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.repository.jpa.main.ModuleDAO;
import com.whp.framework.service.main.ModuleService;
import com.whp.framework.utils.dwz.Page;
import com.whp.framework.utils.dwz.PageUtils;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-6 上午9:45:28 
 */
@Service
@Transactional
public class ModuleServiceImpl implements ModuleService {
	@Autowired
	private ModuleDAO moduleDAO;
	
	@Override
	public void save(Module module) throws ExistedException {
		if (moduleDAO.findBySn(module.getSn()).size() > 0) {
			throw new ExistedException("已存在sn=" + module.getSn() + "的模块。");
		}
		moduleDAO.save(module);
	}

	@Override
	public Module get(Long id) {
		return moduleDAO.findOne(id);
	}

	@Override
	public void update(Module module) {
		moduleDAO.save(module);
	}

	/**   
	 * @param id
	 * @throws ServiceException  
	 * @see com.whp.framework.service.main.ModuleService#delete(int)  
	 */
	public void delete(Long id) throws ServiceException {
		if (isRoot(id)) {
			throw new ServiceException("不允许删除根模块。");
		}
		
		Module module = this.get(id);
		
		//先判断是否存在子模块，如果存在子模块，则不允许删除
		if(module.getChildren().size() > 0){
			throw new ServiceException(module.getName() + "模块下存在子模块，不允许删除。");
		}
		
		moduleDAO.delete(module);
	}

	/**   
	 * @param parentId
	 * @param page
	 * @return  
	 * @see com.whp.framework.service.main.ModuleService#find(java.lang.Long, com.whp.framework.utils.dwz.Page)  
	 */
	public List<Module> find(Long parentId, Page page) {
		org.springframework.data.domain.Page<Module> springDataPage = 
				moduleDAO.findByParentId(parentId, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}

	/**   
	 * @param parentId
	 * @param name
	 * @param page
	 * @return  
	 * @see com.whp.framework.service.main.ModuleService#find(java.lang.Long, java.lang.String, com.whp.framework.utils.dwz.Page)  
	 */
	public List<Module> find(Long parentId, String name, Page page) {
		org.springframework.data.domain.Page<Module> springDataPage = 
				moduleDAO.findByParentIdAndNameContaining(parentId, name, PageUtils.createPageable(page));
		page.setTotalCount(springDataPage.getTotalElements());
		return springDataPage.getContent();
	}
	
	/**   
	 * @return  
	 * @see com.whp.framework.service.main.ModuleService#findAll()  
	 */
	@Override
	public List<Module> findAll() {
		return moduleDAO.findAll();
	}

	/**
	 * 判断是否是根模块.
	 */
	private boolean isRoot(Long id) {
		Module m=moduleDAO.findOne(id);
		if(null!=m){
			return m.getIsRoot();
		}
		throw new ServiceException("模块不存在!");
	}

	/**
	 * 
	 * @return  
	 * @see com.whp.framework.service.main.ModuleService#getTree()
	 */
	public Module getTree() {
		List<Module> list = moduleDAO.findAllWithCache();
		
		List<Module> rootList = makeTree(list);
				
		return rootList.get(0);
	}

	private List<Module> makeTree(List<Module> list) {
		List<Module> parent = new ArrayList<Module>();
		// get parentId = null;
		for (Module e : list) {
			if (e.getParent() == null) {
				e.setChildren(new ArrayList<Module>(0));
				parent.add(e);
			}
		}
		// 删除parentId = null;
		list.removeAll(parent);
		
		makeChildren(parent, list);
		
		return parent;
	}
	
	private void makeChildren(List<Module> parent, List<Module> children) {
		if (children.isEmpty()) {
			return ;
		}
		
		List<Module> tmp = new ArrayList<Module>();
		for (Module c1 : parent) {
			for (Module c2 : children) {
				c2.setChildren(new ArrayList<Module>(0));
				if (c1.getId().equals(c2.getParent().getId())) {
					c1.getChildren().add(c2);
					tmp.add(c2);
				}
			}
		}
		
		children.removeAll(tmp);
		
		makeChildren(tmp, children);
	}
	
}
