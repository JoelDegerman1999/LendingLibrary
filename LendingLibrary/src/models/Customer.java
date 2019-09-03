package models;

import java.util.Date;
import java.util.GregorianCalendar;

import utilities.GenderType;

public class Customer {
	private String title;
	private String firstName;
	private String surname;
	private String adress;
	private String phoneNumber;
	private String email;
	private int customerNumber;
	private GenderType gender;
	private boolean isValid;
	private Date expiryDate;

	public Customer(String title, String firstName, String surName, String adress, String phoneNumber, String email,
			int customerNumber, GenderType gender) {
		setName(title, firstName, surName);
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.customerNumber = customerNumber;
		this.gender = gender;
		this.isValid = true;

		GregorianCalendar gCal = new GregorianCalendar();
		gCal.add(GregorianCalendar.YEAR, 1);
		this.expiryDate = gCal.getTime();
		
	}

	public String getTitle() {
		return title;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurName() {
		return surname;
	}

	private void setName(String title, String firstName, String surName) {
		this.title = title;
		this.firstName = firstName;
		this.surname = surName;
	}

	public String getMailingName() {
		return title + " " + firstName.substring(0, 1) + " " + surname;
	}
	
	public Date getExpiryDate() {
		return expiryDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + customerNumber;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + (isValid ? 1231 : 1237);
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Customer other = (Customer) obj;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (customerNumber != other.customerNumber)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (isValid != other.isValid)
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	

}
