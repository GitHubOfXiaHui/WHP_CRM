package com.whp.register.entity.vehicleApplications;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import com.whp.framework.entity.RecordObject;
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
	
	// 目的地
	@Column
	private String destination;
	
	// 是否需要局领导审批
	@Type(type = "yes_no")
	@Column
	private boolean requireApproval = false;
	
	/** 关联车辆主表. */
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "PARENT_ID")
	private Vehicle parent;

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public boolean isRequireApproval() {
		return requireApproval;
	}

	public void setRequireApproval(boolean requireApproval) {
		this.requireApproval = requireApproval;
	}

	public Vehicle getParent() {
		return parent;
	}

	public void setParent(Vehicle parent) {
		this.parent = parent;
	}
	
}
