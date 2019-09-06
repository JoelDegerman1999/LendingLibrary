package models;

import java.util.Date;
import java.util.GregorianCalendar;

import models.exceptions.LoanNotAvailableException;
import utilities.LoanStatus;

public class Loan {
	private int id;
	private Customer customer;
	private Book book;

	private Date startDate;
	private Date dueDate;
	private Date returnDate;

	private LoanStatus status;

	public Loan(int id, Customer borrower, Book borrowedBook) {
		this.id = id;
		this.customer = borrower;
		this.book = borrowedBook;

		startDate = new Date();

		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.DAY_OF_MONTH, 14);
		dueDate = gCal.getTime();

		status = LoanStatus.CURRENT;
	}
	
	public Loan(Magazine magazine) throws LoanNotAvailableException{
		throw new LoanNotAvailableException();
	}

	@Override
	public String toString() {
		return "Borrower: " + customer.getMailingName() + " | Book title: " + book.getTitle() + " | BookID: "
				+ book.getId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Customer getBorrower() {
		return customer;
	}

	public Book getBorrowedBook() {
		return book;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public LoanStatus getLoanStatus() {
		return status;
	}

	public void endLoan() {
		returnDate = new Date();
		status = status.HISTORIC;
	}

	public LoanStatus getStatus() {
		return status;
	}

}
