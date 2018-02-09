package com.azhuang.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart implements Serializable {

	// 购物车项
	private Map<String, CartItem> maps = new HashMap<String, CartItem>();

	private double total = 0.0;

	// add2Cart(购物车项)
	// removeFromCart(String 商品的id)
	// clearCart()
	public void add2Cart(CartItem cartItem) {
		// 获取商品

		Product product = cartItem.getProduct();
//		maps = getMaps();
		System.out.println("maps = " + maps);
		// 判断该商品之前是否加入购物车
		if (maps == null) {
			maps = new HashMap<String, CartItem>();
		}
		if (!maps.containsKey(product.getCid())) {
			maps.put(product.getPid(), cartItem);

		} else {
			// 在之前基础上再往上加
			CartItem cartItem2 = maps.get(product.getPid());
			cartItem2.setCount(cartItem.getCount() + cartItem2.getCount());

		}
		// 计算总共的费用
		total += cartItem.getSubtotal();
	}

	public Map<String, CartItem> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, CartItem> maps) {
		this.maps = maps;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * 获取item的value
	 */
	public Collection<CartItem> getItems() {

		return maps.values();
	}

	public void clear() {
		// TODO Auto-generated method stub
		maps.clear();
		maps = null;
		total = 0.0;
	}
}
