package com.howin.qiulu.pojo;

/**
 * FavoritesResult entity. @author MyEclipse Persistence Tools
 */

public class FavoritesResult implements java.io.Serializable {

	// Fields

	private FavoritesResultId id;

	// Constructors

	/** default constructor */
	public FavoritesResult() {
	}

	/** full constructor */
	public FavoritesResult(FavoritesResultId id) {
		this.id = id;
	}

	// Property accessors

	public FavoritesResultId getId() {
		return this.id;
	}

	public void setId(FavoritesResultId id) {
		this.id = id;
	}

}