package com.example.applicationConfig.models;

public class LoginResponseDTO {
	
    private UserModel user;
    private String jwt;

    public LoginResponseDTO(){
        super();
    }

    public LoginResponseDTO(UserModel user, String jwt){
        this.user = user;
        this.jwt = jwt;
    }

    public UserModel getUser(){
        return this.user;
    }

    public void setUser(UserModel user){
        this.user = user;
    }

    public String getJwt(){
        return this.jwt;
    }

    public void setJwt(String jwt){
        this.jwt = jwt;
    }

}
