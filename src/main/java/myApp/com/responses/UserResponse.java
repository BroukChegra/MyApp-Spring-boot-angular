package myApp.com.responses;

import java.util.List;

public class UserResponse {
	
	private String userId;
	private String firstName;
	private String lasteName;
	private String email;
	private Boolean admin;
	private List<AddressResponse> addresses;
	private ContactResponse contact;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasteName() {
		return lasteName;
	}
	public void setLasteName(String lasteName) {
		this.lasteName = lasteName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<AddressResponse> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressResponse> addresses) {
		this.addresses = addresses;
	}
	public ContactResponse getContact() {
		return contact;
	}
	public void setContact(ContactResponse contact) {
		this.contact = contact;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	

}
