package myApp.com.exceptions;

public class UserException extends RuntimeException{

	
	private static final long serialVersionUID = -6482146377019908377L;
	
	public UserException(String message) {
		super (message);
	}
}
