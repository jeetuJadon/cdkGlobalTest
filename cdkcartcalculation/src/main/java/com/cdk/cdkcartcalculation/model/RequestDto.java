package com.cdk.cdkcartcalculation.model;

public class RequestDto {

	String customerType;
    double totalAmount;
	
	
 public	RequestDto()
	{
		
	}
	
	public String getCustomerType() {
		return customerType;
	}


	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}


	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}	
 
@Override
public String toString() {
	// TODO Auto-generated method stub
	return  "Customer Type :"+this.customerType+" Total Amount "+this.totalAmount;
}
	
}
