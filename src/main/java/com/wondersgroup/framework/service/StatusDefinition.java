package com.wondersgroup.framework.service;

import org.apache.commons.lang3.StringUtils;

import com.wondersgroup.framework.entity.StatusObj;

/**
 * <th>注册业务流程状态定义</th>
 * 该接口定义默认的对象审核流程，对应系统中的管理动作为:保存、提交、审核、驳回、删除、作废<br>
 * @author zpfox
 * 
 */
public interface StatusDefinition<T extends StatusObj>{
	/**
	 * 注册业务流程事件枚举.
	 * 
	 * @author zpfox
	 */
	public enum RegStatus {
		/** 保存操作与操作后对应的状态码. */
		OPER_SAVE("10", "已保存"),
		/** 提交操作与操作后对应的状态码. */
		OPER_SUBMIT("20", "已提交"),
		/** 审核操作与操作后对应的状态码. */
		OPER_AUDIT("30", "已审核"),
		/** 驳回操作与操作后对应的状态码. */
		OPER_REJECT("40", "已驳回"),
		/** 删除操作与操作后对应的状态码. */
		OPER_DELETE("80", "已删除"),
		/** 作废操作与操作后对应的状态码. */
		OPER_OBSOLETE("99", "已作废"),
		OPER_KGPT("1", "卡管平台"),
		OPER_GYS("2", "供应商"),
		OPER_HZYH("3", "合作银行");
		/**
		 * 数据类型
		 */
	
		

		/** 状态代码. */
		private String code;

		/** 状态名称. */
		private String name;

		/**
		 * Instantiates a new handle events.
		 * 
		 * @param code
		 *            the code
		 * @param name
		 *            the name
		 */
		private RegStatus(String code, String name) {
			this.code = code;
			this.name = name;
		}

		/**
		 * Gets the 状态代码.
		 * 
		 * @return the 状态代码
		 */
		public String getCode() {
			return code;
		}

		/**
		 * Sets the 状态代码.
		 * 
		 * @param code
		 *            the new 状态代码
		 */
		public void setCode(String code) {
			this.code = code;
		}

		/**
		 * Gets the 状态名称.
		 * 
		 * @return the 状态名称
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the 状态名称.
		 * 
		 * @param name
		 *            the new 状态名称
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * 根据编码得到状态名称.
		 * 
		 * @param code
		 *            the code
		 * @return the name
		 */
		public static String getName(String code) {
			for (RegStatus event : RegStatus.values()) {
				if (StringUtils.equals(event.getCode(), code)) {
					return event.getName();
				}
			}
			return null;
		}

		/**
		 * 根据代码获得枚举对象
		 * 
		 * @param code
		 * @return
		 */
		public static RegStatus byCode(String code) {
			for (RegStatus event : RegStatus.values()) {
				if (StringUtils.equals(event.getCode(), code)) {
					return event;
				}
			}
			return null;
		}
	}

	/**
	 * 根据业务流程状态更新对象的状态
	 * 
	 * @param id
	 * @param operCode
	 */
	public T manageOper (T obj, String operCode);

	/**
	 * 根据业务流程状态更新对象的状态
	 * 
	 * @param id
	 * @param operCode
	 */
	public T manageOper(T obj, RegStatus operCode);
}
