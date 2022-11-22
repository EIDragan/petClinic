package com.endava.petclinic.client;

import com.endava.petclinic.model.Owner;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class OwnerClient extends BaseClient {

    public Response createOwner(Owner owner) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(owner)
                .post("api/owners");
    }

    public Response getOwnerById(Long id) {

        return getBasicRestConfig()
                .pathParam("ownerId", id)
                .get("api/owners/{ownerId}");
    }

    public Response getOwnersList() {

        return getBasicRestConfig()
                .get("api/owners");
    }

    public Response deleteOwnerById(Long id) {

        return getBasicRestConfig()
                .pathParam("ownerId", id)
                .delete("api/owners/{ownerId}");
    }

    public Response updateOwnerById(Long id, Owner owner) {

        return getBasicRestConfig()
                .pathParam("ownerId", id)
                .contentType(ContentType.JSON)
                .body(owner)
                .put("api/owners/{ownerId}");
    }

    public Response getOwnersListByLastName(String lastName) {

        return getBasicRestConfig()
                .pathParam("lastName", lastName)
                .get("api/owners/*/lastname/{lastName}");

    }
}
