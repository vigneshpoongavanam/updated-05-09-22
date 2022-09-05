package com.example.apiforstudentmanagement.User;

public class ListResponse200{
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public ListResponse200(String message) {
		this.message = message;
	}

	@Override
 	public String toString(){
		return 
			"ListResponse200{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}
