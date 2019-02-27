package com.howin.qiulu.pojo;

/**
 * UserDetail entity. @author MyEclipse Persistence Tools
 */

public class UserDetail implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String name;
	private Integer gender;
	private String birthday;
	private String headPort;
	private String email;
	private String province;
	private String city;
	private String area;
	private String adress;
	private Short vip;

	// Constructors

	/** default constructor */
	public UserDetail() {
	}

	/** minimal constructor */
	public UserDetail(Short vip) {
		this.vip = vip;
	}

	/** full constructor */
	public UserDetail(String name, Integer gender, String birthday,
			String headPort, String email, String province, String city,
			String area, String adress, Short vip) {
		this.name = name;
		this.gender = gender;
		this.birthday = birthday;
		this.headPort = headPort;
		this.email = email;
		this.province = province;
		this.city = city;
		this.area = area;
		this.adress = adress;
		this.vip = vip;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getHeadPort() {
		return this.headPort;
	}

	public void setHeadPort(String headPort) {
		this.headPort = headPort;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Short getVip() {
		return this.vip;
	}

	public void setVip(Short vip) {
		this.vip = vip;
	}

}