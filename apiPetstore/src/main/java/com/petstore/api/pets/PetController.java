package com.petstore.api.pets;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.petstore.api.entities.ApiSettings;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class PetController {

    public String addNewPet(PetEntity pet) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(pet);
        RequestBody requestBody = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .post(requestBody)
                .url(ApiSettings.URL + "/pet")
                .header(ApiSettings.CONTENT_TYPE, ApiSettings.TYPE_JSON)
                .header(ApiSettings.API_KEY, ApiSettings.API_VALUE)
                .build();

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            Objects.requireNonNull(response.body(), "Response body is null");
            if (!response.isSuccessful()) {
                throw new RuntimeException("Pet creation failed with status code: " + response.code());
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Pet creation failed", e);
        }
    }

    public String updatePetById(long id, String name, String status) throws IOException {
        OkHttpClient client = new OkHttpClient();
        PetEntity petEntity1 = new PetEntity(name, status);
        petEntity1.setName(name);
        petEntity1.setStatus(status);

        Gson gson = new Gson();
        String json = gson.toJson(petEntity1);
        RequestBody requestBody = RequestBody.create(json.getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .post(requestBody)
                .url(ApiSettings.URL + "/pet/" + id)
                .build();

        try (Response response = client.newCall(request).execute()) {
            Objects.requireNonNull(response.body(), "Response body is null");
            if (!response.isSuccessful()) {
                throw new RuntimeException("Pet update by Id failed with status code: " + response.code());
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Pet update by Id failed", e);
        }
    }

    public String updatePetImage(long Id, File imageFile) {
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("file", imageFile.getName(),
                        RequestBody.create(MediaType.parse("image/jpg"), imageFile))
                .build();

        Request request = new Request.Builder()
                .post(requestBody)
                .url(ApiSettings.URL + "/pet/" + Id + "/uploadImage")
                .header(ApiSettings.CONTENT_TYPE, ApiSettings.MULTIPART_FORM_DATA)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Photo uploaded successfully. " + response.body().string());
                return "200";
            } else {
                System.err.println("Failed to upload photo. Status code: " + response.code());
                return response.code() + " " + response.message();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "500 Internal Server Error";
        }
    }

    public String deletePet (long Id) throws IOException {
        Gson gson = new Gson();

        Request request = new Request.Builder()
                .delete()
                .url(ApiSettings.URL + "/pet/" + Id)
                .header(ApiSettings.API_KEY, ApiSettings.API_VALUE)
                .build();

        OkHttpClient client = new OkHttpClient();

        try (Response response = client.newCall(request).execute()) {
            Objects.requireNonNull(response.body(), "Response body is null");
            if (!response.isSuccessful()) {
                throw new RuntimeException("Pet deletion failed with status code: " + response.code());
            }
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException("Pet deletion failed", e);
        }
    }

    public int extractStatusCode(String response) {
        if (response.contains("200")) {
            return 200;
        } else {
            return -1;
        }
    }

    public long extractPetIdFromResponse(String response) {
        JsonParser jsonParser = new JsonParser();
        try (Reader reader = new StringReader(response)) {
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            if (jsonObject.has("id")) {
                return jsonObject.get("id").getAsLong();
            } else {
                throw new RuntimeException("Pet Id not found in the response");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error parsing JSON response", e);
        }
    }
}
