package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class UpdatePetTest extends TestBaseClass {

    @Test
    public void shouldUpdatePetGivenValidData() {
        //GIVEN
        Pet pet = petClinicFixture.createPet().getPet();

        pet.setName("CARL");

        //WHEN
        Response response = petClient.updatePetById(pet.getId(), pet);

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }


}
