package com.deloitte.hashcart.cartservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String firstname;
    private String middlename;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String mobileno;
    private Date dob;
    private String role;
    private String address;
    private String pincode;

}
