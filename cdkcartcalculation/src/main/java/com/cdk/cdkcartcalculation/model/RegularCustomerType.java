package com.cdk.cdkcartcalculation.model;

import java.util.SortedSet;

public class RegularCustomerType extends CustomerType {

	public RegularCustomerType(SortedSet<CustomerDiscount> customerDiscountConfig) {
		this.custDiscountConfiguration = customerDiscountConfig;
	}

	// method for calculating Regular customer
	public double calculateAvailableDiscount(double amount) {
		System.out.println("Inside regular calculateAvailableDiscount starts");
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
