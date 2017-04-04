package com.whp.framework.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;

// TODO: Auto-generated Javadoc
//JPA 基类的标识
/**
 * The Class RecordObject.<br>
 * 流程处理对象公共字段--流程操作时间与操作人
 */
@MappedSuperclass
public abstract class RecordObject extends IdLongEntity implements StatusObj {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 创建时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	/** 创建人. */
	@Length(max = 20)
	@Column(length = 20)
	private String createUser;

	/** 提交时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date submitDate;

	/** 提交人. */
	@Length(max = 20)
	@Column(length = 20)
	private String submitUser;

	/** 审核时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date auditDate;

	/** 审核人. */
	@Length(max = 20)
	@Column(length = 20)
	private String auditUser;

	/** 驳回时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date rejectDate;

	/** 驳回人. */
	@Length(max = 20)
	@Column(length = 20)
	private String rejectUser;

	/** 作废时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date obsoleteDate;

	/** 作废-操作用户. */
	@Length(max = 20)
	@Column(length = 20)
	private String obsoleteUser;

	/** 驳回说明. */
	@Length(max = 255)
	@Column(length = 255)
	private String rejectExplain;

	/** 作废说明. */
	@Length(max = 255)
	@Column(length = 255)
	private String obsoleteExplain;
	
    /** 状态. 10保存 20提交 30审核 99作废*/
    @Length(max = 2)
    @Column(nullable = false, length = 2)
    private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the 创建日期.
	 * 
	 * @return the 创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Sets the 创建日期.
	 * 
	 * @param createDate
	 *            the new 创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the 创建人.
	 * 
	 * @return the 创建人
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * Sets the 创建人.
	 * 
	 * @param createUser
	 *            the new 创建人
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * Gets the 提交日期.
	 * 
	 * @return the 提交日期
	 */
	public Date getSubmitDate() {
		return submitDate;
	}

	/**
	 * Sets the 提交日期.
	 * 
	 * @param submitDate
	 *            the new 提交日期
	 */
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	/**
	 * Gets the 提交人.
	 * 
	 * @return the 提交人
	 */
	public String getSubmitUser() {
		return submitUser;
	}

	/**
	 * Sets the 提交人.
	 * 
	 * @param submitUser
	 *            the new 提交人
	 */
	public void setSubmitUser(String submitUser) {
		this.submitUser = submitUser;
	}

	/**
	 * Gets the 审核日期.
	 * 
	 * @return the 审核日期
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * Sets the 审核日期.
	 * 
	 * @param auditDate
	 *            the new 审核日期
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * Gets the 审核人.
	 * 
	 * @return the 审核人
	 */
	public String getAuditUser() {
		return auditUser;
	}

	/**
	 * Sets the 审核人.
	 * 
	 * @param auditUser
	 *            the new 审核人
	 */
	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	/**
	 * Gets the 驳回日期.
	 * 
	 * @return the 驳回日期
	 */
	public Date getRejectDate() {
		return rejectDate;
	}

	/**
	 * Sets the 驳回日期.
	 * 
	 * @param rejectDate
	 *            the new 驳回日期
	 */
	public void setRejectDate(Date rejectDate) {
		this.rejectDate = rejectDate;
	}

	/**
	 * Gets the 驳回人.
	 * 
	 * @return the 驳回人
	 */
	public String getRejectUser() {
		return rejectUser;
	}

	/**
	 * Sets the 驳回人.
	 * 
	 * @param rejectUser
	 *            the new 驳回人
	 */
	public void setRejectUser(String rejectUser) {
		this.rejectUser = rejectUser;
	}

	/**
	 * Gets the 作废日期.
	 * 
	 * @return the 作废日期
	 */
	public Date getObsoleteDate() {
		return obsoleteDate;
	}

	/**
	 * Sets the 作废日期.
	 * 
	 * @param obsoleteDate
	 *            the new 作废日期
	 */
	public void setObsoleteDate(Date obsoleteDate) {
		this.obsoleteDate = obsoleteDate;
	}

	/**
	 * Gets the 作废-操作用户.
	 * 
	 * @return the 作废-操作用户
	 */
	public String getObsoleteUser() {
		return obsoleteUser;
	}

	/**
	 * Sets the 作废-操作用户.
	 * 
	 * @param obsoleteUser
	 *            the new 作废-操作用户
	 */
	public void setObsoleteUser(String obsoleteUser) {
		this.obsoleteUser = obsoleteUser;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wondersgroup.framework.entity.StatusObj#getRejectExplain()
	 */
	public String getRejectExplain() {
		return rejectExplain;
	}

	/**
	 * Sets the 驳回说明.
	 * 
	 * @param rejectExplain
	 *            the new 驳回说明
	 */
	public void setRejectExplain(String rejectExplain) {
		this.rejectExplain = rejectExplain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wondersgroup.framework.entity.StatusObj#getObsoleteExplain()
	 */
	public String getObsoleteExplain() {
		return obsoleteExplain;
	}

	/**
	 * Sets the 作废说明.
	 * 
	 * @param obsoleteExplain
	 *            the new 作废说明
	 */
	public void setObsoleteExplain(String obsoleteExplain) {
		this.obsoleteExplain = obsoleteExplain;
	}

}
