package com.endava.petclinic.pettype;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class GetPetTypesTest extends TestBaseClass {

    @Test
    public void shouldGetAllPetTypes() {
        //GIVEN

        //WHEN
        Response petTypes = petTypeClient.getPetTypes();

        //THEN
        petTypes.then().statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void shouldGetTypeById() {
        //GIVEN
        PetType petType = petClinicFixture.createPetType()
                .getPetType();

        //WHEN
        Response response = petTypeClient.getPetTypeById(petType.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);

    }

}
