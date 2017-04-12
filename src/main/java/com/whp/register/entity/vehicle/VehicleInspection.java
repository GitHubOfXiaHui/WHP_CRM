package com.whp.register.entity.vehicle;

import java.util.Calendar;
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

/**
 * 车辆年审信息
 * @author xiahui
 *
 */
@Entity
@Table(name = "t_vehicle_inspection")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicle")
public class VehicleInspection extends RecordObject {
	
	/** 年审周期. */
	// 两年一审
	public static final String INSPECTION_PER_TWO_YEAR = "12";
	// 一年一审
	public static final String INSPECTION_PER_YEAR = "11";
	// 一年两审
	public static final String DOUBLE_INSPECTION_PER_YEAR = "21";

	private static final long serialVersionUID = 6523883328234169413L;

	// 年审周期
	@Column(name = "annual_cycle")
	private String annualCycle; 		
	
	// 上次年审时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_time")
	private Date lastTime;
	
	// 下次年审时间(只读)
	public Date getNextTime() {
		Calendar nextTime = Calendar.getInstance();
		nextTime.setTime(lastTime);
		if (annualCycle.equals(INSPECTION_PER_TWO_YEAR)) {
			nextTime.add(Calendar.YEAR, 2);
		} else if (annualCycle.equals(INSPECTION_PER_YEAR)) {
			nextTime.add(Calendar.YEAR, 1);
		} else if (annualCycle.equals(DOUBLE_INSPECTION_PER_YEAR)) {
			nextTime.add(Calendar.MONTH, 6);
		}
		return nextTime.getTime();
	}
	
	// 是否继续提醒
	@Type(type = "yes_no")
	@Column
	private boolean remind = true;
	
	// 年审结果
	@Column(name = "inspection_result")
	private String inspectionResult;
	
	// 备注
	@Column(name = "inspection_remark")
	private String inspectionRemark;
	
	/** 关联车辆主表. */
	@ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Vehicle parent;				

	public String getAnnualCycle() {
		return annualCycle;
	}

	public void setAnnualCycle(String annualCycle) {
		this.annualCycle = annualCycle;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public boolean getRemind() {
		return remind;
	}

	public void setRemind(boolean remind) {
		this.remind = remind;
	}

	public String getInspectionResult() {
		return inspectionResult;
	}

	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	public String getInspectionRemark() {
		return inspectionRemark;
	}

	public void setInspectionRemark(String inspectionRemark) {
		this.inspectionRemark = inspectionRemark;
	}

	public Vehicle getParent() {
		return parent;
	}

	public void setParent(Vehicle parent) {
		this.parent = parent;
	}
	
}
