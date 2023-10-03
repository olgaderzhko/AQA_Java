package com.petstore.api.tests.authTest;

import com.petstore.api.auth.AuthController;
import com.petstore.api.auth.User;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LoginLogoutUserTest {
    @Test
    public void loginLogoutUser() {
        AuthController authController = new AuthController();
        String username = "test";
        String password = "abc123";
        User user = new User(username, password);

        authController.login(user);
        Response response = authController.login(user);

        int statusCode = response.code();
        Assert.assertEquals(statusCode, 200, "The status code does not match the expected one (200)");

        String message = "logged in user session: 12345";
        Pattern pattern = Pattern.compile("^logged in user session: \\d+$");
        Matcher matcher = pattern.matcher(message);
        Assert.assertTrue(matcher.matches(), "Response message format is incorrect");

        Response logoutResponse = authController.logout(user);
        int logoutStatusCode = logoutResponse.code();
        Assert.assertEquals(logoutStatusCode, 200, "Logout failed with status code: " + logoutStatusCode);
    }
}
