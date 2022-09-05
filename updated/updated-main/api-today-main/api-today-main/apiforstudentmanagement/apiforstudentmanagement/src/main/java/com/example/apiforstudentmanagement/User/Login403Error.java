package com.example.apiforstudentmanagement.User;

public class Login403Error{
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public Login403Error(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"Login403Error{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
