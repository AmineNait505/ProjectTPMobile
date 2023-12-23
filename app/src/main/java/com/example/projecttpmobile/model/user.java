package com.example.projecttpmobile.model;

public class user {
    private String username;
    private String pwd;
    private String email;
    public user(String username,String pwd,String email){
        this.username=username;
        this.pwd=pwd;
        this.email=email;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username1){
        username=username1;

    }
    public String getPwd(){
        return pwd;
    }
    public void setPwd(String pwd1){
        pwd=pwd1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
