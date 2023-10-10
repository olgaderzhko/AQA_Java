package com.petstore.api.tests.authenticationTest;

import com.github.javafaker.Faker;
import com.petstore.api.authentication.AuthenticationController;
import com.petstore.api.authentication.User;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateUserTest {
    @Test
    public void registerNewUser() throws IOException {
        AuthenticationController authenticationController = new AuthenticationController();
        Faker faker = new Faker();
        String username = faker.name().username();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = "12345678";
        String phone = "0934754112";
        int userStatus = 0;

        User user = new User(username, firstName, lastName, email, password, phone, userStatus);
        String registrationMessage = authenticationController.createUser(user);

        int statusCode = 200;
        Assert.assertEquals(statusCode, 200, "The status code does not match the expected one (200)");

        String message = registrationMessage;
        Assert.assertTrue(!message.isEmpty() && message.matches(".*\\d.*"), "Response message should not be empty and should contain numbers");
    }
}
