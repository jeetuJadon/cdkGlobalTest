package com.cdk.cdkcartcalculation.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.SortedSet;
import java.util.TreeSet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PremiumCustomerTypeTest {

	static SortedSet<CustomerDiscount> premiumCustomerDiscountConfigurations;

	static CustomerType premiumCustomerType;

	@BeforeAll
	public static void regularCustomerTypeSetup() {
		premiumCustomerDiscountConfigurations = new TreeSet<>();
		CustomerDiscount cus1 = new CustomerDiscount(0d, 4000d, 10);
		premiumCustomerDiscountConfigurations.add(cus1);
		CustomerDiscount cus2 = new CustomerDiscount(4000d, 8000d, 15);
		premiumCustomerDiscountConfigurations.add(cus2);
		CustomerDiscount cus3 = new CustomerDiscount(8000d, 12000d, 20);
		premiumCustomerDiscountConfigurations.add(cus3);
		CustomerDiscount cus4 = new CustomerDiscount(12000d, null, 30);
		premiumCustomerDiscountConfigurations.add(cus4);
		premiumCustomerType = new PremiumCustomerType(premiumCustomerDiscountConfigurations);
	}

	@Test
	public void testRegularCustomerTypeTest() {

		double amountAfterDiscount = premiumCustomerType.calculateAvailableDiscount(4000);
		assertEquals(3600, amountAfterDiscount);

		double amountAfterDiscount1 = premiumCustomerType.calculateAvailableDiscount(8000);
		assertEquals(7000, amountAfterDiscount1);

		double amountAfterDiscount2 = premiumCustomerType.calculateAvailableDiscount(12000);
		assertEquals(10200, amountAfterDiscount2);

		double amountAfterDiscount3 = premiumCustomerType.calculateAvailableDiscount(20000);
		assertEquals(15800, amountAfterDiscount3);

	}

}
