/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.OrganizationService.java
 * Class:			OrganizationService
 * Date:			2012-8-27
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/

package com.whp.framework.service.main;

import java.io.InputStream;
import java.util.List;

import com.whp.framework.entity.main.Organization;
import com.whp.framework.exception.ServiceException;
import com.whp.framework.service.BaseService;
import com.whp.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version  1.1.0
 * @since   2012-8-27 下午3:56:25 
 */

public interface OrganizationService extends BaseService<Organization, Long>
{
    
    List<Organization> find(Long parentId, Page page);
    
    List<Organization> find(Long parentId, String name, Page page);
    
    Organization getTree();
    
    void save(Organization organization);
    
    Organization get(Long id);
    
    void update(Organization organization);
    
    void delete(Long id)
        throws ServiceException;
    
    Organization findByCode(String orgCode);
    
    List<Organization> findByParentId(Long parentId);
    
    List<Organization> findAll();
    
    List<Organization> findByAreaCode(String areaCode);
    
    Organization findByAreaCodeAndJglx(String areaCode, String jglx);
    
    /**
     * true本地false外地
     * @param yycsdm
     * @return
     * @see [类、类#方法、类#成员]
     */
    boolean isLocal(String yycsdm);
    
    /**
     * 得到市级机构的区域代码
     * <功能详细描述>
     * @param areaCode
     * @return
     * @see [类、类#方法、类#成员]
     */
    String getCityCode(String areaCode);
    
    List<Organization> findByTbbzAndIsRoot(String tbbz, Boolean flag);
    
    String exportRegMedicalOrgItem(InputStream inputStream, String originalFilename, String parentid);

    List<Organization> makeTree(List<Organization> children);
}
