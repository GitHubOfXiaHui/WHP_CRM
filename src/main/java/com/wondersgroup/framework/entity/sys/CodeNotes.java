package com.wondersgroup.framework.entity.sys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Length;

import com.wondersgroup.framework.entity.IdEntity;

// TODO: Auto-generated Javadoc
/**
 * Code生成辅助类. 按前缀区分维护不同的序列
 * 
 * @author zpfox
 */
@Entity
@Table(name = "Config_Code_Notes")
public class CodeNotes extends IdEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 需要生成的Code前缀 最大长度:16 不能为空并且唯一 有索引. */
	@Column(name = "Prefix", unique = true, nullable = false, length = 16)
	@Index(name = "Config_CodeNotes_Prefix")
	private String prefix;

	/** 代码中间标识. */
	@Column(name = "middle", length = 16)
	private String middle;

	/**
	 * 需要生成的代码后缀 最大长度 10
	 */
	@Length(max = 10)
	@Column(name = "Suffix", length = 10)
	private String suffix;

	/** 计数日期. */
	@Column()
	private Date countDate = new Date();

	/** 最后的流水号. */
	@Column(name = "LastSerialNum")
	private Integer lastSerialNum;

	/** 流水号所占位数. */
	@Column(name = "SpaceOccupying")
	private Integer spaceOccupying;

	/** 描述 最大长度：200. */
	@Column(name = "Description", length = 200)
	private String description;

	/**
	 * Instantiates a new code notes.
	 * 
	 * @param prefix
	 *            the prefix
	 */
	public CodeNotes(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Instantiates a new code notes.
	 */
	public CodeNotes() {

	}

	/**
	 * Gets the 需要生成的Code前缀 最大长度:10 不能为空并且唯一 有索引.
	 * 
	 * @return the 需要生成的Code前缀 最大长度:10 不能为空并且唯一 有索引
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Sets the 需要生成的Code前缀 最大长度:10 不能为空并且唯一 有索引.
	 * 
	 * @param prefix
	 *            the new 需要生成的Code前缀 最大长度:10 不能为空并且唯一 有索引
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Gets the 代码中间标识.
	 * 
	 * @return the 代码中间标识
	 */
	public String getMiddle() {
		return middle;
	}

	/**
	 * Sets the 代码中间标识.
	 * 
	 * @param middle
	 *            the new 代码中间标识
	 */
	public void setMiddle(String middle) {
		this.middle = middle;
	}

	/**
	 * Gets the 需要生成的代码后缀 最大长度 10.
	 * 
	 * @return the 需要生成的代码后缀 最大长度 10
	 */
	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	/**
	 * Gets the 计数日期.
	 * 
	 * @return the 计数日期
	 */
	public Date getCountDate() {
		return countDate;
	}

	/**
	 * Sets the 计数日期.
	 * 
	 * @param countDate
	 *            the new 计数日期
	 */
	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}

	/**
	 * Gets the 最后的流水号.
	 * 
	 * @return the 最后的流水号
	 */
	public Integer getLastSerialNum() {
		return lastSerialNum;
	}

	/**
	 * Sets the 最后的流水号.
	 * 
	 * @param lastSerialNum
	 *            the new 最后的流水号
	 */
	public void setLastSerialNum(Integer lastSerialNum) {
		this.lastSerialNum = lastSerialNum;
	}

	/**
	 * Gets the 流水号所占位数.
	 * 
	 * @return the 流水号所占位数
	 */
	public Integer getSpaceOccupying() {
		return spaceOccupying;
	}

	/**
	 * Sets the 流水号所占位数.
	 * 
	 * @param spaceOccupying
	 *            the new 流水号所占位数
	 */
	public void setSpaceOccupying(Integer spaceOccupying) {
		this.spaceOccupying = spaceOccupying;
	}

	/**
	 * Gets the 描述 最大长度：200.
	 * 
	 * @return the 描述 最大长度：200
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the 描述 最大长度：200.
	 * 
	 * @param description
	 *            the new 描述 最大长度：200
	 */
	public void setDescription(String description) {
		this.description = description;
	}

}
