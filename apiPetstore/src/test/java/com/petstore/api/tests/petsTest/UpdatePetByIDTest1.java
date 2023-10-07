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

/**
 * @author Derzhko.O
 */
public class UpdatePetByIDTest1 {

    @Test
    public void updatePets() throws IOException {
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
        String petName = faker.animal().name();
        String newStatus = faker.lorem().word();

        String responseUpdatePet = petController.updatePetById(petId, petName, newStatus);
        System.out.println(responseUpdatePet);
        System.out.println(petId);
        System.out.println(petName);
        System.out.println(newStatus);
        int expectedStatusCode = 200;
        int actualStatusCode = petController.extractStatusCode(responseUpdatePet);
        Assert.assertEquals(expectedStatusCode, actualStatusCode, "The status code does not match the expected one (200)");
    }
}
