package myApp.com.responses;

public enum ErrorMessages {
	
	MISSING_REQUIRED_FIELD("missing required field."),
	RECORD_ALREADY_EXISTS("record already exists."),
	INTERNAL_SERVER_ERROR("internal server error."),
	NO_RECORD_FOUND("record with provided  id is not found.");
	
	private String errorMessage;

	private ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
}
