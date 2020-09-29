package net.guides.springboot2.springboot2jpacrudexample.dto;

public class ResponseMessage {
	  private String message;

	  public ResponseMessage(String message) {
	    this.message = message;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public void setMessage(String message) {
	    this.message = message;
	  }
}