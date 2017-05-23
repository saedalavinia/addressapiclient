package me.alavinia.saed.pojos;

import java.text.SimpleDateFormat;
import java.util.Date;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {


	private long id;
	
	
	private int streetNumber;
	private String streetAddress;
	private String city; 
	private String province; 
	private String postalCode;
	private String country;
	
	private Person person;
	
    private Date dateFrom = new Date();
    
    private Date dateTo = new Date();
	
	
	public Address(){}
	


	public Address(long id, int streetNumber, String streetAddress, String city, String province, String postalCode,
			String country, Person person, Date dateFrom, Date dateTo) {
		super();
		this.id = id;
		this.streetNumber = streetNumber;
		this.streetAddress = streetAddress;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.person = person;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}


	@Override
	public String toString() {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateToFormatted = format.format(dateTo.getTime());
		String dateFromFormatted = format.format(dateTo.getTime());

		
		return "For: " + this.person.toString() + "\nAddress: " + streetNumber + " " + streetAddress + " "
				+ city + " " + province + ", " + postalCode + " " + country + " From=" + dateFromFormatted + ", To=" + dateToFormatted;
	}
	
	
	
}
