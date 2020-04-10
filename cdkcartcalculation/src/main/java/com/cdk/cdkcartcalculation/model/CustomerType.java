package com.cdk.cdkcartcalculation.model;

import java.util.SortedSet;

public abstract class CustomerType {

SortedSet<CustomerDiscount> custDiscountConfiguration;

public abstract double calculateAvailableDiscount(double amount);



}
