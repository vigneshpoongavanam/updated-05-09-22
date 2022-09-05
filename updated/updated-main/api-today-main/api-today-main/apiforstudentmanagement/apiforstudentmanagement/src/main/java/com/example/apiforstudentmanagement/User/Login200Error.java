package com.example.apiforstudentmanagement.User;

public class Login200Error{
	private String type;
	private String token;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	public Login200Error(String type, String token) {
		this.type = type;
		this.token = token;
	}

	@Override
 	public String toString(){
		return 
			"Login200Error{" + 
			"type = '" + type + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}
