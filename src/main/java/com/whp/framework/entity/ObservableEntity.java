package com.whp.framework.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.Observable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

/**
 * 观察者模式父类,统一定义id的entity基类.<br>
 * 处理有关联的对象之间状态改变后的触发动作 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 */
// JPA 基类的标识
@MappedSuperclass
public abstract class ObservableEntity extends Observable implements Serializable{
	/** 描述 */
	private static final long serialVersionUID = 8430941165882152228L;
	// 当主键ID类型为Long并使用Oracle数据库时使用序列存储主键值
	// @Id
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ud")
	// @SequenceGenerator(name = "ud",sequenceName =
	// "hibernate_seq",allocationSize = 1,initialValue = 2)
	// protected Long id;
	// public Long getId() {
	// return id;
	// }
	// public void setId(Long id) {
	// this.id = id;
	// }
	/* 当主键ID类型为String并使用UUID时使用以下方式 */
	@Id
	@GenericGenerator(name = "ObservableEntity-uuid", strategy = "uuid")
	@GeneratedValue(generator = "ObservableEntity-uuid")
	@Column(name = "id", length = 36)
	protected String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 作为被观察者时，通知观察者自身发生变化的方法.
	 * 
	 * @param message
	 *            the message
	 * @see [类、类#方法、类#成员]
	 */
	public void changed(Map<String, String> message) {
		this.setChanged();
		this.notifyObservers(message);
	}
	/**
	 * 作为被观察者时，通知观察者自身发生变化的方法.
	 * 
	 * @param message
	 *            the message
	 * @see [类、类#方法、类#成员]
	 */
	public void changed(Object message) {
		this.setChanged();
		this.notifyObservers(message);
	}
}
