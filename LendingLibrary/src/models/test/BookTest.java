package models.test;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Book;

public class BookTest {

	@Test
	public void test2BookEquals() {
		Book book1 = new Book("10", "", "", "", "", 1);
		Book book2 = new Book("10", "", "", "", "", 1);
		
		assertTrue(book1.equals(book2));
	}
	
	@Test
	public void testBookNonEqual() {
		Book book1 = new Book("100", "", "", "", "", 1);
		Book book2 = new Book("101", "", "", "", "", 1);
		
		assertFalse(book1.equals(book2));
	}

}
