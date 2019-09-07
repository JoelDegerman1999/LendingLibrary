package models;

import java.util.ArrayList;

import models.exceptions.LoanAlreadyExistsException;
import models.exceptions.LoanNotFoundException;
import utilities.LoanStatus;

public class LoanRegistry {
	private ArrayList<Loan> registry;
	private int nextPostion;

	public LoanRegistry() {
		registry = new ArrayList<Loan>();
		nextPostion = 0;
	}

	public void addLoan(Loan loan) throws LoanAlreadyExistsException {
		if (registry.contains(loan)) {
			throw new LoanAlreadyExistsException();
		}
		registry.add(loan);
	}

	public Loan findLoan(String bookID) throws LoanNotFoundException {

		for (Loan loan : registry) {
			if (loan.getBorrowedBook().getId().equals(bookID) && loan.getStatus() == LoanStatus.CURRENT) {
				return loan;
			}
		}

		throw new LoanNotFoundException();
	}

	public boolean isBookOnLoan(String bookID) {
		try {
			Loan foundLoan = findLoan(bookID);
			return true;
		} catch (LoanNotFoundException e) {
			return false;
		}
	}

}
