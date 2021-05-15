package com.demo.springbootactivemq.model;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * This order class should be in same package on both
 * producer & consumer side else you'll end up with
 * an error on consumer side.
 */
public class Order {
	private Long orderId;
	private List<Product> products;
	private Short totalItems;
	private BigDecimal totalPrice;
	private String deliveryAddress;

	public Order() {}

	//@JsonCreator
	//public Order(@JsonProperty("orderId") Long orderId, @JsonProperty("products") List<Product> products,
			//@JsonProperty("totalItems") Short totalItems, @JsonProperty("totalPrice") BigDecimal totalPrice,
			//@JsonProperty("deliveryAddress") String deliveryAddress) {
	public Order(Long orderId, List<Product> products, Short totalItems, BigDecimal totalPrice,String deliveryAddress) {	
		this.orderId = orderId;
		this.products = products;
		this.totalItems = totalItems;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Short getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Short totalItems) {
		this.totalItems = totalItems;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", products=" + products + ", totalItems=" + totalItems + ", totalPrice="
				+ totalPrice + ", deliveryAddress=" + deliveryAddress + "]";
	}

}
