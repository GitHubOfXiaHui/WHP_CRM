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

package com.wondersgroup.framework.controller.main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.framework.SecurityConstants;
import com.wondersgroup.framework.entity.main.Config;
import com.wondersgroup.framework.log.Log;
import com.wondersgroup.framework.service.main.ConfigService;
import com.wondersgroup.framework.utils.dwz.AjaxObject;
import com.wondersgroup.framework.utils.dwz.Page;

/**
 * 
 * @author Version
 * @since
 */
@Controller
@RequestMapping("/management/security/config")
public class ConfigController
{
    @Autowired
    public ConfigService configService;
    
    private static final String LIST = "management/security/config/list";
    
    private static final String UPDATE = "management/security/config/update";
    
    private static final String CREATE = "management/security/config/create";
    
    private static final String VIEW = "management/security/config/view";
    
    /**
     * 
     * @param page
     * @param keywords
     * @param map
     * @return
     */
    @RequiresPermissions("Config:view")
    @RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(Page page, String keywords, Map<String, Object> map)
    {
        List<Config> configs = null;
        page.setOrderField("updatetime");
        if (StringUtils.isNotBlank(keywords))
        {
            configs = configService.find(keywords, page);
        }
        else
        {
            configs = configService.findAll(page);
        }
        
        map.put("page", page);
        map.put("configs", configs);
        map.put("keywords", keywords);
        return LIST;
    }
    
    /**
     * 查看
     * 
     * @param id
     * @param map
     * @return
     */
    @RequiresPermissions("Config:view")
    @RequestMapping(value = "/view/{id}", method = {RequestMethod.GET})
    public String view(@PathVariable
    Long id, Map<String, Object> map)
    {
        Config config = configService.get(id);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String modTime = df.format(config.getUpdatetime());
        map.put("config", config);
        map.put("modTime", modTime);
        return VIEW;
    }
    
    /**
     * 添加
     * 
     * @param map
     * @return
     */
    @RequiresPermissions("Config:save")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String preCreate(Map<String, Object> map)
    {
        return CREATE;
    }
    
    @Log(message = "添加了{0}配置。")
    @RequiresPermissions("Config:save")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public @ResponseBody
    String create(Config config)
    {
        List<Config> searchResult = null;
        searchResult = configService.findByKeyConf(config.getKey());
        if (!searchResult.isEmpty())
        {
            return AjaxObject.newError("已存在相同的配置，请重新修改！").toString();
        }
        else
        {
            if (config.getStatus().equals("1"))
            {
                SecurityConstants.configMap.put(config.getKey(), config.getValue());// 同步configMap
            }
            config.setUpdatetime(new Date());
            configService.save(config);
            return AjaxObject.newOk("添加配置成功！").toString();
        }
    }
    
    /*
     * @Log(message="删除了{0}配置。")
     * 
     * @RequiresPermissions("Config:delete")
     * 
     * @RequestMapping(value="/delete/{id}", method=RequestMethod.POST) public
     * @ResponseBody String delete(@PathVariable Long id) { Config config =
     * configService.get(id); if(config.getStatus().equals("1")){
     * SecurityConstants.configMap.remove(config.getKey());//同步configMap }
     * configService.delete(config.getId()); return
     * AjaxObject.newOk("删除配置成功！").setCallbackType("").toString(); }
     */
    
    /**
     * 删除
     * 
     * @param id
     * @return
     */
    @Log(message = "删除了{0}配置。")
    @RequiresPermissions("Config:delete")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public @ResponseBody
    String deleteMany(Long[] ids)
    {
        for (int i = 0; i < ids.length; i++)
        {
            Config config = configService.get(ids[i]);
            if (config.getStatus().equals("1"))
            {
                SecurityConstants.configMap.remove(config.getKey());// 同步configMap
            }
            configService.delete(config.getId());
        }
        return AjaxObject.newOk("删除配置成功！").setCallbackType("").toString();
    }
    
    /**
     * 修改
     * 
     * @param id
     * @param map
     * @return
     */
    @RequiresPermissions("Config:edit")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String preUpdate(@PathVariable
    Long id, Map<String, Object> map)
    {
        Config config = configService.get(id);
        map.put("config", config);
        return UPDATE;
    }
    
    @Log(message = "修改了{0}配置信息。")
    @RequiresPermissions("Config:edit")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    String update(Config config)
    {
        Config oldConfig = configService.get(config.getId());
        List<Config> searchResult = null;
        searchResult = configService.findByKeyConfAndId(config.getKey(), config.getId());
        if (!searchResult.isEmpty())
        {
            return AjaxObject.newError("已存在相同的配置,请重新修改！").toString();
        }
        else
        {
            if (oldConfig.getStatus().equals("1"))
            {
                SecurityConstants.configMap.remove(oldConfig.getKey());
            }
            oldConfig.setUpdatetime(new Date());
            oldConfig.setKey(config.getKey());
            oldConfig.setValue(config.getValue());
            oldConfig.setDescription(config.getDescription());
            oldConfig.setStatus(config.getStatus());
            configService.update(oldConfig);
            if (oldConfig.getStatus().equals("1"))
            {
                SecurityConstants.configMap.put(oldConfig.getKey(), oldConfig.getValue());
            }
            return AjaxObject.newOk("修改配置成功！").toString();
        }
    }
}
