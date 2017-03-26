package com.whp.register.entity.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.wondersgroup.framework.entity.IdEntity;

@Entity
@Table(name = "t_vehicle_insurance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.vehicle")
public class VehicleInsurance extends IdEntity {

	private static final long serialVersionUID = -7579391903985615753L;

	@Column(name = "insurance_carriers")
	private String insuranceCarriers;			// 承保公司
	
	@Column(name = "insured_time")
	private String insuredTime;					// 投保时间
	
	@Column(name = "insurance_validity")
	private String insuranceValidity;			// 保险有效期

	public String getInsuranceCarriers() {
		return insuranceCarriers;
	}

	public void setInsuranceCarriers(String insuranceCarriers) {
		this.insuranceCarriers = insuranceCarriers;
	}

	public String getInsuredTime() {
		return insuredTime;
	}

	public void setInsuredTime(String insuredTime) {
		this.insuredTime = insuredTime;
	}

	public String getInsuranceValidity() {
		return insuranceValidity;
	}

	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}
	
}
