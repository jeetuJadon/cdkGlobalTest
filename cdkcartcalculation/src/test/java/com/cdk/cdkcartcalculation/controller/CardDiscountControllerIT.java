package com.cdk.cdkcartcalculation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cdk.cdkcartcalculation.CdkcartcalculationApplication;
import com.cdk.cdkcartcalculation.model.CartItems;
import com.cdk.cdkcartcalculation.model.Item;
import com.cdk.cdkcartcalculation.model.RequestDto;


@SpringBootTest(classes = CdkcartcalculationApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class CardDiscountControllerIT {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testPremiumCardDiscountControllerIt() {
		RequestDto requetDto = new RequestDto();
		requetDto.setCustomerType("premium");
		requetDto.setTotalAmount(4000);
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/calculateDiscount", requetDto, String.class);
		assertEquals(3600.0, Double.parseDouble(responseEntity.getBody()));
	}

	@Test
	public void testPremiumCardDiscountControllerIt1() {
		RequestDto requetDto = new RequestDto();
		requetDto.setCustomerType("premium");
		requetDto.setTotalAmount(8000);
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/calculateDiscount", requetDto, String.class);
		assertEquals(7000.00, Double.parseDouble(responseEntity.getBody()));
	}

	@Test
	public void testRegularCardDiscountControllerIt() {
		RequestDto requetDto = new RequestDto();
		requetDto.setCustomerType("regular");
		requetDto.setTotalAmount(10000);
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/calculateDiscount", requetDto, String.class);
		assertEquals(9500.0, Double.parseDouble(responseEntity.getBody()));
	}

	@Test
	public void testRegularCardDiscountControllerIt1() {
		RequestDto requetDto = new RequestDto();
		requetDto.setCustomerType("regular");
		requetDto.setTotalAmount(15000);
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/calculateDiscount", requetDto, String.class);
		assertEquals(13500.0, Double.parseDouble(responseEntity.getBody()));
	}

	@Test
	public void testCartItemsControllerIt() {
		CartItems cartItems = new CartItems();
		List<Item> lstItem = new ArrayList<>();
		Item item = new Item("hair oil", 1000d);
		lstItem.add(item);
		Item item1 = new Item("shirt", 3500d);
		lstItem.add(item1);
		Item item2 = new Item("t-shirt", 4500d);
		lstItem.add(item2);
		cartItems.setCustomerType("regular");
		cartItems.setCartItems(lstItem);
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/cartItems", cartItems, String.class);
		assertEquals("[ totalAmount :9000.0 , amountAfterDiscount :8600.0 ]", responseEntity.getBody());
	}

	@Test
	public void testCartItemsControllerIt1() {
		CartItems cartItems = new CartItems();
		List<Item> lstItem = new ArrayList<>();
		Item item = new Item("hair oil", 1000d);
		lstItem.add(item);
		Item item1 = new Item("shirt", 3500d);
		lstItem.add(item1);
		Item item2 = new Item("t-shirt", 4500d);
		lstItem.add(item2);
		cartItems.setCustomerType("premium");
		cartItems.setCartItems(lstItem);
		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/cartItems", cartItems, String.class);
		assertEquals("[ totalAmount :9000.0 , amountAfterDiscount :7800.0 ]", responseEntity.getBody());
	}

}