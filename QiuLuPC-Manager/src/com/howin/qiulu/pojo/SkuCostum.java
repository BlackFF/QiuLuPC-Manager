package com.howin.qiulu.pojo;

/**
 * SkuCostum entity. @author MyEclipse Persistence Tools
 */

public class SkuCostum implements java.io.Serializable {

	// Fields

	private SkuCostumId id;

	// Constructors

	/** default constructor */
	public SkuCostum() {
	}

	/** full constructor */
	public SkuCostum(SkuCostumId id) {
		this.id = id;
	}

	// Property accessors

	public SkuCostumId getId() {
		return this.id;
	}

	public void setId(SkuCostumId id) {
		this.id = id;
	}

}