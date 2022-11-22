package com.endava.petclinic.client;

import com.endava.petclinic.model.PetType;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetTypeClient extends BaseClient {

    public Response getPetTypes() {

        return getBasicRestConfig()
                .get("api/pettypes");

    }

    public Response addPetType(PetType petType) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(petType)
                .post("api/pettypes");
    }

    public Response getPetTypeById(Long id) {

        return getBasicRestConfig()
                .pathParam("petTypeId", id)
                .get("api/pettypes/{petTypeId}");

    }

    public Response updatePetTypeBuId(Long id, PetType petType) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .pathParam("petTypeId", id)
                .body(petType)
                .put("api/pettypes/{petTypeId}");

    }

    public Response deletePetTypeById(Long id) {

        return getBasicRestConfig()
                .pathParam("petTypeId", id)
                .delete("api/pettypes/{petTypeId}");

    }
}
