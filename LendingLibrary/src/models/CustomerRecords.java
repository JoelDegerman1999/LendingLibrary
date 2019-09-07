package models;

import java.util.HashSet;

import models.exceptions.CustomerNotFoundException;

public class CustomerRecords {

	HashSet<Customer> records;

	public CustomerRecords() {
		records = new HashSet<Customer>();
	}
	
	public void add(Customer customer) {
		records.add(customer);
	}
	
	public Customer findByName(String name) throws CustomerNotFoundException{
		for(Customer customer : records) {
			if(customer.getMailingName().equalsIgnoreCase(name)) {
				return customer;
			}
		}
		throw new CustomerNotFoundException();
	}
	
	public int getNumberOfCustomer() {
		return records.size();
	}
	
	
}
