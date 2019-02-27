package com.howin.qiulu.pojo;

/**
 * FavoritesResultId entity. @author MyEclipse Persistence Tools
 */

public class FavoritesResultId implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer skuId;
	private Integer userId;
	private String image;
	private String sellPoint;
	private Double price;

	// Constructors

	/** default constructor */
	public FavoritesResultId() {
	}

	/** minimal constructor */
	public FavoritesResultId(Integer id, Integer skuId, Integer userId) {
		this.id = id;
		this.skuId = skuId;
		this.userId = userId;
	}

	/** full constructor */
	public FavoritesResultId(Integer id, Integer skuId, Integer userId,
			String image, String sellPoint, Double price) {
		this.id = id;
		this.skuId = skuId;
		this.userId = userId;
		this.image = image;
		this.sellPoint = sellPoint;
		this.price = price;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FavoritesResultId))
			return false;
		FavoritesResultId castOther = (FavoritesResultId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getSkuId() == castOther.getSkuId()) || (this
						.getSkuId() != null && castOther.getSkuId() != null && this
						.getSkuId().equals(castOther.getSkuId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getImage() == castOther.getImage()) || (this
						.getImage() != null && castOther.getImage() != null && this
						.getImage().equals(castOther.getImage())))
				&& ((this.getSellPoint() == castOther.getSellPoint()) || (this
						.getSellPoint() != null
						&& castOther.getSellPoint() != null && this
						.getSellPoint().equals(castOther.getSellPoint())))
				&& ((this.getPrice() == castOther.getPrice()) || (this
						.getPrice() != null && castOther.getPrice() != null && this
						.getPrice().equals(castOther.getPrice())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getSkuId() == null ? 0 : this.getSkuId().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getImage() == null ? 0 : this.getImage().hashCode());
		result = 37 * result
				+ (getSellPoint() == null ? 0 : this.getSellPoint().hashCode());
		result = 37 * result
				+ (getPrice() == null ? 0 : this.getPrice().hashCode());
		return result;
	}

}