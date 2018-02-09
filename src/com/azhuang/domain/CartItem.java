package com.azhuang.domain;

import java.io.Serializable;

public class CartItem implements Serializable {

	private Product product;
	private int count;

	private double subtotal;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getSubtotal() {
		return product.getShop_price() * 1.0 * count;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public CartItem(Product product, int count) {
		super();
		this.product = product;
		this.count = count;
	}

}
