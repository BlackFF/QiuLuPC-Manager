package com.howin.qiulu.result;

/**
 * 
* @Title: QiuluResult
* @Description: 用于向前台返回格式化的数据
* @author 吴磊
* @date 2017年2月20日上午9:33:38
 */
public class QiuluResult {

	//用于显示请求的状态true：成功/false：失败
	private boolean status;
	//用于包装需要向前台传送的数据
	private Object object;
	//请求的信息
	private String message;
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public static QiuluResult failure(){
		QiuluResult result = new QiuluResult();
		return result;
	}
	public static QiuluResult ok(Object object){
		QiuluResult result = new QiuluResult();
		result.setStatus(true);
		result.setObject(object);
		return result;
	}
	
}
