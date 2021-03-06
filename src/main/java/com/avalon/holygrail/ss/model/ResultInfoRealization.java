package com.avalon.holygrail.ss.model;

import com.avalon.holygrail.ss.norm.ResultCode;
import com.avalon.holygrail.ss.norm.ResultInfo;

import java.util.Collection;

/**
 * 系统提示结果集
 */
public class ResultInfoRealization implements ResultInfo {

	/**消息提示类型*/
	private ResultCode resultCode;
	
	/**提示代码*/
	private int messageCode;
	
	/**提示信息*/
	private String message;
	
	/**异常信息*/
	private String exceptionMessage;

	/**提示信息明细列表*/
	private Collection<ResultInfo> details;
	
	public ResultInfoRealization(ResultCode resultCode, String message) {
		this.resultCode = resultCode;
		this.message = message;
	}
	public ResultInfoRealization(ResultCode resultCode, String message, String exceptionMessage) {
		this.resultCode = resultCode;
		this.message = message;
		this.exceptionMessage = exceptionMessage;
	}
	public ResultInfoRealization(ResultCode resultCode, int messageCode, String message) {
		this.resultCode = resultCode;
		this.messageCode = messageCode;
		this.message = message;
	}

	public ResultInfoRealization(ResultCode resultCode, Collection<ResultInfo> details) {
		this.resultCode = resultCode;
		this.details = details;
	}
	public ResultInfoRealization(ResultCode resultCode, int messageCode, Collection<ResultInfo> details) {
		this.resultCode = resultCode;
		this.messageCode = messageCode;
		this.details = details;
	}
	
	public boolean isSuccess() {
		return this.resultCode.isSuccess();
	}

	@Override
	public boolean isFail() {
		return this.resultCode.isFail();
	}

	@Override
	public boolean isError() {
		return this.resultCode.isError();
	}

	//------------------------------------get set---------------------------------------//
	
	public Collection<ResultInfo> getDetails() {
		return details;
	}

	public void setDetails(Collection<ResultInfo> details) {
		this.details = details;
	}

	public int getType() {
		return resultCode.getCode();
	}

	public void setType(ResultCode type) {
		this.resultCode = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getMessageCode() {
		return messageCode;
	}
	
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	
}
