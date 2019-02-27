package com.howin.qiulu.pojo;

public class Express implements java.io.Serializable{

	private int id;
	private String expressName;
	private String expressValue;
	
	public Express(){}
	
	public Express(String expressName,String expressValue){
		this.expressName=expressName;
		this.expressValue=expressValue;
	} 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getexpressName() {
		return expressName;
	}
	public void setexpressName(String expressName) {
		this.expressName = expressName;
	}
	public String getExpressValue() {
		return expressValue;
	}
	public void setExpressValue(String expressValue) {
		this.expressValue = expressValue;
	}
	
	
}
