package models;

public class BookCatalog {

	private Book[] bookArray = new Book[100];
	private int nextPostion = 0;

	public Book[] getBookArray() {
		return bookArray;
	}

	public int getNumberOfBooks() {
		return nextPostion;
	}

	public void addBook(Book newBook) {
		bookArray[nextPostion] = newBook;
		nextPostion++;
	}

	public Book findBook(String title) throws BookNotFoundException {
		title = title.trim();

		for (int i = 0; i < nextPostion; i++) {
			if (bookArray[i].getTitle().equalsIgnoreCase(title)) {
				return bookArray[i];
			}
		}
		throw new BookNotFoundException();
	}
}
