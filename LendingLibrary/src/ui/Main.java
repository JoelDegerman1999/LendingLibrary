package ui;

import java.util.Date;
import java.util.GregorianCalendar;

import models.Book;
import models.BookCatalog;
import models.BookNotFoundException;
import models.Customer;
import models.DVD;
import models.Loan;
import models.LoanAlreadyExistsException;
import models.LoanNotAvailableException;
import models.LoanRegistry;
import models.Magazine;
import utilities.GenderType;

public class Main {

	public static void main(String[] args) {
		BookCatalog bookCatalog = new BookCatalog();

		Book book1 = new Book(1, "An introduction to Java", "Matt Greencroft", "Anytown Branch", "12345", 400);
		Book book2 = new Book(2, "Better Java", "Joe Le Blanc", "Anytown Branch", "23456", 150);
		DVD dvd1 = new DVD(3, "An epic film about Java", "Anytown Branch", "Steven Speilberg", "99887", 120);

		book1.relocate("MyCity Branch");
		System.out.println(dvd1.getTitle());

		bookCatalog.addBook(book1);
		bookCatalog.addBook(book2);

		UI ui = new UI();
		ui.printHeader();

		ui.printBookCatalog(bookCatalog.getBookArray());

		try {
			Book foundBook = bookCatalog.findBook("Better Jav");
			System.out.println("We found " + foundBook.getTitle());
		} catch (BookNotFoundException e) {
			System.out.println("The book wasn't found");
		}

		Customer customer1 = new Customer("Mr", "Joel", "Degerman", "Kungsvägen 43A", "0703899686",
				"joel.degerman1999@gmail.com", 1, GenderType.MALE);


		LoanRegistry registry = new LoanRegistry();


		
		
		
		


	}
}
