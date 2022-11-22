package com.endava.petclinic.pettype;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class CreatePetTypeTest extends TestBaseClass {

    @Test
    public void shouldCreatePetTypeGivenValidData() {
        //GIVEN
        PetType petType = petClinicFixture.createPetType()
                .getPetType();

        //WHEN
        Response response = petTypeClient.addPetType(petType);

        //THEN
        response.then().statusCode(HttpStatus.SC_CREATED)
                .body("id", is(notNullValue()))
                .body("name", is(notNullValue()));
    }

    @Test
    public void shouldFailToCreatePetTypeGivenEmptyName() {
        //GIVEN
        PetType petType = petClinicFixture.createPetType()
                .getPetType();
        petType.setName("");

        //WHEN
        Response response = petTypeClient.addPetType(petType);

        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
