package it.seda.security.cas.exceptions;

@SuppressWarnings("serial")
public class UserNotGrantedException extends RuntimeException {
	
	public UserNotGrantedException() {
		// TODO Auto-generated constructor stub
	}

	public UserNotGrantedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserNotGrantedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotGrantedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
