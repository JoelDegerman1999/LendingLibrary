package models;

import utilities.LoanStatus;

public class Magazine extends Material {

	private int noPages;
	private String publisher;
	private LoanStatus status;

	public Magazine(String id, String title, String branch, int noPages, String publisher) {
		super(id, title, branch);
		this.noPages = noPages;
		status = LoanStatus.CANT_LEND;
		this.publisher = publisher;
	}

	public int getNoPages() {
		return noPages;
	}

	public String getPublisher() {
		return publisher;
	}

	@Override
	public int getLoanPeriod() {
		return 0;
	}

}
