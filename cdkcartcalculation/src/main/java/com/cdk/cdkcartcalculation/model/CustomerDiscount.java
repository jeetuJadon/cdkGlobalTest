package com.cdk.cdkcartcalculation.model;

public class CustomerDiscount implements Comparable<CustomerDiscount> {

	private Double minAmount;
	private Double maxAmount;
	private Integer discount;
	private Double calculatedDiscountAmount;

	public CustomerDiscount(Double minAmount, Double maxAmount, Integer discount) {
		this.minAmount = minAmount;
		this.maxAmount = maxAmount;
		this.discount = discount;
		if (maxAmount != null) {
			Double tmpAmount = maxAmount - minAmount;
			this.calculatedDiscountAmount = (tmpAmount - (tmpAmount * discount / 100));
		}
	}

	public Double getCalculatedDiscountAmount() {
		return calculatedDiscountAmount;
	}

	public void setCalculatedDiscountAmount(Double calculatedDiscountAmount) {
		this.calculatedDiscountAmount = calculatedDiscountAmount;
	}

	public Double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(Double minAmount) {
		this.minAmount = minAmount;
	}

	public Double getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	@Override
	public int compareTo(CustomerDiscount cusDiscount) {
		// Auto-generated method stub
		return cusDiscount.getMinAmount().compareTo(this.getMinAmount());
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "minAmount :"+this.minAmount + "maxAmount :"+this.maxAmount+"discount "+this.discount+
				"discountedAmount :"+this.calculatedDiscountAmount;
	}

}
