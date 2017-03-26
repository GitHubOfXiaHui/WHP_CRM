package com.whp.register.entity.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.whp.framework.entity.IdEntity;

@Entity
@Table(name = "t_vehicle_inspection")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.framework.entity.vehicle")
public class VehicleInspection extends IdEntity {

	private static final long serialVersionUID = 6523883328234169413L;

	@Column(name = "annual_cycle")
	private String annualCycle; 		// 年审周期
	
	@Column(name = "last_time")
	private String lastTime;			// 上次年审时间
	
	@Column(name = "next_time")
	private String nextTime;			// 下次年审时间
	
	@Column
	private String remind;				// 是否继续提醒

	public String getAnnualCycle() {
		return annualCycle;
	}

	public void setAnnualCycle(String annualCycle) {
		this.annualCycle = annualCycle;
	}

	public String getLastTime() {
		return lastTime;
	}

	public void setLastTime(String lastTime) {
		this.lastTime = lastTime;
	}

	public String getNextTime() {
		return nextTime;
	}

	public void setNextTime(String nextTime) {
		this.nextTime = nextTime;
	}

	public String getRemind() {
		return remind;
	}

	public void setRemind(String remind) {
		this.remind = remind;
	}
	
}
