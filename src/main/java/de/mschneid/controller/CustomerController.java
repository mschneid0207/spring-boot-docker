package de.mschneid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.mschneid.entity.CustomerEntity;
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
	
	@CrossOrigin
	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	public void createCustomer( @RequestBody CustomerEntity customer) {
		if (customer != null) {
			System.out.println(customer.toString());
		}
		System.out.println("createCustomer is called: " + customer.getFirstName());
		//request.
		customerService.createCustomer(customer);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/user/delete/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable("id") long id) {
		System.out.println("deleteCustomer was called: " + id);
		customerService.deleteCustomer(id);
	}

}
