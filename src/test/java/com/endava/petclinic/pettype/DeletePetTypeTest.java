package com.endava.petclinic.pettype;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeletePetTypeTest extends TestBaseClass {

    @Test
    public void shouldDeletePetType() {
        //GIVEN
        PetType petType = petClinicFixture.createPetType()
                .getPetType();

        //WHEN
        Response response = petTypeClient.deletePetTypeById(petType.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }

}



