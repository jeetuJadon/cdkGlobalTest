package com.cdk.cdkcartcalculation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdk.cdkcartcalculation.model.CustomerType;
import com.cdk.cdkcartcalculation.model.CustomerTypeFactory;

@Service
public class CustomerTypeDiscountService {

	@Autowired
	CustomerTypeFactory customerTypeFactory;

	public double calculateDiscountedPrice(String custType, double curentprice) throws Exception {
      System.out.println("calculateDiscountedPrice starts" +custType+"curentprice  "+curentprice );
		
		CustomerType custTyp = customerTypeFactory.getCustomerType(custType);
		double discountedPrice = custTyp.calculateAvailableDiscount(curentprice);
		System.out.println("calculateDiscountedPrice ends");
		return discountedPrice;
		
	
	}

}
