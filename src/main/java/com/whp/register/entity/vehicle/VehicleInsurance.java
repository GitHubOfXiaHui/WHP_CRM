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

import com.whp.framework.entity.RecordObject;

/**
 * 车辆保险信息
 * @author xiahui
 *
 */
@Entity
@Table(name = "t_vehicle_insurance")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicle")
public class VehicleInsurance extends RecordObject {

	private static final long serialVersionUID = -7579391903985615753L;

	@Column(name = "insurance_carriers")
	private String insuranceCarriers;			// 承保公司
	
	@Column(name = "insured_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insuredTime;					// 投保时间
	
	@Column(name = "expire_time")
    @Temporal(TemporalType.TIMESTAMP)
	private Date expireTime;					// 过保时间
	
	@Column(name = "insurance_cost")		
	private float insuranceCost;				// 保险价格（元）
	
	@Column(name = "insurance_amount")		
	private float insuranceAmount;				// 保险额度（万元） 根据保险类型选填
	
	@Column(name = "insurance_type")		
	private String insuranceType;				// 保险类型1、交强险2、车辆损失险3、第三者责任险4、盗抢险5、车上座位责任险6、玻璃单独破碎险7、自燃险8、划痕险9、不计免赔特约险
	
	@Column(name = "insurance_validity")		
	private String insuranceValidity;			// 保险有效标志 0 过保  1 在保
	
	@Column(name = "insurance_remark")		
	private String insuranceRemark;				// 备注
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "PARENT_ID")				
    private Vehicle parent;						// 关联车辆主表

	public String getInsuranceCarriers() {
		return insuranceCarriers;
	}

	public void setInsuranceCarriers(String insuranceCarriers) {
		this.insuranceCarriers = insuranceCarriers;
	}

	public Date getInsuredTime() {
		return insuredTime;
	}

	public void setInsuredTime(Date insuredTime) {
		this.insuredTime = insuredTime;
	}

	public Date getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(Date expireTime) {
		this.expireTime = expireTime;
	}

	public float getInsuranceCost() {
		return insuranceCost;
	}

	public void setInsuranceCost(float insuranceCost) {
		this.insuranceCost = insuranceCost;
	}

	public String getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

	public String getInsuranceValidity() {
		return insuranceValidity;
	}

	public void setInsuranceValidity(String insuranceValidity) {
		this.insuranceValidity = insuranceValidity;
	}

	public Vehicle getParent() {
		return parent;
	}

	public void setParent(Vehicle parent) {
		this.parent = parent;
	}

	public float getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(float insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	public String getInsuranceRemark() {
		return insuranceRemark;
	}

	public void setInsuranceRemark(String insuranceRemark) {
		this.insuranceRemark = insuranceRemark;
	}

}
