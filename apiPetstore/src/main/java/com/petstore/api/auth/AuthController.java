package com.petstore.api.auth;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;

public class AuthController {
    public String createUser(User user) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", user.getUsername());
        jsonObject.put("firstName", user.getFirstName());
        jsonObject.put("lastName", user.getLastName());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("password", user.getPassword());
        jsonObject.put("phone", user.getPhone());
        jsonObject.put("userStatus", user.getUserStatus());

        RequestBody requestBody = RequestBody.create(jsonObject.toString().getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .post(requestBody)
                .url(ApiSettings.URL + "/user")
                .header(ApiSettings.CONTENT_TYPE, ApiSettings.TYPE_JSON)
                .build();

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            Objects.requireNonNull(response.body(), "Response body is null");
            if (!response.isSuccessful()) {
                throw new RuntimeException("User registration failed with status code: " + response.code());
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("User registration failed", e);
        }
    }

    public String createListOfUsers(List<User> users) {
        JSONArray jsonArray = new JSONArray();
        for (User user : users) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("username", user.getUsername());
            jsonObject.put("firstName", user.getFirstName());
            jsonObject.put("lastName", user.getLastName());
            jsonObject.put("email", user.getEmail());
            jsonObject.put("password", user.getPassword());
            jsonObject.put("phone", user.getPhone());
            jsonObject.put("userStatus", user.getUserStatus());
            jsonArray.put(jsonObject);
        }
        RequestBody requestBody = RequestBody.create(jsonArray.toString().getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .post(requestBody)
                .url(ApiSettings.URL + "/user/createWithList")
                .header(ApiSettings.CONTENT_TYPE, ApiSettings.TYPE_JSON)
                .build();

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            Objects.requireNonNull(response.body(), "Response body is null");
            if (!response.isSuccessful()) {
                throw new RuntimeException("Users registration failed with status code: " + response.code());
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Users registration failed", e);
        }
    }

    public Response login (User user) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", user.getUsername());
        jsonObject.put("password", user.getPassword());

        Request request = new Request.Builder()
                .get()
                .url(ApiSettings.URL + "/user/login")
                .header(ApiSettings.CONTENT_TYPE, ApiSettings.TYPE_JSON)
                .header(ApiSettings.API_KEY, ApiSettings.API_VALUE)
                .build();

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("User login failed with status code: " + response.code());
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Network error occurred", e);
        }
    }

    public Response logout (User user) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", user.getUsername());
        jsonObject.put("password", user.getPassword());

        Request request = new Request.Builder()
                .get()
                .url(ApiSettings.URL + "/user/logout")
                .header(ApiSettings.CONTENT_TYPE, ApiSettings.TYPE_JSON)
                .build();

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("User logout failed with status code: " + response.code());
            }
            return response;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Network error occurred", e);
        }
    }
}
