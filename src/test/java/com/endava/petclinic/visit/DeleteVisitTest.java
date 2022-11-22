package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class DeleteVisitTest extends TestBaseClass {

    @Test
    public void shouldDeleteVisit() {
        //GIVEN
        Visit visit = petClinicFixture.createVisit().getVisit();

        //WHEN
        Response response = visitClient.deleteVisitById(visit.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }

}
