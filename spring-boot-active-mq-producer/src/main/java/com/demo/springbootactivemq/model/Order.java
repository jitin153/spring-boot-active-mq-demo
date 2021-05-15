package com.demo.springbootactivemq.model;

import java.math.BigDecimal;
import java.util.List;
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

	public Order(Long orderId, List<Product> products, String deliveryAddress) {
		super();
		this.orderId = orderId;
		this.products = products;
		this.deliveryAddress = deliveryAddress;
		this.setTotalItems();
		this.setTotalPrice();
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

	public void setTotalItems() {
		this.totalItems = (short) this.products.size();
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice() {
		BigDecimal totalAmountToBePaid = new BigDecimal(0);
		for (Product product : products) {
			totalAmountToBePaid = totalAmountToBePaid
					.add(product.getPrice().multiply(new BigDecimal(product.getQuantity())));
		}
		this.totalPrice = totalAmountToBePaid;
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
