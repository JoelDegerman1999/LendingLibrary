package ui;

import models.Book;
import models.BookCatalog;
import models.Customer;
import models.CustomerRecords;
import models.Loan;
import models.LoanRegistry;
import models.exceptions.CustomerNotFoundException;
import models.exceptions.LoanAlreadyExistsException;
import utilities.GenderType;

public class Main {

	public static void main(String[] args) {
		BookCatalog bookCatalog = new BookCatalog();

		Book book1 = new Book("1001", "An introduction to Java", "Matt Greencroft", "Anytown Branch", "12345", 400);
		Book book2 = new Book("223X", "Better Java", "Joe Degerman", "Anytown Branch", "23456", 150);
		Book book3 = new Book("9120", "Learning French", "Joe Le Blanc", "Anytown Branch", "232231", 300);
		Book book4 = new Book("444X", "Learning more French", "Joe Le Blanc", "Anytown Branch", "232231", 200);
		Book book5 = new Book("3345", "Enough French", "Joe Le Blanc", "Anytown Branch", "232231", 120);

		book1.relocate("MyCity Branch");

		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);
		bookCatalog.addBook(book3);
		bookCatalog.addBook(book4);
		bookCatalog.addBook(book5);

		UI ui = new UI();
		ui.printHeader();

		ui.printBookCatalog(bookCatalog.getBookMap());

		Customer customer1 = new Customer("Mr", "Joel", "Degerman", "Kungsvägen 43A", "0703899686",
				"joel.degerman1999@gmail.com", 1, GenderType.MALE);

		LoanRegistry registry = new LoanRegistry();

		Loan firstLoan = new Loan(1, customer1, book1);

		try {
			registry.addLoan(firstLoan);
		} catch (LoanAlreadyExistsException e) {
			System.out.println("Loan already exists");
		}
		
		CustomerRecords customerRecords = new CustomerRecords();
		
		customerRecords.add(customer1);
		
		try {
			Customer foundCustomer = customerRecords.findByName("Jol");
			System.out.println("Found: " + foundCustomer.getMailingName());
		} catch (CustomerNotFoundException e) {
			System.out.println("Customer not found");
		}

	}
}
