package de.mschneid.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.mschneid.entity.CustomerEntity;
import de.mschneid.entity.Data;
import de.mschneid.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public List<CustomerEntity> getCustomers() {
		//return customerRepository.findAll();
		return toList(customerRepository.findAll());
		//return IteratorUtils.toList(customerRepository.findAll());
		
//		List<CustomerEntity> customers = new ArrayList<CustomerEntity>();
//		CustomerEntity customer = new CustomerEntity(1L, "Markus");
//		customers.add(customer);
//		customer = new CustomerEntity(2L, "Lukas");
//		customers.add(customer);
//		customer = new CustomerEntity(3L, "Nadine");
//		customers.add(customer);
//		return customers;
	}
	
	public Data getData() {
		Data data = new Data();
		data.setCustomer(getCustomers());
		return data;
	}
	
	public static <T> List<T> toList(final Iterable<T> iterable) {
	    return StreamSupport.stream(iterable.spliterator(), false)
	                        .collect(Collectors.toList());
	}

}
