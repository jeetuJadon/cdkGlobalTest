package com.cdk.cdkcartcalculation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegularCustomerTypeTest {

	static SortedSet<CustomerDiscount> regularCustomerDiscountConfigurations;

	static CustomerType regularCustomerType;

	@BeforeAll
	public static void regularCustomerTypeSetup() {
		regularCustomerDiscountConfigurations = new TreeSet<>();
		CustomerDiscount cus1 = new CustomerDiscount(0d, 5000d, 0);
		regularCustomerDiscountConfigurations.add(cus1);
		CustomerDiscount cus2 = new CustomerDiscount(5000d, 10000d, 10);
		regularCustomerDiscountConfigurations.add(cus2);
		CustomerDiscount cus3 = new CustomerDiscount(10000d, null, 20);
		regularCustomerDiscountConfigurations.add(cus3);
		regularCustomerType = new RegularCustomerType(regularCustomerDiscountConfigurations);
	}

	@Test
	public void testRegularCustomerTypeTest() {

		double amountAfterDiscount = regularCustomerType.calculateAvailableDiscount(5000);
		assertEquals(5000, amountAfterDiscount);

		double amountAfterDiscount1 = regularCustomerType.calculateAvailableDiscount(10000);
		assertEquals(9500, amountAfterDiscount1);

		double amountAfterDiscount2 = regularCustomerType.calculateAvailableDiscount(15000);
		assertEquals(13500, amountAfterDiscount2);

	}

}
