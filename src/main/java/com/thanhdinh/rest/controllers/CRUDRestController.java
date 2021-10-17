package com.thanhdinh.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thanhdinh.rest.entity.MyCustomer;
import com.thanhdinh.rest.service.CustomerService;

@RestController // include: @Controller and @ResponseBody annotations
@RequestMapping(value = "/")
public class CRUDRestController {
	@Autowired
	private CustomerService customerService;

	// setter for customerService
//	public void setCustomerService(CustomerService customerService) {
//		this.customerService = customerService;
//	}
	// Add Customer
	@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
	public ResponseEntity<Void> addCustomer(@RequestBody MyCustomer customer, UriComponentsBuilder ucb) {
		System.out.println("Creating new customer:" + customer.getId());
		if (customerService.isCustomerExist(customer)) {
			System.out.println("A customer with Id " + customer.getId() + " already exist, please create again");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		} else {
			customerService.saveCustomer(customer);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucb.path("/customer/{id}").buildAndExpand(customer.getId()).toUri());
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
	}

	// Get Single Customer
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MyCustomer> getCustomer(@PathVariable("id") int id) {
		System.out.println("Find and loaded data customer with id:" + id);
		MyCustomer customer = customerService.findById(id);
		if (customer != null) {
			System.out.println("Customer with id:" + id + "");
			return new ResponseEntity<MyCustomer>(customer, HttpStatus.OK);
		}
		System.out.println("Sorry, Customer with id " + id + " not found");
		return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
	}

	// Get All Customers
	@RequestMapping(value = "/customer/all", method = RequestMethod.GET)
	public ResponseEntity<List<MyCustomer>> listAllCustomers() {
		List<MyCustomer> customers = customerService.findAllCustomers();
		if (customers.isEmpty()) {
			return new ResponseEntity<List<MyCustomer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<MyCustomer>>(customers, HttpStatus.OK);
	}


	// Update Customer
	@RequestMapping(value = "/customer/edit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<MyCustomer> updateCustomer(@PathVariable("id") int id, @RequestBody MyCustomer cus) {
		System.out.println("Update customer with id " + id);
		MyCustomer customer = customerService.findById(id);
		if (customer != null) {
			customer.setId(cus.getId());
			customer.setName(cus.getName());
			customer.setGender(cus.getGender());
			customer.setAge(cus.getAge());
			customer.setCity(cus.getCity());
			customer.setEmail(cus.getEmail());
			customer.setPhone(cus.getPhone());
			customer.setCode(cus.getCode());
			customerService.updateCustomer(customer);
			return new ResponseEntity<MyCustomer>(customer, HttpStatus.OK);
		}
		System.out.println("Sorry, Customer with id " + id + " not found");
		return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);
	}

	// Delete Customer
	@RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<MyCustomer> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Find and Delete customer with id " + id);
		MyCustomer customer = customerService.findById(id);
		if (customer != null) {
			customerService.deleteCustomerById(id);
			return new ResponseEntity<MyCustomer>(HttpStatus.NO_CONTENT);
		}
		System.out.println("Unable to delete customer with id:" + id);
		return new ResponseEntity<MyCustomer>(HttpStatus.NOT_FOUND);

	}

	// Delete All Customers
	@RequestMapping(value = "/customer/delete", method = RequestMethod.DELETE)
	public ResponseEntity<MyCustomer> deleteAllCustomers() {
		System.out.println("Delete All Customers");
		customerService.deleteAllCustomers();
		return new ResponseEntity<MyCustomer>(HttpStatus.NO_CONTENT);
	}
}
