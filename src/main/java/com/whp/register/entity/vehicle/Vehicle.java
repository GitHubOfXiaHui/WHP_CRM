package com.whp.register.entity.vehicle;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.google.common.collect.Lists;
import com.whp.framework.entity.RecordObject;

/**
 * 车辆基本信息
 * @author xiahui
 *
 */
@Entity
@Table(name = "t_vehicle")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicle")
public class Vehicle extends RecordObject {
	
	// 已录入保险、年审、加装等信息
	public static final String RECORDED = "1";
	public static final String UNRECORDED = "0";

	private static final long serialVersionUID = -5592946999598258429L;

	@Column
	private String license;			// 车牌号
	
	@Column
	private String type;			// 车辆型号
	
	@Column
	private String color;			// 车辆颜色
	
	@Column
	private String configuration;	// 车辆配置
	
	@Column
	private String displacement;	// 排量
	
	@Column
	private int crew;				// 乘员数
	
	@Column
	private float price;			// 价格
	
	@Column(name = "purchase_tax")
	private float purchaseTax;		// 购置税
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "buying_time")
	private Date buyingTime;		// 购买时间
	
	@Column(name = "insurance_status")
	private String insuranceStatus = UNRECORDED;
	
    /** 保险列表. */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleInsurance> insuranceList = Lists.newArrayList();
    
    @Column(name = "inspection_status")
	private String inspectionStatus = UNRECORDED;
	
    /** 年审列表. */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleInspection> inspectionList = Lists.newArrayList();
    
    @Column(name = "installation_status")
	private String installationStatus = UNRECORDED;
	
    /** 加装列表. */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleInstallation> installationList = Lists.newArrayList();

	public String getInsuranceStatus() {
		return insuranceStatus;
	}

	public void setInsuranceStatus(String insuranceStatus) {
		this.insuranceStatus = insuranceStatus;
	}

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

	public int getCrew() {
		return crew;
	}

	public void setCrew(int crew) {
		this.crew = crew;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getPurchaseTax() {
		return purchaseTax;
	}

	public void setPurchaseTax(float purchaseTax) {
		this.purchaseTax = purchaseTax;
	}

	public Date getBuyingTime() {
		return buyingTime;
	}

	public void setBuyingTime(Date buyingTime) {
		this.buyingTime = buyingTime;
	}

	public List<VehicleInsurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(List<VehicleInsurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

	public String getInspectionStatus() {
		return inspectionStatus;
	}

	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}

	public List<VehicleInspection> getInspectionList() {
		return inspectionList;
	}

	public void setInspectionList(List<VehicleInspection> inspectionList) {
		this.inspectionList = inspectionList;
	}

	public String getInstallationStatus() {
		return installationStatus;
	}

	public void setInstallationStatus(String installationStatus) {
		this.installationStatus = installationStatus;
	}

	public List<VehicleInstallation> getInstallationList() {
		return installationList;
	}

	public void setInstallationList(List<VehicleInstallation> installationList) {
		this.installationList = installationList;
	}
	
}
