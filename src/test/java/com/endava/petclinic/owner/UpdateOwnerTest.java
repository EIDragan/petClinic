package com.endava.petclinic.owner;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Owner;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class UpdateOwnerTest extends TestBaseClass {

    @Test
    public void shouldUpdateOwner() {
        //GIVEN
        Owner owner = petClinicFixture.createOwner()
                .getOwner();

        owner.setCity("Iasi");

        //WHEN
        Response response = ownerClient.updateOwnerById(owner.getId(), owner);

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);
    }

}
