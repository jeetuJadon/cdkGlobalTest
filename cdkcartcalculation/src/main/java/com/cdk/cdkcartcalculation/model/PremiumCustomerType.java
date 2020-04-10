package com.cdk.cdkcartcalculation.model;

import java.util.SortedSet;


public class PremiumCustomerType extends CustomerType {

	public PremiumCustomerType(SortedSet<CustomerDiscount> customerDiscountConfig) {
		this.custDiscountConfiguration = customerDiscountConfig;
	}

	// method for calculating discount from availableAmount
	public double calculateAvailableDiscount(double amount) {
		System.out.println("Inside premium : calculate discount amount for :"+amount);

		double newAmount = 0;
		double tmpAmount = amount;
		boolean isProcessedFirstTime = false;
		for (CustomerDiscount customerDiscount : this.custDiscountConfiguration) {
			customerDiscount.toString();
			if (isProcessedFirstTime) {
				newAmount = newAmount + customerDiscount.getCalculatedDiscountAmount();
			} else if (customerDiscount.getMinAmount() < tmpAmount) {
				double currentAmnt = tmpAmount - customerDiscount.getMinAmount();
				currentAmnt = (currentAmnt - (currentAmnt * customerDiscount.getDiscount() / 100));
				newAmount = newAmount + currentAmnt;
				isProcessedFirstTime = true;
			}

		}
		return newAmount;
	}

}
