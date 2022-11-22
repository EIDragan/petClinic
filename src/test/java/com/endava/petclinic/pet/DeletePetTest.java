package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Pet;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeletePetTest extends TestBaseClass {

    @Test
    public void shouldDeletePet() {

        //GIVEN
        Pet pet = petClinicFixture.createPet().getPet();

        //WHEN
        Response response = petClient.deletePetById(pet.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }


}
