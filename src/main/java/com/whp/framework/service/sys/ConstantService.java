package com.whp.framework.service.sys;

import java.util.List;

import com.whp.framework.entity.sys.Constant;
import com.whp.framework.service.BaseService;
import com.whp.framework.utils.dwz.Page;

/**
 * 系统常量服务接口
 * @author  zpfox
 * @version  [版本号, 2013-2-10]
 */
public interface ConstantService extends BaseService<Constant, Long>
{
    /**
     * 根据父类id查询子对象集合
     * @param parentId
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<Constant> find(Long parentId);
    
    /**
     * 根据父类id查询子对象集合
     * @param parentId
     * @param page
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<Constant> find(Long parentId, Page page);
    
    /**
     * 根据父类id和变量名称查询子对象集合
     * @param parentId
     * @param name
     * @param page
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<Constant> find(Long parentId, String name, Page page);
    
    /**
     * 获得树对象
     * @return
     * @see [类、类#方法、类#成员]
     */
    Constant getTree();
    
    /**
     * 根据code查询对象并返回该变量名称
     * @param status
     * @return
     * @see [类、类#方法、类#成员]
     */
    Constant findByCode(String code);
    
    /**
     * 判断code是否存在
     * @return
     * @see [类、类#方法、类#成员]
     */
    boolean existsByCode(String code);
    
    /**
     * 根据父类的代码获得子集
     * @param parendCode
     * @return
     * @see [类、类#方法、类#成员]
     */
    List<Constant> findByParentCode(String parendCode);
    
    /**
     * 根据系统变量的名称查找
     * @param type
     * @return
     */
    Constant findByName(String type);
    
    /**
     * 根据父变量id查找系统变量
     * @param parendId
     * @return
     */
    List<Constant> findByParendId(Long parentId);
}
