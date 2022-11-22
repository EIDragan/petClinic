package com.endava.petclinic.pet;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;


public class GetPetListTest extends TestBaseClass {

    @Test
    public void getPetList() {
        //GIVEN

        //WHEN
        Response pets = petClient.getPets();

        //THEN
        pets.then().statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void getPetById() {
        //GIVEN
        Pet pet = petClinicFixture.createPet().getPet();

        //WHEN
        Response petById = petClient.getPetById(pet.getId());

        //THEN
        petById.then().statusCode(HttpStatus.SC_OK)
                .body("id", is(notNullValue()));

    }

}
