package com.whp.framework.entity.component;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.whp.framework.entity.IdEntity;
import com.whp.framework.log.LogLevel;

/**
 * 系统运行日志信息 <br>
 * Version 2.1.0
 * @since 2013-5-3 下午4:43:44
 */
@Entity
@Table(name = "Component_log_entity")
public class LogEntity extends IdEntity {

	/** 描述. */
	private static final long serialVersionUID = 6057051455824317181L;
	
	/** 日志消息. */
	@Column(length = 255)
	private String message;

	/** 用户名. */
	@Column(length = 32)
	private String username;

	/** 创建时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	/** 访问的IP地址. */
	@Column(length = 16)
	private String ipAddress;

	/** 日志级别. */
	@Column(length = 16)
	@Enumerated(EnumType.STRING)
	private LogLevel logLevel;

	/**
	 * Gets the 日志消息.
	 * 
	 * @return the 日志消息
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the 日志消息.
	 * 
	 * @param message
	 *            the new 日志消息
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the 用户名.
	 *
	 * @return the 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the 用户名.
	 *
	 * @param username the new 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the 创建时间.
	 *
	 * @return the 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * Sets the 创建时间.
	 *
	 * @param createTime the new 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * Gets the 访问的IP地址.
	 *
	 * @return the 访问的IP地址
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * Sets the 访问的IP地址.
	 *
	 * @param ipAddress the new 访问的IP地址
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * Gets the 日志级别.
	 *
	 * @return the 日志级别
	 */
	public LogLevel getLogLevel() {
		return logLevel;
	}

	/**
	 * Sets the 日志级别.
	 *
	 * @param logLevel the new 日志级别
	 */
	public void setLogLevel(LogLevel logLevel) {
		this.logLevel = logLevel;
	}

}
