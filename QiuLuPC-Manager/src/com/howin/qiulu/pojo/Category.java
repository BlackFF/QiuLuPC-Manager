package com.howin.qiulu.pojo;

/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer parentId;
	private String skuParamData;
	private String itemParamData;
	private Short isParent;

	// Constructors

	/** default constructor */
	public Category() {
	}

	/** minimal constructor */
	public Category(String name, Short isParent) {
		this.name = name;
		this.isParent = isParent;
	}

	/** full constructor */
	public Category(String name, Integer parentId, String skuParamData,
			String itemParamData, Short isParent) {
		this.name = name;
		this.parentId = parentId;
		this.skuParamData = skuParamData;
		this.itemParamData = itemParamData;
		this.isParent = isParent;
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

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getSkuParamData() {
		return this.skuParamData;
	}

	public void setSkuParamData(String skuParamData) {
		this.skuParamData = skuParamData;
	}

	public String getItemParamData() {
		return this.itemParamData;
	}

	public void setItemParamData(String itemParamData) {
		this.itemParamData = itemParamData;
	}

	public Short getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Short isParent) {
		this.isParent = isParent;
	}

}