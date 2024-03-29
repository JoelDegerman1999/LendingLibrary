package ui;

import java.util.Map;

import models.Book;
import models.Material;

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

	public void printMaterialCatalog(Map<String, Material> materialCatalog) {
		for (Material nextMaterial : materialCatalog.values()) {
			System.out.println(nextMaterial);
		}

	}

}
