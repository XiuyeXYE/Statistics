package com.xy.bean;

public class Result<DataType> {

	
	private boolean success;
	private DataType data;
	private String msg;
	private Object status;
	
	public Result() {
		
	}
	
	public Result(boolean success, DataType data, String msg, Object status) {
		this.success = success;
		this.data = data;
		this.msg = msg;
		this.status = status;
	}
	
	public DataType getData() {
		return data;
	}
	public String getMsg() {
		return msg;
	}
	public Object getStatus() {
		return status;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setData(DataType data) {
		this.data = data;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setStatus(Object status) {
		this.status = status;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	@Override
	public String toString() {
		return "Result [status=" + status + ", success=" + success + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
}
