package com.howin.qiulu.pojo;

import java.sql.Timestamp;

/**
 * SkuCostumId entity. @author MyEclipse Persistence Tools
 */

public class SkuCostumId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer itemId;
	private Double price;
	private Double discount;
	private Integer repertory;
	private Integer warnRepertory;
	private String image;
	private String sellPoint;
	private String deliveryPlace;
	private Integer salesVolume;
	private String paramData;
	private Integer status;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public SkuCostumId() {
	}

	/** minimal constructor */
	public SkuCostumId(Integer id, Integer itemId, Double price,
			Double discount, Integer repertory, Integer warnRepertory,
			String image, String sellPoint, String deliveryPlace,
			Integer salesVolume, String paramData, Integer status) {
		this.id = id;
		this.itemId = itemId;
		this.price = price;
		this.discount = discount;
		this.repertory = repertory;
		this.warnRepertory = warnRepertory;
		this.image = image;
		this.sellPoint = sellPoint;
		this.deliveryPlace = deliveryPlace;
		this.salesVolume = salesVolume;
		this.paramData = paramData;
		this.status = status;
	}

	/** full constructor */
	public SkuCostumId(Integer id, Integer itemId, Double price,
			Double discount, Integer repertory, Integer warnRepertory,
			String image, String sellPoint, String deliveryPlace,
			Integer salesVolume, String paramData, Integer status,
			Timestamp createTime) {
		this.id = id;
		this.itemId = itemId;
		this.price = price;
		this.discount = discount;
		this.repertory = repertory;
		this.warnRepertory = warnRepertory;
		this.image = image;
		this.sellPoint = sellPoint;
		this.deliveryPlace = deliveryPlace;
		this.salesVolume = salesVolume;
		this.paramData = paramData;
		this.status = status;
		this.createTime = createTime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return this.itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return this.discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getRepertory() {
		return this.repertory;
	}

	public void setRepertory(Integer repertory) {
		this.repertory = repertory;
	}

	public Integer getWarnRepertory() {
		return this.warnRepertory;
	}

	public void setWarnRepertory(Integer warnRepertory) {
		this.warnRepertory = warnRepertory;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSellPoint() {
		return this.sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public String getDeliveryPlace() {
		return this.deliveryPlace;
	}

	public void setDeliveryPlace(String deliveryPlace) {
		this.deliveryPlace = deliveryPlace;
	}

	public Integer getSalesVolume() {
		return this.salesVolume;
	}

	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

	public String getParamData() {
		return this.paramData;
	}

	public void setParamData(String paramData) {
		this.paramData = paramData;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SkuCostumId))
			return false;
		SkuCostumId castOther = (SkuCostumId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getItemId() == castOther.getItemId()) || (this
						.getItemId() != null && castOther.getItemId() != null && this
						.getItemId().equals(castOther.getItemId())))
				&& ((this.getPrice() == castOther.getPrice()) || (this
						.getPrice() != null && castOther.getPrice() != null && this
						.getPrice().equals(castOther.getPrice())))
				&& ((this.getDiscount() == castOther.getDiscount()) || (this
						.getDiscount() != null
						&& castOther.getDiscount() != null && this
						.getDiscount().equals(castOther.getDiscount())))
				&& ((this.getRepertory() == castOther.getRepertory()) || (this
						.getRepertory() != null
						&& castOther.getRepertory() != null && this
						.getRepertory().equals(castOther.getRepertory())))
				&& ((this.getWarnRepertory() == castOther.getWarnRepertory()) || (this
						.getWarnRepertory() != null
						&& castOther.getWarnRepertory() != null && this
						.getWarnRepertory()
						.equals(castOther.getWarnRepertory())))
				&& ((this.getImage() == castOther.getImage()) || (this
						.getImage() != null && castOther.getImage() != null && this
						.getImage().equals(castOther.getImage())))
				&& ((this.getSellPoint() == castOther.getSellPoint()) || (this
						.getSellPoint() != null
						&& castOther.getSellPoint() != null && this
						.getSellPoint().equals(castOther.getSellPoint())))
				&& ((this.getDeliveryPlace() == castOther.getDeliveryPlace()) || (this
						.getDeliveryPlace() != null
						&& castOther.getDeliveryPlace() != null && this
						.getDeliveryPlace()
						.equals(castOther.getDeliveryPlace())))
				&& ((this.getSalesVolume() == castOther.getSalesVolume()) || (this
						.getSalesVolume() != null
						&& castOther.getSalesVolume() != null && this
						.getSalesVolume().equals(castOther.getSalesVolume())))
				&& ((this.getParamData() == castOther.getParamData()) || (this
						.getParamData() != null
						&& castOther.getParamData() != null && this
						.getParamData().equals(castOther.getParamData())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())))
				&& ((this.getCreateTime() == castOther.getCreateTime()) || (this
						.getCreateTime() != null
						&& castOther.getCreateTime() != null && this
						.getCreateTime().equals(castOther.getCreateTime())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getItemId() == null ? 0 : this.getItemId().hashCode());
		result = 37 * result
				+ (getPrice() == null ? 0 : this.getPrice().hashCode());
		result = 37 * result
				+ (getDiscount() == null ? 0 : this.getDiscount().hashCode());
		result = 37 * result
				+ (getRepertory() == null ? 0 : this.getRepertory().hashCode());
		result = 37
				* result
				+ (getWarnRepertory() == null ? 0 : this.getWarnRepertory()
						.hashCode());
		result = 37 * result
				+ (getImage() == null ? 0 : this.getImage().hashCode());
		result = 37 * result
				+ (getSellPoint() == null ? 0 : this.getSellPoint().hashCode());
		result = 37
				* result
				+ (getDeliveryPlace() == null ? 0 : this.getDeliveryPlace()
						.hashCode());
		result = 37
				* result
				+ (getSalesVolume() == null ? 0 : this.getSalesVolume()
						.hashCode());
		result = 37 * result
				+ (getParamData() == null ? 0 : this.getParamData().hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		result = 37
				* result
				+ (getCreateTime() == null ? 0 : this.getCreateTime()
						.hashCode());
		return result;
	}

}