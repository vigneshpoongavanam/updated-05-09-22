package com.example.apiforstudentmanagement.User;

public class Login404Error{
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public Login404Error(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"Login404Error{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
