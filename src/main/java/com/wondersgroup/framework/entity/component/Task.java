package com.wondersgroup.framework.entity.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.wondersgroup.framework.entity.IdEntity;


// TODO: Auto-generated Javadoc
/**
 * The Class Task.
 */
//JPA标识
@Entity
@Table(name = "Component_Task")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Task extends IdEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2677876323206901899L;
	
	/** The title. */
	@NotBlank
	@Length(max=32)
	@Column(length=32, nullable=false)
	private String title;
	
	/** The description. */
	@Length(max=255)
	@Column(length=255)
	private String description;

	/**
	 * Gets the 任务标题.
	 * 
	 * @return the 任务标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the 任务标题.
	 * 
	 * @param title
	 *            the new 任务标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets the 任务描述.
	 * 
	 * @return the 任务描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the 任务描述.
	 * 
	 * @param description
	 *            the new 任务描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
