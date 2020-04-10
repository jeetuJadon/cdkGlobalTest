package com.cdk.cdkcartcalculation.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cdk.cdkcartcalculation.exceptions.CustomerTypeException;
import com.cdk.cdkcartcalculation.repository.CustomerTypeDiscountRepository;

@Component
public class CustomerTypeFactory {

	Map<String, CustomerType> customerTypes = new ConcurrentHashMap<String, CustomerType>();

	@Autowired
	CustomerTypeDiscountRepository custTypDiscountrepo;

	public CustomerType getCustomerType(String customerType) throws CustomerTypeException {
    System.out.println("Inside getCustomerType "+customerType);
		CustomerType custType = null;

		if (customerTypes.containsKey(customerType)) {
			System.out.println("if ");
			custType = customerTypes.get(customerType);

		} else {
			System.out.println("else ");
			if (customerType.equals("regular")) {
				System.out.println("regular ");
				custType = new RegularCustomerType(
						custTypDiscountrepo.getDiscountMappingFromCustomerType(customerType));
				customerTypes.put(customerType, custType);
			} else if (customerType.equals("premium")) {
				System.out.println("premium ");
				custType = new PremiumCustomerType(
						custTypDiscountrepo.getDiscountMappingFromCustomerType(customerType));
				customerTypes.put(customerType, custType);
			}
			else{
				
				throw new CustomerTypeException("This customer Type doesn not exist " +customerType);
			}
		}
		return custType;
	}

}