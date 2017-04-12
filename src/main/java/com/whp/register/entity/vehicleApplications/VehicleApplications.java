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
	// 等待吴主任审批
	public static final String APPROVAL2 = "12";
	// 等待局领导审批
	public static final String APPROVAL3 = "13";
	// 通过
	public static final String PASS = "00";
	// 驳回
	public static final String REJECT = "99";
	
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
	
	// 申请用车时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "use_time")
	private Date useTime;
	
	/** 申请人. */
	@ManyToOne
	@JoinColumn(name = "application_user_id")
	private User applicationUser;
	
	/** 关联车辆主表. */
	@ManyToOne
    @JoinColumn(name = "PARENT_ID")
	private Vehicle parent;

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

	public Date getUseTime() {
		return useTime;
	}

	public void setUseTime(Date useTime) {
		this.useTime = useTime;
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
	
}
