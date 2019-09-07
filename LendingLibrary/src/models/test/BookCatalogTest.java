package models.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import models.Book;
import models.BookCatalog;
import models.exceptions.BookNotFoundException;

public class BookCatalogTest {

	private BookCatalog bc;
	private Book book1;

	public BookCatalogTest() {
		bc = new BookCatalog();
		book1 = new Book("1", "Learning Java", "", "", "", 0);
		bc.addBook(book1);
	}

	@Test
	public void testAddBook() {

		int initalNumber = bc.getNumberOfBooks();

		
		Book book = new Book("2", "", "", "", "", 0);
		bc.addBook(book);

		assertTrue(initalNumber == bc.getNumberOfBooks() - 1);

	}

	@Test
	public void testFindBook() {
		try {
			Book foundBook = bc.findBook("Learning Java");
		} catch (BookNotFoundException e) {
			fail("Book not found");
		}
	}

	@Test
	public void testFindBookIgnoringCase() {
		try {
			Book foundBook = bc.findBook("learning Java");
		} catch (BookNotFoundException e) {
			fail("Book not found");
		}
	}

	@Test
	public void testFindBookWithExtraSpaces() {
		try {
			Book foundBook = bc.findBook(" learning Java ");
		} catch (BookNotFoundException e) {
			fail("Book not found");
		}
	}

	@Test(expected = BookNotFoundException.class)
	public void testFindBookThatDoesntExist() throws BookNotFoundException {
		Book foundBook = bc.findBook("Learning More Java");
	}

}
