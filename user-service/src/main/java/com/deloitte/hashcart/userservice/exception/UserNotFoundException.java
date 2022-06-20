package com.deloitte.hashcart.userservice.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String s){
        super(s);
    }

    @Override
    public String toString(){
        return "User with Given Id is not found";
    }
    private static final long serialVersionUID = 1L;


}
