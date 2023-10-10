package com.petstore.api.tests.petsTest;


import com.petstore.api.pets.PetController;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;

public class UpdatePetImageTest {

    @Test
    public void uploadImage() {
        PetController petController1 = new PetController();

        long Id = 111;
        File fileImage = new File(System.getProperty("user.dir") + "\\src\\test\\java\\com\\petstore\\api\\tests\\petsTest\\images\\dog.jpg");

        PetController petController = new PetController();
        String response = petController.updatePetImage(Id, fileImage);

        int expectedStatusCode = 200;
        int actualStatusCode = petController.extractStatusCode(response);
        Assert.assertEquals(actualStatusCode, expectedStatusCode, "The status code does not match the expected one (200)");
    }
}
