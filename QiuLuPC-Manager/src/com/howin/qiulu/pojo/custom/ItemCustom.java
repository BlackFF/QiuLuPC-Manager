package com.howin.qiulu.pojo.custom;

import java.util.List;

import com.howin.qiulu.pojo.Item;
import com.howin.qiulu.pojo.Sku;

public class ItemCustom {

	private Item item;
	
	private List<Sku> skus;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public List<Sku> getSkus() {
		return skus;
	}

	public void setSkus(List<Sku> skus) {
		this.skus = skus;
	}
	
}
