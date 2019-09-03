package models;

import utilities.LoanStatus;

public class LoanRegistry {
	private Loan[] registry;
	private int nextPostion;

	public LoanRegistry() {
		registry = new Loan[100];
		nextPostion = 0;
	}

	public void addLoan(Loan loan) throws LoanAlreadyExistsException {
		for (int i = 0; i < nextPostion; i++) {
			if (registry[i].equals(loan)) {
				throw new LoanAlreadyExistsException();
			}
		}

		registry[nextPostion] = loan;
		nextPostion++;

	}

	public Loan findLoan(int bookID) throws LoanNotFoundException {
		for (int i = 0; i < nextPostion; i++) {
			if (registry[i].getBorrowedBook().getId() == bookID && registry[i].getStatus() == LoanStatus.CURRENT) {
				return registry[i];
			}
		}

		throw new LoanNotFoundException();
	}

	public boolean isBookOnLoan(int bookID) {
		try {
			Loan foundLoan = findLoan(bookID);
			return true;
		} catch (LoanNotFoundException e) {
			return false;
		}
	}

}
