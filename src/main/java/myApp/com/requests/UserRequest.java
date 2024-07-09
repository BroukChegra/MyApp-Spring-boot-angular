package myApp.com.requests;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequest {
	
	@NotBlank(message="Ce champ ne doit pas etre null ! ")
	private String firstName;
	
	@NotNull(message="Ce champ ne doit pas etre null ! ")
	@Size(min=3 , message="Ce champ doit avoir au moins 3 Caracteres ! ")
	private String lasteName;
	
	@NotNull(message="Ce champ ne doit pas etre null ! ")
	@Email(message="Ce champ doit respecter le format email ! ")
	private String email;
	
	@NotNull(message="Ce champ ne doit pas etre null ! ")
	@Size(min=8 , message="Le mot de passe doit avoir au moins 8 caracteres ! ")
	@Size(max=12 ,message="Le mot de passe doit avoir au maximun 12 caracteres ! ")
	@Pattern(regexp="(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$")
	private String password;
	
	private Boolean admin;
	
	private List<AddressRequest> addresses;
	
	private ContactRequest contact;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<AddressRequest> getAddresses() {
		return addresses;
	}
	
	public void setAddresses(List<AddressRequest> addresses) {
		this.addresses = addresses;
	}
	public ContactRequest getContact() {
		return contact;
	}
	public void setContact(ContactRequest contact) {
		this.contact = contact;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	

}
