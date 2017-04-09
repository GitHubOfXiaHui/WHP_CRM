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
import org.hibernate.annotations.Type;

import com.google.common.collect.Lists;
import com.whp.framework.entity.RecordObject;
import com.whp.register.entity.vehicleApplications.VehicleApplications;

/**
 * 车辆基本信息
 * @author xiahui
 *
 */
@Entity
@Table(name = "t_vehicle")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicle")
public class Vehicle extends RecordObject {
	
	/** 车辆状态. */
	// 空闲
	public static final String IDLE = "00";
	// 使用中
	public static final String USING = "10";
	// 维修中
	public static final String REPAIRING = "99";

	private static final long serialVersionUID = -5592946999598258429L;

	// 车牌号
	@Column
	private String license;			
	
	// 车辆型号
	@Column
	private String type;			
	
	// 车辆颜色
	@Column
	private String color;			
	
	// 车辆配置
	@Column
	private String configuration;	
	
	// 排量
	@Column
	private String displacement;	
	
	// 乘员数
	@Column
	private int crew;				
	
	// 价格
	@Column
	private float price;			
	
	// 购置税
	@Column(name = "purchase_tax")
	private float purchaseTax;		
	
	// 购买时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "buying_time")
	private Date buyingTime;		
	
	// 是否录入保险信息
	@Type(type = "yes_no")
	@Column(name = "recorded_insurance")
	private boolean recordedInsurance = false;
	
    /** 保险列表. */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleInsurance> insuranceList = Lists.newArrayList();
    
    // 是否录入年审信息
    @Type(type = "yes_no")
	@Column(name = "recorded_inspection")
	private boolean recordedInspection = false;
	
    /** 年审列表. */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleInspection> inspectionList = Lists.newArrayList();
    
    // 是否录入加装信息
    @Type(type = "yes_no")
	@Column(name = "recorded_installation")
	private boolean recordedInstallation = false;
	
    /** 加装列表. */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleInstallation> installationList = Lists.newArrayList();
    
    // 车辆状态
 	@Column(name = "vehicle_status", nullable = false, length = 2)
 	private String vehicleStatus = IDLE;
 	
    /** 车辆使用申请列表. */
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleApplications> applicationList = Lists.newArrayList();

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

	public boolean isRecordedInsurance() {
		return recordedInsurance;
	}

	public void setRecordedInsurance(boolean recordedInsurance) {
		this.recordedInsurance = recordedInsurance;
	}

	public List<VehicleInsurance> getInsuranceList() {
		return insuranceList;
	}

	public void setInsuranceList(List<VehicleInsurance> insuranceList) {
		this.insuranceList = insuranceList;
	}

	public boolean isRecordedInspection() {
		return recordedInspection;
	}

	public void setRecordedInspection(boolean recordedInspection) {
		this.recordedInspection = recordedInspection;
	}

	public List<VehicleInspection> getInspectionList() {
		return inspectionList;
	}

	public void setInspectionList(List<VehicleInspection> inspectionList) {
		this.inspectionList = inspectionList;
	}

	public boolean isRecordedInstallation() {
		return recordedInstallation;
	}

	public void setRecordedInstallation(boolean recordedInstallation) {
		this.recordedInstallation = recordedInstallation;
	}

	public List<VehicleInstallation> getInstallationList() {
		return installationList;
	}

	public void setInstallationList(List<VehicleInstallation> installationList) {
		this.installationList = installationList;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public List<VehicleApplications> getApplicationList() {
		return applicationList;
	}

	public void setApplicationList(List<VehicleApplications> applicationList) {
		this.applicationList = applicationList;
	}

}
