package com.petstore.api.tests.authenticationTest;

import com.github.javafaker.Faker;
import com.petstore.api.authentication.AuthenticationController;
import com.petstore.api.authentication.User;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class CreateListOfUsersTest {
    @Test
    public void createListOfUsers() {
        AuthenticationController authenticationController = new AuthenticationController();
        Faker faker = new Faker();

        List<User> usersToRegister = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String username = faker.name().username();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String email = faker.internet().emailAddress();
            String password = "12345678";
            String phone = "0934754112";
            int userStatus = 0;

            User user = new User(username, firstName, lastName, email, password, phone, userStatus);
            usersToRegister.add(user);
        }

        String registrationMessage = authenticationController.createListOfUsers(usersToRegister);
        JSONObject jsonResponse = new JSONObject(registrationMessage);

        int code = jsonResponse.getInt("code");
        Assert.assertEquals(Integer.valueOf(200), Integer.valueOf(code), "Response code should be 200");

        String message = registrationMessage;
        Assert.assertTrue(!message.isEmpty() && message.matches(".*\\d.*"), "Response message should not be empty and should contain numbers");

    }
}



