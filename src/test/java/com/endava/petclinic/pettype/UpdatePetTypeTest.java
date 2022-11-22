package com.endava.petclinic.pettype;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.PetType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class UpdatePetTypeTest extends TestBaseClass {

    @Test
    public void shouldUpdatePetType() {
        //GIVEN
        PetType petType = petClinicFixture.createPetType()
                .getPetType();

        System.out.println("The initial pet type" + petType);

        petType.setName("The changed name");

        //WHEN
        Response response = petTypeClient.updatePetTypeBuId(petType.getId(), petType);

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }

}
