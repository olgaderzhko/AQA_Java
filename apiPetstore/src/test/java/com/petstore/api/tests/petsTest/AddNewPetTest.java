package com.petstore.api.tests.petsTest;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.petstore.api.pets.PetCategoryEntity;
import com.petstore.api.pets.PetController;
import com.petstore.api.pets.PetEntity;
import com.petstore.api.pets.TagEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddNewPetTest {
    @Test
    public void AddNewPet() throws IOException {
        PetController petController = new PetController();
        Faker faker = new Faker();

        PetEntity pet = new PetEntity(
                new PetCategoryEntity("categoty"),
                faker.animal().name(),
                new ArrayList<String>(List.of(faker.internet().url())),
                new ArrayList<>(List.of(new TagEntity(faker.lorem().word()))),
                "status"
        );

        String response = petController.addNewPet(pet);
        JsonObject jsonObject = JsonParser.parseString(response).getAsJsonObject();

        Assert.assertTrue(jsonObject.has("id"));
        Assert.assertTrue(jsonObject.has("category"));
        Assert.assertTrue(jsonObject.has("name"));
        Assert.assertTrue(jsonObject.has("photoUrls"));
        Assert.assertTrue(jsonObject.has("tags"));
        Assert.assertTrue(jsonObject.has("status"));

        System.out.println(response);

    }
}
