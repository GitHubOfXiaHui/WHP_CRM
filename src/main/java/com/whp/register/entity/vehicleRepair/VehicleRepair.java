package com.whp.register.entity.vehicleRepair;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import com.whp.framework.entity.RecordObject;
import com.whp.framework.entity.main.User;
import com.whp.register.entity.vehicle.Vehicle;

@Entity
@Table(name = "t_vehicle_repair")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicleRepair")
public class VehicleRepair extends RecordObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7595018913947454763L;
	/** 审批状态. */
	// 等待所领导审批
	public static final String APPROVAL1 = "11";
	// 等待警务保障室审批
	public static final String APPROVAL2 = "12";
	// 等待局领导审批
	public static final String APPROVAL3 = "13";
	// 通过
	public static final String PASS = "00";
	// 驳回
	public static final String REJECT = "99";
	// 检修确认
	public static final String RETURN = "88";
	
	// 审批状态
	@Column(name = "approval_status", nullable = false, length = 2)
	private String approvalStatus = APPROVAL1;
	
	/** 申请人. */
	@ManyToOne
	@JoinColumn(name = "application_user_id")
	private User applicationUser;
	
	/** 关联车辆主表. */
	@ManyToOne
    @JoinColumn(name = "PARENT_ID")
	private Vehicle parent;
	
	/** 数据权限控制--用户. */
	@Column(name = "user_auth")
	private String userAuth;
	
	/** 数据权限控制--机构. */
	@Column(name = "org_auth")
	private String orgAuth;
	
	/** 第一审核时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date audit1Date;

	/** 第一审核人. */
	@Length(max = 20)
	@Column(length = 20)
	private String audit1User;
	
	/** 第二审核时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date audit2Date;

	/** 第二审核人. */
	@Length(max = 20)
	@Column(length = 20)
	private String audit2User;
	
	/** 第三审核时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date audit3Date;

	/** 第三审核人. */
	@Length(max = 20)
	@Column(length = 20)
	private String audit3User;
	
	/** 预计送检时间. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	private Date startTime;
	
	/** 预计接车时间. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	private Date endTime;
	
	/** 预计检修费用. */
	@Column
	private float price;
	
	// 检修地点
	@Column
	private String repairSite;
	
	// 检修原因
	@Column(length=2000)
	private String repairDescript;
	
	// 是否需要局领导审批
	@Type(type = "yes_no")
	@Column
	private boolean requireApproval = false;
	
	// 是否需要警务保障室审批
	@Type(type = "yes_no")
	@Column
	private boolean requireApproval1 = false;
	
	/** 实际检修费用. */
	@Column
	private float actualPrice=0;
	
	/** 实际接车时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date actualEndTime;
	
	/** 确认人. */
	@Length(max = 20)
	@Column(length = 20)
	private String affirmUser;
	
	/** 确认时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date affirmDate;
	
	/** 确认备注. */
	@Length(max = 200)
	@Column(length = 200)
	private String affirmRemark;

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public User getApplicationUser() {
		return applicationUser;
	}

	public void setApplicationUser(User applicationUser) {
		this.applicationUser = applicationUser;
	}

	public Vehicle getParent() {
		return parent;
	}

	public void setParent(Vehicle parent) {
		this.parent = parent;
	}

	public String getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(String userAuth) {
		this.userAuth = userAuth;
	}

	public String getOrgAuth() {
		return orgAuth;
	}

	public void setOrgAuth(String orgAuth) {
		this.orgAuth = orgAuth;
	}

	public Date getAudit1Date() {
		return audit1Date;
	}

	public void setAudit1Date(Date audit1Date) {
		this.audit1Date = audit1Date;
	}

	public String getAudit1User() {
		return audit1User;
	}

	public void setAudit1User(String audit1User) {
		this.audit1User = audit1User;
	}

	public Date getAudit2Date() {
		return audit2Date;
	}

	public void setAudit2Date(Date audit2Date) {
		this.audit2Date = audit2Date;
	}

	public String getAudit2User() {
		return audit2User;
	}

	public void setAudit2User(String audit2User) {
		this.audit2User = audit2User;
	}

	public Date getAudit3Date() {
		return audit3Date;
	}

	public void setAudit3Date(Date audit3Date) {
		this.audit3Date = audit3Date;
	}

	public String getAudit3User() {
		return audit3User;
	}

	public void setAudit3User(String audit3User) {
		this.audit3User = audit3User;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getRepairSite() {
		return repairSite;
	}

	public void setRepairSite(String repairSite) {
		this.repairSite = repairSite;
	}

	public String getRepairDescript() {
		return repairDescript;
	}

	public void setRepairDescript(String repairDescript) {
		this.repairDescript = repairDescript;
	}

	public boolean isRequireApproval() {
		return requireApproval;
	}

	public void setRequireApproval(boolean requireApproval) {
		this.requireApproval = requireApproval;
	}

	public Date getActualEndTime() {
		return actualEndTime;
	}

	public void setActualEndTime(Date actualEndTime) {
		this.actualEndTime = actualEndTime;
	}

	public String getAffirmUser() {
		return affirmUser;
	}

	public void setAffirmUser(String affirmUser) {
		this.affirmUser = affirmUser;
	}

	public Date getAffirmDate() {
		return affirmDate;
	}

	public void setAffirmDate(Date affirmDate) {
		this.affirmDate = affirmDate;
	}

	public String getAffirmRemark() {
		return affirmRemark;
	}

	public void setAffirmRemark(String affirmRemark) {
		this.affirmRemark = affirmRemark;
	}

	public float getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}

	public boolean isRequireApproval1() {
		return requireApproval1;
	}

	public void setRequireApproval1(boolean requireApproval1) {
		this.requireApproval1 = requireApproval1;
	}
	
}
