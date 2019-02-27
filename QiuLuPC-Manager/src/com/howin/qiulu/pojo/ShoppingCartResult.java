package com.howin.qiulu.pojo;

/**
 * ShoppingCartResult entity. @author MyEclipse Persistence Tools
 */

public class ShoppingCartResult implements java.io.Serializable {

	// Fields

	private ShoppingCartResultId id;

	// Constructors

	/** default constructor */
	public ShoppingCartResult() {
	}

	/** full constructor */
	public ShoppingCartResult(ShoppingCartResultId id) {
		this.id = id;
	}

	// Property accessors

	public ShoppingCartResultId getId() {
		return this.id;
	}

	public void setId(ShoppingCartResultId id) {
		this.id = id;
	}

}