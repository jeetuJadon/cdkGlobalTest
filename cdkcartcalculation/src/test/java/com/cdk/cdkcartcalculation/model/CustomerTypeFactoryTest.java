package com.cdk.cdkcartcalculation.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.cdk.cdkcartcalculation.exceptions.CustomerTypeException;

public class CustomerTypeFactoryTest {

	
// It should throw exception for Invalid customer type	
	@Test
	void testInvalidCustomerType() {
		CustomerTypeFactory customerTypeFactory = new CustomerTypeFactory();
		assertThrows(CustomerTypeException.class,  () -> {
			customerTypeFactory.getCustomerType("gold");
	    });
	}
	
}
