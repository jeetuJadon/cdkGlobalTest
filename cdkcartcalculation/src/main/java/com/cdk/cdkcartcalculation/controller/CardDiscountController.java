package com.cdk.cdkcartcalculation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdk.cdkcartcalculation.model.CartItems;
import com.cdk.cdkcartcalculation.model.RequestDto;
import com.cdk.cdkcartcalculation.model.ResponseItem;
import com.cdk.cdkcartcalculation.service.CustomerTypeDiscountService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CardDiscountController {

	@Autowired
	CustomerTypeDiscountService customerTypeDiscountService;

	@PostMapping(path = "/calculateDiscount")
	public ResponseEntity<String> getDiscountedAmount(@RequestBody RequestDto requestDto)
			throws JsonProcessingException {
		System.out.println("Inside  getDiscountedAmount" + requestDto.toString());
		Double discountedAmount = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("content-type", "application/json");
		String errorMessage = "";
		try {
			discountedAmount = customerTypeDiscountService.calculateDiscountedPrice(requestDto.getCustomerType(),
					requestDto.getTotalAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (discountedAmount == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().headers(responseHeaders).body(discountedAmount.toString());
		}
	}

	@PostMapping(path = "/cartItems")
	public ResponseEntity<String> getDiscountedAmountFromItems(@RequestBody CartItems cartItems)
			throws JsonProcessingException {
		System.out.println("Inside  getDiscountedAmount" + cartItems.toString());
		ResponseItem responseItem = null;
		String errorMessage = "";
		double totalAmount = cartItems.getCartItems().stream().mapToDouble(e -> e.getAmount()).sum();
		System.out.println("Inside  totalAmount =>" + totalAmount);
		try {
			Double discountedAmount = customerTypeDiscountService.calculateDiscountedPrice(cartItems.getCustomerType(),
					totalAmount);
			responseItem = new ResponseItem(totalAmount, discountedAmount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			errorMessage = e.toString();
		}
		if (responseItem == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} else {
			return ResponseEntity.ok().body(responseItem.toString());
		}
	}

}
