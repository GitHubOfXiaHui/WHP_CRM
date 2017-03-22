package com.wondersgroup.framework.entity.main;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.wondersgroup.framework.entity.IdLongEntity;

/**
 * 挂号科室.
 
 */
@Entity
@Table(name = "tb_ks_config")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region = "com.wondersgroup.framework.entity.main")
public class GHKS extends IdLongEntity {
	
	private static final long serialVersionUID = -8141754477542702060L;

	/** 科室ID. */
	@NotBlank
	@Length(max = 32)
	@Column(nullable = false, length = 32)
	private String ksId;

	/** 科室名. */
	@Length(max = 255)
	@Column(length = 255)
	private String ksName;
	
	/** 类别. */
	@Length(max = 255)
	@Column(length = 255)
	private String ksType;
	
	/**别名. */
	@Length(max = 255)
	@Column(length = 255)
	private String aliasName;

	public String getKsId() {
		return ksId;
	}

	public void setKsId(String ksId) {
		this.ksId = ksId;
	}

	public String getKsName() {
		return ksName;
	}

	public void setKsName(String ksName) {
		this.ksName = ksName;
	}

	public String getKsType() {
		return ksType;
	}

	public void setKsType(String ksType) {
		this.ksType = ksType;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
	
	
}
