package com.whp.framework.entity;
/**
 * 状态对象接口<br>
 * 实现该接口的对象可以有业务框架处理状态的变化
 * @see StatusDefinitionImpl.java
 * @author zpfox
 *
 */
public interface StatusObj {
	
	String getStatus();
	
	void setStatus(String statusCode);
	
	String getRejectExplain();
	
	String getObsoleteExplain();
}
