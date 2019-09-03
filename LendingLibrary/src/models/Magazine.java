package models;

public class Magazine extends Material {

	private int noPages;
	private String publisher;

	public Magazine(int id, String title, String branch, int noPages, String publisher) {
		super(id, title, branch);
		this.noPages = noPages;
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
