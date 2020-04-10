package com.cdk.cdkcartcalculation.model;

public class Item {

	private Double amount;
	private String itemName;

	public Item() {
	}

public Item(String itemName, Double amount) {
		this.itemName = itemName;
		this.amount = amount;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ itemName :" + this.itemName + " , amount :" + this.amount + " ]";
	}

}
