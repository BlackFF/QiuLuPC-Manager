package com.howin.qiulu.pojo;

/**
 * ShoppingCartResultId entity. @author MyEclipse Persistence Tools
 */

public class ShoppingCartResultId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer skuId;
	private String image;
	private String sellPoint;
	private String deliveryPlace;
	private Double price;
	private Double discount;
	private Integer number;
	private Float total;
	private Integer userId;
	private Integer status;

	// Constructors

	/** default constructor */
	public ShoppingCartResultId() {
	}

	/** minimal constructor */
	public ShoppingCartResultId(Integer id, Integer skuId, Integer number,
			Float total) {
		this.id = id;
		this.skuId = skuId;
		this.number = number;
		this.total = total;
	}

	/** full constructor */
	public ShoppingCartResultId(Integer id, Integer skuId, String image,
			String sellPoint, String deliveryPlace, Double price,
			Double discount, Integer number, Float total,Integer userId,Integer status) {
		this.id = id;
		this.skuId = skuId;
		this.image = image;
		this.sellPoint = sellPoint;
		this.deliveryPlace = deliveryPlace;
		this.price = price;
		this.discount = discount;
		this.number = number;
		this.total = total;
		this.userId=userId;
		this.status=status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSkuId() {
		return this.skuId;
	}

	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
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

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Float getTotal() {
		return this.total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
    
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ShoppingCartResultId))
			return false;
		ShoppingCartResultId castOther = (ShoppingCartResultId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getSkuId() == castOther.getSkuId()) || (this
						.getSkuId() != null && castOther.getSkuId() != null && this
						.getSkuId().equals(castOther.getSkuId())))
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
				&& ((this.getPrice() == castOther.getPrice()) || (this
						.getPrice() != null && castOther.getPrice() != null && this
						.getPrice().equals(castOther.getPrice())))
				&& ((this.getDiscount() == castOther.getDiscount()) || (this
						.getDiscount() != null
						&& castOther.getDiscount() != null && this
						.getDiscount().equals(castOther.getDiscount())))
				&& ((this.getNumber() == castOther.getNumber()) || (this
						.getNumber() != null && castOther.getNumber() != null && this
						.getNumber().equals(castOther.getNumber())))
				&& ((this.getTotal() == castOther.getTotal()) || (this
						.getTotal() != null && castOther.getTotal() != null && this
						.getTotal().equals(castOther.getTotal())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getStatus() == castOther.getStatus()) || (this
						.getStatus() != null && castOther.getStatus() != null && this
						.getStatus().equals(castOther.getStatus())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getSkuId() == null ? 0 : this.getSkuId().hashCode());
		result = 37 * result
				+ (getImage() == null ? 0 : this.getImage().hashCode());
		result = 37 * result
				+ (getSellPoint() == null ? 0 : this.getSellPoint().hashCode());
		result = 37
				* result
				+ (getDeliveryPlace() == null ? 0 : this.getDeliveryPlace()
						.hashCode());
		result = 37 * result
				+ (getPrice() == null ? 0 : this.getPrice().hashCode());
		result = 37 * result
				+ (getDiscount() == null ? 0 : this.getDiscount().hashCode());
		result = 37 * result
				+ (getNumber() == null ? 0 : this.getNumber().hashCode());
		result = 37 * result
				+ (getTotal() == null ? 0 : this.getTotal().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getStatus() == null ? 0 : this.getStatus().hashCode());
		return result;
	}

}