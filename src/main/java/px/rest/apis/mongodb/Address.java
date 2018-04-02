package px.rest.apis.mongodb;

import org.springframework.data.annotation.Id;

public class Address {

	@Id private String id;

	private String line1;
	private String line2;
	private String city;
	private String state;
	private String zipcode;

  // Line 1 get set
	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}
	// Line 2 get set
	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	// city get set
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	// state get set

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	// zipcode get set
	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
