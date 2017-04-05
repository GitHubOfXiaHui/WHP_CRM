package com.whp.register.entity.vehicle;

import java.util.Date;

import javax.persistence.CascadeType;
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

	private static final long serialVersionUID = 6523883328234169413L;

	@Column(name = "annual_cycle")
	private String annualCycle; 		// 年审周期
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_time")
	private Date lastTime;				// 上次年审时间
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "next_time")
	private Date nextTime;				// 下次年审时间
	
	@Type(type = "yes_no")
	@Column
	private boolean remind = true;				// 是否继续提醒
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "PARENT_ID")
    private Vehicle parent;				// 关联车辆主表

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

	public Date getNextTime() {
		return nextTime;
	}

	public void setNextTime(Date nextTime) {
		this.nextTime = nextTime;
	}

	public boolean getRemind() {
		return remind;
	}

	public void setRemind(boolean remind) {
		this.remind = remind;
	}

	public Vehicle getParent() {
		return parent;
	}

	public void setParent(Vehicle parent) {
		this.parent = parent;
	}
	
}
