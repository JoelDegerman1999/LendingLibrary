package ui;

import models.Book;
import models.Customer;
import models.CustomerRecords;
import models.DVD;
import models.Loan;
import models.LoanRegistry;
import models.Material;
import models.MaterialCatalogDB;
import models.MaterialCatalogInterface;
import models.exceptions.CustomerNotFoundException;
import models.exceptions.LoanAlreadyExistsException;
import models.exceptions.MaterialNotFoundException;
import utilities.GenderType;

public class Main {

	public static void main(String[] args) {
		MaterialCatalogInterface materialCatalog = new MaterialCatalogDB();

		Book book1 = new Book("1001", "An introduction to Java", "Matt Greencroft", "Anytown Branch", "12345", 400);
		Book book2 = new Book("223X", "Better Java", "Joe Degerman", "Anytown Branch", "23456", 150);
		Book book3 = new Book("9120", "Learning French", "Joe Le Blanc", "Anytown Branch", "232231", 300);
		Book book4 = new Book("444X", "Learning more French", "Joe Le Blanc", "Anytown Branch", "232231", 200);
		Book book5 = new Book("3345", "Enough French", "Joe Le Blanc", "Anytown Branch", "232231", 120);
		
		DVD dvd1 = new DVD("4500030","Jurassic Park", "Anytown Branch", "Steven Speilberg", "512", 120);


//		book1.relocate("MyCity Branch");

//		materialCatalog.addMaterial(book1);
//		materialCatalog.addMaterial(book2);
//		materialCatalog.addMaterial(book3);
//		materialCatalog.addMaterial(book4);
//		materialCatalog.addMaterial(book5);
		materialCatalog.addMaterial(dvd1);
//		materialCatalog.addMaterial(dvd3);
		
		System.out.println("There are " + materialCatalog.getNumberOfMaterials() + " items in the libary");
		try {
			Material foundMaterial = materialCatalog.findMaterial("Java");
			System.out.println(foundMaterial);
		} catch (MaterialNotFoundException e) {
			System.out.println("No matching items found");
		}

		UI ui = new UI();
		ui.printHeader();

		ui.printMaterialCatalog(materialCatalog.getMaterialMap());

//		Customer customer1 = new Customer("Mr", "Joel", "Degerman", "Kungsvägen 43A", "0703899686",
//				"joel.degerman1999@gmail.com", 1, GenderType.MALE);
//
//		LoanRegistry registry = new LoanRegistry();
//
//		Loan firstLoan = new Loan(1, customer1, book1);
//
//		try {
//			registry.addLoan(firstLoan);
//		} catch (LoanAlreadyExistsException e) {
//			System.out.println("Loan already exists");
//		}
//		
//		CustomerRecords customerRecords = new CustomerRecords();
//		
//		customerRecords.add(customer1);
//		
//		try {
//			Customer foundCustomer = customerRecords.findByMailingName("Mr J Degerman");
//			System.out.println("Found: " + foundCustomer.getMailingName());
//		} catch (CustomerNotFoundException e) {
//			System.out.println("Customer not found");
//		}

	}
}
