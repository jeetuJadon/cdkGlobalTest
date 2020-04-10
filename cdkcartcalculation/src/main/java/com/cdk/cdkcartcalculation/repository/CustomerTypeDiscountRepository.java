package com.cdk.cdkcartcalculation.repository;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cdk.cdkcartcalculation.model.CustomerDiscount;


@Repository
public class CustomerTypeDiscountRepository {

	private static Map<String, SortedSet<CustomerDiscount>> customerTypeDiscoutMappings = new ConcurrentHashMap<>();

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void populateStockPrices() {
		getCustomerTypeDiscountMapping();
		System.out.println(customerTypeDiscoutMappings.toString());
	}

//Default method for configuration
	private void getCustomerTypeDiscountMapping()  {
		String sql = "select * from CUSTOMER_TYPE_DISCOUNT";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map row : rows) {
			String customerType = (String) row.get("CUS_TYPE");
			Double minValue = (Double) row.get("MIN_VALUE");
			Double maxValue = (Double)  (row.get("MAX_VALUE") ==null?null:row.get("MAX_VALUE"));
			Integer discount = (Integer) row.get("DISCOUNT_PRC");
            
			
			if (customerTypeDiscoutMappings.containsKey(customerType)) {
				SortedSet<CustomerDiscount> custDiscountsMappings = customerTypeDiscoutMappings.get(customerType);
				custDiscountsMappings.add(new CustomerDiscount(minValue, maxValue, discount));
			} else {
				SortedSet<CustomerDiscount> custDiscountsMappings = new TreeSet<>();
				CustomerDiscount cusDisc = new CustomerDiscount(minValue, maxValue, discount);
				custDiscountsMappings.add(cusDisc);
				customerTypeDiscoutMappings.put(customerType, custDiscountsMappings);
			}

		}
	}

	// DiscountMapping testing from customerType
	public SortedSet<CustomerDiscount> getDiscountMappingFromCustomerType(String cusType) {
		System.out.println("getDiscountMappingFromCustomerType ");
		return customerTypeDiscoutMappings.get(cusType);
	}

}
