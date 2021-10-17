package com.thanhdinh.rest.controllers;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import com.thanhdinh.rest.entity.MyCustomer;
import com.thanhdinh.rest.entity.CustomerList;
@Controller
@RequestMapping("/admin")
public class ClientRest {

	private static final MediaType REST_REQUEST_TYPE = MediaType.APPLICATION_JSON;
	private static final String REST_URI_GET_CUSTOMER = "http://localhost:8014/rest/customer/{id}";
	private static final String REST_URI_GET_ALL_CUSTOMER = "http://localhost:8014/rest/customer/all";
	private static final String REST_URI_ADD_CUSTOMER = "http://localhost:8014/rest/customer/add";
	private static final String REST_URI_UPDATE_CUSTOMER = "http://localhost:8014/rest/customer/edit/{id}";
	private static final String REST_URI_DELETE_CUSTOMER = "http://localhost:8014/rest/customer/delete/{id}";
	private final RestTemplate restTemplate = new RestTemplate();
	
//	//getall
	@RequestMapping(value="/getall", method = RequestMethod.GET)
	public ModelAndView getAllCustomer() {
		HttpEntity<MyCustomer> entity = new HttpEntity<MyCustomer>(buildRequestHeader(REST_REQUEST_TYPE));
		ResponseEntity<List<MyCustomer>> result = this.restTemplate.exchange(REST_URI_GET_ALL_CUSTOMER, HttpMethod.GET, entity,new ParameterizedTypeReference<List<MyCustomer>>() {
		});
		ModelAndView mav = new ModelAndView("customerspage");
		mav.addObject("customers", result.getBody());
		return mav;
	}

	
	//getid
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getCustomer(@RequestParam("id") Long id) {
		HttpEntity<MyCustomer> entity = new HttpEntity<MyCustomer>(
				buildRequestHeader(REST_REQUEST_TYPE));
		ResponseEntity<MyCustomer> result = this.restTemplate.exchange(
				REST_URI_GET_CUSTOMER, HttpMethod.GET, entity, MyCustomer.class, id);
		ModelAndView mav = new ModelAndView("getpage");
		mav.addObject("customer", result.getBody());
		return mav;
	}
//add	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView getAddCustomer() {
		ModelAndView mav = new ModelAndView("addpage");
		mav.addObject("customerAttribute", new MyCustomer());
		return mav;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView getAddCustomer(
			@ModelAttribute("customerAttribute") MyCustomer customer) {

		HttpEntity<MyCustomer> entity = new HttpEntity<MyCustomer>(customer,
				buildRequestHeader(REST_REQUEST_TYPE));
		ResponseEntity<MyCustomer> result = this.restTemplate.exchange(REST_URI_ADD_CUSTOMER, HttpMethod.POST, entity, MyCustomer.class);
		ModelAndView mav = new ModelAndView("admin");
		result.getStatusCode();
		return mav;
	}
	//update
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public ModelAndView updateCustomer(
			@RequestParam(value = "id", required = true) Integer id) {
		HttpEntity<MyCustomer> entity = new HttpEntity<MyCustomer>(
				buildRequestHeader(REST_REQUEST_TYPE));
		ResponseEntity<MyCustomer> result = this.restTemplate.exchange(
				REST_URI_GET_CUSTOMER, HttpMethod.GET, entity, MyCustomer.class, id);
		ModelAndView mav = new ModelAndView("updatepage");
		mav.addObject("customerAttribute", result.getBody());
		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateCustomer(
			@ModelAttribute("customerAttribute") MyCustomer customer,
			@RequestParam(value = "id", required = true) Long id) {

		HttpEntity<MyCustomer> entity = new HttpEntity<MyCustomer>(customer,
				buildRequestHeader(REST_REQUEST_TYPE));
		ResponseEntity<String> result = this.restTemplate.exchange(
				REST_URI_UPDATE_CUSTOMER, HttpMethod.PUT, entity, String.class,
				id);
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("reuslt", result);
		return mav;
	}
	//delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(@RequestParam("id") Long id) {
		HttpEntity<String> entity = new HttpEntity<String>(
				buildRequestHeader(REST_REQUEST_TYPE));
		ResponseEntity<String> result = restTemplate.exchange(
				REST_URI_DELETE_CUSTOMER, HttpMethod.DELETE, entity,
				String.class, id);
		ModelAndView mav = new ModelAndView("admin");
		mav.addObject("result", result);
		return mav;
	}
	private HttpHeaders buildRequestHeader(MediaType mediaType) {
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(mediaType);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		return headers;
	}
}
