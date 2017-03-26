package com.whp.register.entity.vehicle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.whp.framework.entity.IdEntity;

@Entity
@Table(name = "t_vehicle")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicle")
public class Vehicle extends IdEntity {

	private static final long serialVersionUID = -5592946999598258429L;

	@Column
	private String license;			// 车牌
	
	@Column
	private String type;			// 车辆型号
	
	@Column
	private String color;			// 车辆颜色
	
	@Column
	private String configuration;	// 车辆配置
	
	@Column
	private String displacement;	// 排量
	
	@Column
	private String crew;			// 乘员数
	
	@Column
	private String price;			// 价格
	
	@Column(name = "purchase_tax")
	private String purchaseTax;		// 购置税
	
	@Column(name = "buying_time")
	private String buyingTime;		// 购买时间

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getConfiguration() {
		return configuration;
	}

	public void setConfiguration(String configuration) {
		this.configuration = configuration;
	}

	public String getDisplacement() {
		return displacement;
	}

	public void setDisplacement(String displacement) {
		this.displacement = displacement;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPurchaseTax() {
		return purchaseTax;
	}

	public void setPurchaseTax(String purchaseTax) {
		this.purchaseTax = purchaseTax;
	}

	public String getBuyingTime() {
		return buyingTime;
	}

	public void setBuyingTime(String buyingTime) {
		this.buyingTime = buyingTime;
	}
	
}
