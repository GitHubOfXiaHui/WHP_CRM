package com.whp.register.entity.vehicleApplications;

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

/**
 * 用车申请
 * @author xiahui
 *
 */
@Entity
@Table(name = "t_vehicle_applications")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicleApplications")
public class VehicleApplications extends RecordObject {
	
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
	// 还车确认
	public static final String RETURN = "88";
	
	private static final long serialVersionUID = -2819220810963827325L;

	// 审批状态
	@Column(name = "approval_status", nullable = false, length = 2)
	private String approvalStatus = APPROVAL1;
	
	// 出发地
	@Column
	private String departure;
	
	// 目的地
	@Column
	private String destination;
	
	// 驾驶员
	@Column
	private String driver;
	
	// 乘车人数
	@Column(name = "passenger_num")
	private int passengerNum = 0;
	
	// 车辆用途
	@Column(name = "application_intent")
	private String applicationIntent;
	
	// 是否需要局领导审批
	@Type(type = "yes_no")
	@Column
	private boolean requireApproval = false;
	
	// 申请用车时间段
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "start_time")
	private Date startTime;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "end_time")
	private Date endTime;
	
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
	
	/** 车行驶数始码. */
	@Length(max = 20)
	@Column(length = 20)
	private String startFGReading;
	
	/** 车行驶数止码. */
	@Length(max = 20)
	@Column(length = 20)
	private String endFGReading;
	
	/** 实际驾驶人. */
	@Length(max = 20)
	@Column(length = 20)
	private String actualDriver;
	
	/** 还车地点. */
	@Length(max = 20)
	@Column(length = 20)
	private String returnSite;
	
	/** 还车人. */
	@Length(max = 20)
	@Column(length = 20)
	private String returnUser;
	
	/** 还车时间. */
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;
	
	/** 还车备注. */
	@Length(max = 200)
	@Column(length = 200)
	private String returnRemark;
	
/*	// 是否违章
	@Type(type = "yes_no")
	@Column
	private boolean violation = false;
	
	// 是否加油
	@Type(type = "yes_no")
	@Column
	private boolean oiling = false;*/
	
	// 是否事故
	@Type(type = "yes_no")
	@Column
	private boolean accident = false;
	
	/**事故备注. */
	@Length(max = 200)
	@Column(length = 200)
	private String accidentRemark;

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public int getPassengerNum() {
		return passengerNum;
	}

	public void setPassengerNum(int passengerNum) {
		this.passengerNum = passengerNum;
	}

	public String getApplicationIntent() {
		return applicationIntent;
	}

	public void setApplicationIntent(String applicationIntent) {
		this.applicationIntent = applicationIntent;
	}

	public boolean isRequireApproval() {
		return requireApproval;
	}

	public void setRequireApproval(boolean requireApproval) {
		this.requireApproval = requireApproval;
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

	public String getStartFGReading() {
		return startFGReading;
	}

	public void setStartFGReading(String startFGReading) {
		this.startFGReading = startFGReading;
	}

	public String getEndFGReading() {
		return endFGReading;
	}

	public void setEndFGReading(String endFGReading) {
		this.endFGReading = endFGReading;
	}

	public String getActualDriver() {
		return actualDriver;
	}

	public void setActualDriver(String actualDriver) {
		this.actualDriver = actualDriver;
	}

	public String getReturnSite() {
		return returnSite;
	}

	public void setReturnSite(String returnSite) {
		this.returnSite = returnSite;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public String getReturnRemark() {
		return returnRemark;
	}

	public void setReturnRemark(String returnRemark) {
		this.returnRemark = returnRemark;
	}

/*	public boolean isViolation() {
		return violation;
	}

	public void setViolation(boolean violation) {
		this.violation = violation;
	}

	public boolean isOiling() {
		return oiling;
	}

	public void setOiling(boolean oiling) {
		this.oiling = oiling;
	}*/

	public boolean isAccident() {
		return accident;
	}

	public void setAccident(boolean accident) {
		this.accident = accident;
	}

	public String getReturnUser() {
		return returnUser;
	}

	public void setReturnUser(String returnUser) {
		this.returnUser = returnUser;
	}

	public String getAccidentRemark() {
		return accidentRemark;
	}

	public void setAccidentRemark(String accidentRemark) {
		this.accidentRemark = accidentRemark;
	}
	
}
