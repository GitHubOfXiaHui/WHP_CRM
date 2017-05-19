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
	/** 审批状态. */
	// 等待所领导审批
	public static final String APPROVAL1 = "11";
	// 等待后勤管理处审批
	public static final String APPROVAL2 = "12";
	// 等待局领导审批
	public static final String APPROVAL3 = "13";
	// 通过
	public static final String PASS = "00";
	// 驳回
	public static final String REJECT = "99";
	// 还车确认
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
	
	/** 预计维修开始时间. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	private Date startTime;
	
	/** 预计维修结束时间. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	private Date endTime;
	
	/** 预计维修金额. */
	@Column
	private float price;
	
	// 维修地点
	@Column
	private String repairSite;
	
	// 维修描述
	@Column
	private String repairDescript;
	
	// 是否需要局领导审批
	@Type(type = "yes_no")
	@Column
	private boolean requireApproval = false;

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
	
}
