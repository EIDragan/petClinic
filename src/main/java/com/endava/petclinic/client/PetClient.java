package com.endava.petclinic.client;

import com.endava.petclinic.model.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetClient extends BaseClient {

    public Response getPets() {

        return getBasicRestConfig()
                .get("api/pets");

    }

    public Response createPet(Pet pet) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(pet)
                .post("api/pets");

    }

    public Response getPetById(Long id) {

        return getBasicRestConfig()
                .pathParam("petId", id)
                .get("api/pets/{petId}");

    }

    public Response updatePetById(Long id, Pet pet) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .pathParam("petId", id)
                .body(pet)
                .put("api/pets/{petId}");

    }

    public Response deletePetById(Long id) {

        return getBasicRestConfig()
                .pathParam("petId", id)
                .delete("api/pets/{petId}");

    }

    public Response getPetTypes() {

        return getBasicRestConfig()
                .get("api/pets/pettypes");

    }

}
