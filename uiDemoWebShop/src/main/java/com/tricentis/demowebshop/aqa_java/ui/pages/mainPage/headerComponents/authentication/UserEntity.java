package com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication;

/**
 * @author Derzhko.O
 */
public class UserEntity {
    public String firstName;
    public String lastname;
    public String email;
    public String password;
    public String confirmPassword;


    public UserEntity(String firstName, String lastname, String email, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public UserEntity (String email, String password) {
        this.email = email;
        this.password = password;
    }
}
