/**
 * <pre>
 * Copyright:		Copyright(C) 2011-2012, ketayao.com
 * Filename:		com.wondersgroup.framework.service.RoleService.java
 * Class:			RoleService
 * Date:			2012-8-7
 * Author:			<a href="mailto:yang-hui@wondersgroup.com">cms</a>
 * Version          1.1.0
 * Description:		
 *
 * </pre>
 **/
 
package com.wondersgroup.framework.service.main;

import java.util.List;
import com.wondersgroup.framework.entity.main.Config;
import com.wondersgroup.framework.utils.dwz.Page;

/** 
 * 	
 * @author 	
 * Version  
 * @since   
 */

public interface ConfigService {
	
	List<Config> find(String key,Page page);

	void save(Config config);

	Config get(Long id);

	void update(Config config);

	void delete(Long id);

	List<Config> findAll(Page page);
	
	/**
	 * 根据有效状态查询返回结果
	 * @return
	 */
	List<Config> findByStatusConf(String status);
	
	/**
	 * 根据key值查找是否有相同key值存在
	 */
	List<Config> findByKeyConfAndId(String key,Long id);
	
	List<Config> findByKeyConf(String key);
}
