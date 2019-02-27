package com.howin.qiulu.pojo;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String paramData;
	private Integer categoryId;
	private String itemDetail;

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(String name, String paramData, Integer categoryId) {
		this.name = name;
		this.paramData = paramData;
		this.categoryId = categoryId;
	}

	/** full constructor */
	public Item(String name, String paramData, Integer categoryId,
			String itemDetail) {
		this.name = name;
		this.paramData = paramData;
		this.categoryId = categoryId;
		this.itemDetail = itemDetail;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParamData() {
		return this.paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getItemDetail() {
		return this.itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

}