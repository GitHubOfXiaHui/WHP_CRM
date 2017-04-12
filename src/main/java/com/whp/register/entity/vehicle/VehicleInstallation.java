package com.whp.register.entity.vehicle;

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

import com.whp.framework.entity.RecordObject;

/**
 * 车辆加装信息
 * @author xiahui
 *
 */
@Entity
@Table(name = "t_vehicle_installation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.whp.register.entity.vehicle")
public class VehicleInstallation extends RecordObject {

	private static final long serialVersionUID = -8881474242781578450L;

	// 加装项
	@Column(name = "add_item")
	private String addItem;				
	
	// 加装时间
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "installation_time")
	private Date installationTime;		
	
	// 价格明细
	@Column
	private float price;
	
	// 加装说明
	@Column(name = "installation_description")
	private String installationDescription;
	
	// 关联车辆主表
	@ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Vehicle parent;				

	public String getAddItem() {
		return addItem;
	}

	public void setAddItem(String addItem) {
		this.addItem = addItem;
	}

	public Date getInstallationTime() {
		return installationTime;
	}

	public void setInstallationTime(Date installationTime) {
		this.installationTime = installationTime;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getInstallationDescription() {
		return installationDescription;
	}

	public void setInstallationDescription(String installationDescription) {
		this.installationDescription = installationDescription;
	}

	public Vehicle getParent() {
		return parent;
	}

	public void setParent(Vehicle parent) {
		this.parent = parent;
	}
	
}
