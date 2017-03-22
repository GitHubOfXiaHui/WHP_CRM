package com.wondersgroup.framework.controller.sys;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.framework.controller.BaseController;
import com.wondersgroup.framework.entity.sys.Constant;
import com.wondersgroup.framework.exception.ServiceException;
import com.wondersgroup.framework.service.sys.ConstantService;
import com.wondersgroup.framework.utils.dwz.AjaxObject;
import com.wondersgroup.framework.utils.dwz.Page;

/**
 * 系统常量MVC控制器
 * @author  zpfox
 * @version  [版本号, 2013-2-10]
 */
@Controller
@RequestMapping("/management/sys/constant")
public class ConstantController extends BaseController
{
    @Autowired
    private ConstantService service;
    
    private static final String CREATE = "management/sys/constant/create";
    
    private static final String UPDATE = "management/sys/constant/update";
    
    private static final String LIST = "management/sys/constant/list";
    
    private static final String TREE = "management/sys/constant/tree";
    
    private static final String TREE_LIST = "management/sys/constant/tree_list";
    
    @RequiresPermissions("Constant:save")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String preCreate()
    {
        return CREATE;
    }
    
    @RequiresPermissions("Constant:save")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    String create(Constant constant, HttpServletRequest request)
    {
        AjaxObject ajaxObject = new AjaxObject("系统常量添加成功！");
        //先判断系统变量代码是否唯一
        if (service.existsByCode(constant.getCode()))
        {
            ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
            ajaxObject.setMessage("变量代码:" + constant.getCode() + "已存在！");
        }
        else
        {
            constant.setParent((Constant)request.getSession().getAttribute("parentConstant"));
            service.save(constant);
        }
        return ajaxObject.toString();
    }
    
    @RequiresPermissions("Constant:edit")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String preUpdate(@PathVariable Long id, Map<String, Object> map)
    {
        Constant constant = service.get(id);
        
        map.put("constant", constant);
        return UPDATE;
    }
    
    @RequiresPermissions("Constant:edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    String update(Constant constant)
    {
        service.update(constant);
        
        AjaxObject ajaxObject = new AjaxObject("系统常量修改成功！");
        return ajaxObject.toString();
    }
    
    @RequiresPermissions("Constant:delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public @ResponseBody
    String delete(@PathVariable Long id)
    {
        AjaxObject ajaxObject = new AjaxObject();
        try
        {
            service.delete(id);
            ajaxObject.setMessage("系统常量删除成功！");
        }
        catch (ServiceException e)
        {
            ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
            ajaxObject.setMessage("系统常量删除失败：" + e.getMessage());
        }
        
        ajaxObject.setCallbackType("");
        ajaxObject.setRel("jbsxBox2constant");
        return ajaxObject.toString();
    }
    
    @RequiresPermissions("Constant:view")
    @RequestMapping(value = "/tree", method = RequestMethod.GET)
    public String tree(Map<String, Object> map)
    {
        Constant constant = service.getTree();
        
        map.put("constant", constant);
        return TREE;
    }
    
    @RequiresPermissions("Constant:view")
    @RequestMapping(value = "/tree_list", method = {RequestMethod.GET, RequestMethod.POST})
    public String tree_list(Map<String, Object> map)
    {
        return TREE_LIST;
    }
    
    @RequiresPermissions("Constant:view")
    @RequestMapping(value = "/list/{parentId}", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Page page, @PathVariable Long parentId, String keywords, Map<String, Object> map,
        HttpServletRequest request)
    {
        List<Constant> constants = null;
        if (StringUtils.isNotBlank(keywords))
        {
            constants = service.find(parentId, keywords, page);
        }
        else
        {
            constants = service.find(parentId, page);
        }
        
        request.getSession().setAttribute("parentConstant", service.get(parentId));
        
        map.put("page", page);
        map.put("constants", constants);
        map.put("keywords", keywords);
        
        return LIST;
    }
    
    /**
     * 根据关键字获得系统变量集合
     * @param id
     * @return
     * @see [类、类#方法、类#成员]
     */
    @RequiresPermissions("Constant:view")
    @RequestMapping(value = "/codes/{parentCode}", method = {RequestMethod.GET, RequestMethod.POST})
    public @ResponseBody
    String codes(@PathVariable String parentCode)
    {
        Set<String> removePt = new HashSet<String>();
        removePt.add("class");
        removePt.add("parent");
        removePt.add("id");
        removePt.add("value");
        removePt.add("isSystem");
        removePt.add("remark");
        removePt.add("children");
        
        JSONArray rows = new JSONArray();
        try
        {
            List<Constant> constantList = service.findByParentCode(parentCode);
            for (Constant constant : constantList)
            {
                rows.put(getJsonObjectByEntity(removePt, constant));
            }
            
        }
        catch (Exception e)
        {
            AjaxObject ajaxObject = new AjaxObject();
            ajaxObject.setStatusCode(AjaxObject.STATUS_CODE_FAILURE);
            ajaxObject.setMessage(e.getMessage());
            ajaxObject.setCallbackType("");
            return ajaxObject.toString();
        }
        
        return rows.toString();
    }
}
