package com.whp.framework.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.whp.framework.entity.StatusObj;
import com.whp.framework.exception.ServiceException;

/**
 * 对象状态默认处理实现类<br>
 * 适配器模式的应用<br>
 * 检查传入的对象是否处于可以修改的业务状态<br>
 * 如果可以修改返回:true,否则返回false;<br>
 * 默认判断规则是：<br>
 * 1、“已保存”状态下的对象只能执行更新、删除动作； 2、“已提交”状态下的对象只能执行审核、驳回、作废动作； 3、“已审核”状态下的对象只能执行作废动作；
 * 4、"已作废"状态下的对象不能执行任何操作；
 * 
 * @author zpfox
 * @see StatusObj
 * @param <T extends StatusObj>
 */
@Transactional
@Service
public class StatusDefinitionImpl<T extends StatusObj> implements StatusDefinition<T> {
	
	/**
	 * 对于对象的默认业务处理流程<br>
	 * 除保存操作，支持提交动作、审核动作、驳回动作、作废动作
	 */
	@Override
	public synchronized T manageOper(T obj, String operStatus) {
		//检查传入的对象是否满足处理条件
		verify(obj);
		String tempStatus = null;
		switch (RegStatus.byCode(operStatus)) {
		case OPER_SUBMIT:// 提交操作,该步骤只处理状态为“已保存”的业务对象.
			if (StringUtils.equals(obj.getStatus(), RegStatus.OPER_SAVE.getCode())) {
				tempStatus = RegStatus.OPER_SUBMIT.getCode();
			} else {
				throw new ServiceException("只能操作状态为：“已保存”的业务对象！");
			}
			break;
		case OPER_AUDIT:// 处理审核操作
			if (StringUtils.equals(obj.getStatus(), RegStatus.OPER_SUBMIT.getCode())) {
				tempStatus = RegStatus.OPER_AUDIT.getCode();
			} else {
				throw new ServiceException("只能操作状态为：“已提交”的业务对象！");
			}
			break;
		case OPER_REJECT:// 驳回操作
			if (StringUtils.equals(obj.getStatus(), RegStatus.OPER_SUBMIT.getCode())) {
				tempStatus = RegStatus.OPER_SAVE.getCode();
			} else {
				throw new ServiceException("只能操作状态为：“已提交”的业务对象！");
			}
			break;
		case OPER_OBSOLETE:// 作废操作
			if (!StringUtils.equals(obj.getStatus(), RegStatus.OPER_SAVE.getCode())) {
				tempStatus = RegStatus.OPER_OBSOLETE.getCode();
			} else {
				throw new ServiceException("“已保存”的业务对象可以执行删除！");
			}
			break;
		default:
			throw new ServiceException("流程处理时传入了未知的事件！");
		}
		obj.setStatus(tempStatus);
		
		return obj;
	}

	/**
	 * 方法重载
	 */
	@Override
	public T manageOper(T obj, RegStatus operCode) {
		return manageOper(obj, operCode.getCode());
	}

	/**
	 * 辅助方法--验证待处理的对象是否满足该流程的处理条件
	 * @param obj
	 * @return
	 */
	private void verify(T obj) {
		if (null == obj) {
			throw new ServiceException("没有找到此对象！");
		} else if (StringUtils.isBlank(obj.getStatus())) {// 否则如果业务对象状态代码为空，也无法处理
			throw new ServiceException("业务对象状态代码为空，也无法处理！");
		} else if (StringUtils.isBlank(RegStatus.getName(obj.getStatus()))) {// 否则该对象的status代码不在RegStatus的定义范围，仍然无法处理！
			throw new ServiceException("未知的状态代码，也无法处理！");
		}
	}

}
