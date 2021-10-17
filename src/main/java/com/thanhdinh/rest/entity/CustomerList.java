package com.thanhdinh.rest.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="customers")
public class CustomerList {
	private List<MyCustomer> customer;
	@XmlElement(required = false)
	public List<MyCustomer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<MyCustomer> data) {
		this.customer = data;
	}
	
	

}
