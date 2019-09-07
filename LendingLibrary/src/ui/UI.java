package ui;

import java.util.LinkedHashMap;
import java.util.TreeMap;

import models.Book;

public class UI {

	public void printHeader() {
		System.out.println("BookID  Title                 Author");
	}

	public void printBook(Book book) {
		System.out.println(fixLengthString(book.getId(), 6) + "  " + fixLengthString(book.getTitle(), 20) + "  "
				+ fixLengthString(book.getAuthor(), 20));
	}

	private String fixLengthString(String start, int length) {
		// TODO: fix string padding problems
		if (start.length() >= length) {
			return start.substring(0, length);
		} else {
			for (int i = start.length(); i < length; i++) {
				start += " ";
			}
			return start;
		}
	}

	private String fixLengthString(int start, int length) {
		String startString = String.valueOf(start);
		return fixLengthString(startString, length);
	}

	public void printBookCatalog(TreeMap<String, Book> bookCatalog) {
		for(Book nextBook : bookCatalog.values()) {
			printBook(nextBook);
		}
		
	}

}
