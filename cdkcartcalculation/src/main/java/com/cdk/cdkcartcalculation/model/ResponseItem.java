package com.cdk.cdkcartcalculation.model;

public class ResponseItem {
 
private double totalAmount;
private double amountAfterDiscount;

ResponseItem(){
	}

public ResponseItem(double totalAmount, double amountAfterDiscount){
	this.totalAmount = totalAmount;
	this.amountAfterDiscount = amountAfterDiscount;
}

public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
public double getAmountAfterDiscount() {
	return amountAfterDiscount;
}
public void setAmountAfterDiscount(double amountAfterDiscount) {
	this.amountAfterDiscount = amountAfterDiscount;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "[ totalAmount :"+this.totalAmount+" , amountAfterDiscount :"+this.amountAfterDiscount+" ]";
	}
	
}
