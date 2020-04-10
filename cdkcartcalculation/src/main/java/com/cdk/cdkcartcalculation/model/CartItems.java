package com.cdk.cdkcartcalculation.model;

import java.util.List;

public class CartItems {

	private String customerType;
	private List<Item> cartItems;

	public CartItems() {

	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public List<Item> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "[ customerType :"+this.customerType+ ", cartItems : "+this.cartItems+" ]";
	}
	
}
