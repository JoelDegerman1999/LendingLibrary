package models.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import models.Customer;
import models.CustomerRecords;
import models.exceptions.CustomerNotFoundException;
import utilities.GenderType;

public class CustomerRecordsTest {

	CustomerRecords records;

	@Test
	public void testAddCustomer() {

		Customer newCustomer = new Customer("Mr", "Joel", "Degerman", "Barksjövägen 49", "0703899686", "dawdadwaw@hmai",
				1, GenderType.MALE);

		int intialSize = records.getNumberOfCustomer();

		records.add(newCustomer);

		assertTrue(intialSize == records.getNumberOfCustomer() - 1);
	}

	@Test
	public void testFindCustomer() {
		try {
			Customer foundCustomer = records.findByName("Mrs M Smith");
		} catch (CustomerNotFoundException e) {
			fail("Customer not found");
		}

	}

	@Test
	public void testNoDuplicate() {
		Customer newCustomer = new Customer("Mrs", "Maria", "Smith", "Kungsvägen 49", "0709899686", "dawdadwaw@hmai", 2,
				GenderType.FEMALE);
		records.add(newCustomer);
		records.add(newCustomer);
		records.add(newCustomer);
		records.add(newCustomer);
		records.add(newCustomer);
		records.add(newCustomer);
		records.add(newCustomer);
		
		assertEquals(1, records.getNumberOfCustomer());
	}

	public CustomerRecordsTest() {
		records = new CustomerRecords();
		Customer newCustomer = new Customer("Mrs", "Maria", "Smith", "Kungsvägen 49", "0709899686", "dawdadwaw@hmai", 2,
				GenderType.FEMALE);
		records.add(newCustomer);
	}

}
