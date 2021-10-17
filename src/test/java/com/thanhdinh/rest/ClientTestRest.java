package com.thanhdinh.rest;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;
import com.thanhdinh.rest.entity.MyCustomer;

public class ClientTestRest {
	public static final String REST_URI = "http://localhost:8014/rest";

	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllCustomer() {
		System.out.println("ListAllCustomer API-----------");

		RestTemplate restTemplate = new RestTemplate();
		// khoi tao linkedhashmap,de lu tru doi tuong duoi dang key va value
		List<LinkedHashMap<String, Object>> customerMap = restTemplate.getForObject(REST_URI + "/customer/all",
				List.class);

		if (customerMap != null) {
			for (LinkedHashMap<String, Object> map : customerMap) {
				System.out.println("Customer : id=" + map.get("id") + ", Name=" + map.get("name") + ", Gender="
						+ map.get("gender") + ", Age=" + map.get("age") + ", City=" + map.get("city") + ", Email="
						+ map.get("email") + ", Phone=" + map.get("phone") + ",Code=" + map.get("code"));
				;
			}
		} else {
			System.out.println("No customer exist----------");
		}
	}

	/* GET */
	private static void getCustomer() {
		System.out.println("GetCustomer API----------");
		RestTemplate restTemplate = new RestTemplate();
		MyCustomer customer = restTemplate.getForObject(REST_URI + "/customer/2", MyCustomer.class);
		System.out.println(customer);
	}

//     
//	/* POST */
//	private static void createCustomer() {
//		System.out.println("Create Customer API----------");
//		RestTemplate restTemplate = new RestTemplate();
//		MyCustomer customer = new MyCustomer(8, "tdin145", "female", 14, "bdinh", "ddd@fff", 1515, 123);
//		URI uri = restTemplate.postForLocation(REST_URI + "/customer/add", customer, MyCustomer.class);
//		System.out.println("Location : " + uri.toASCIIString());
//	}

	/* PUT */
	private static void updateCustomer() {
		System.out.println("Update Customer API----------");
		RestTemplate restTemplate = new RestTemplate();
		MyCustomer customer = new MyCustomer(3, "tdinh", "male", 15, "bdinh", "ddd@fff", 1515, 123);
		restTemplate.put(REST_URI + "/customer/edit/3", customer);
		System.out.println(customer);
	}

	/* DELETE */
	private static void deleteCustomer() {
		System.out.println("Delete Customer API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_URI + "/customer/delete/4");
	}

	/* DELETE */
	private static void deleteAllCustomers() {
		System.out.println("Delete all Custmer API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_URI + "/customer/delete");
	}

	public static void main(String args[]) {
		listAllCustomer();
		getCustomer();
		//createCustomer();
		listAllCustomer();
		updateCustomer();
		listAllCustomer();
		deleteCustomer();
		listAllCustomer();
		deleteAllCustomers();
		listAllCustomer();
	}

}
