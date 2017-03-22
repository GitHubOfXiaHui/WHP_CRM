package com.wondersgroup.framework.utils.servlet;

import java.io.IOException;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.wondersgroup.framework.service.StatusDefinition.RegStatus;

/**
 * The Class CodeToNameTld.
 * 自定义标签--将默认审核流程状态代码转换为中文显示<br>
 * 具体内容请参考StatusDefinition.RegStatus枚举
 * @author zpfox
 */
public class CodeToNameTld extends TagSupport implements javax.servlet.jsp.tagext.Tag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 标签属性code. */
	private String code = null;

	/** 标签结束方法 */
	@Override
	public int doEndTag() throws JspTagException {
		JspWriter out = this.pageContext.getOut();
		try {
			// 标签的返回值
			out.println(RegStatus.getName(code));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	/**
	 * Gets the 标签属性code.
	 * 
	 * @return the 标签属性code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the 标签属性code.
	 * 
	 * @param code
	 *            the new 标签属性code
	 */
	public void setCode(String code) {
		this.code = code;
	}

}
