package models;

public class DVD extends Material {
	private String director;
	private String catalogNo;
	private int runningTime;
	private boolean isLicensed;

	public DVD(String id, String title, String branch, String director, String catalogNo, int runningTime) {
		super(id, title, branch);
		this.director = director;
		this.catalogNo = catalogNo;
		this.runningTime = runningTime;
		this.isLicensed = false;
	}

	public void license() {
		isLicensed = true;
	}

	public boolean lend(Customer customer) {
		if (isLicensed) {
			return super.lend(customer);
		} else {
			return false;
		}
	}

	public int getLoanPeriod() {
		return 7;
	}
	
	public int getRunningTime() {
		return runningTime;
	}
	
	public boolean getLicenced() {
		return isLicensed;
	}
	
	public String getCatalogNumber() {
		return catalogNo;
	}
	
	public String getDirector() {
		return director;
	}

	@Override
	public String toString() {
		return "DVD: " + getId() + " " + getTitle() + " / " + getDirector();
	}
}
