package de.mschneid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mschneid.entity.Data;
import de.mschneid.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@CrossOrigin
	@RequestMapping("/getCustomers")
	public Data getCustomers() {
		System.out.println("getCustomers is called");
		return this.customerService.getData();
		// return "Hello Docker World";
		// return getJson();
	}

}
