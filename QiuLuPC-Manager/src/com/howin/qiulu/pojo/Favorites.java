package com.howin.qiulu.pojo;

/**
 * Favorites entity. @author MyEclipse Persistence Tools
 */

public class Favorites implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer skuId;
	private Integer status;

	// Constructors

	/** default constructor */
	public Favorites() {
	}

	/** full constructor */
	public Favorites(Integer userId, Integer skuId, Integer status) {
		this.userId = userId;
		this.skuId = skuId;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getSkuId() {
		return this.skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}