package com.petstore.api.tests.petsTest;

import com.github.javafaker.Faker;
import com.petstore.api.pets.PetCategoryEntity;
import com.petstore.api.pets.PetController;
import com.petstore.api.pets.PetEntity;
import com.petstore.api.pets.TagEntity;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeletePetTest {
    @Test
    public void DeletePetByID() throws IOException {

        PetController petController = new PetController();
        Faker faker = new Faker();

        long petIdToCreate = 12345L;
        PetEntity pet = new PetEntity(
                new PetCategoryEntity("category"),
                faker.animal().name(),
                new ArrayList<>(List.of(faker.internet().url())),
                new ArrayList<>(List.of(new TagEntity(faker.lorem().word()))),
                "status"
        );
        pet.setId(petIdToCreate);
        String response = petController.addNewPet(pet);

        long petId = petController.extractPetIdFromResponse(response);
        String responseDeletePet = petController.deletePet(petId);

        int expectedStatusCode = 200;
        int actualStatusCode = petController.extractStatusCode(responseDeletePet);
        Assert.assertEquals(expectedStatusCode, actualStatusCode, "The status code does not match the expected one (200)");
    }
}
