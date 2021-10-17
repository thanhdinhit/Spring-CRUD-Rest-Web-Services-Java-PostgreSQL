package com.thanhdinh.rest.service;

import java.util.List;

import com.thanhdinh.rest.entity.MyCustomer;

public interface CustomerService {

	MyCustomer findById(long id);

	MyCustomer findByName(String name);

	void saveCustomer(MyCustomer Customer);

	void updateCustomer(MyCustomer Customer);

	void deleteCustomerById(long id);

	List<MyCustomer> findAllCustomers();

	void deleteAllCustomers();

	boolean isCustomerExist(MyCustomer Customer);
}
