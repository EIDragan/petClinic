package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class CreateVisitTest extends TestBaseClass {


    @Test
    public void shouldCreateVisitGivenValidData() {
        //GIVEN
        Visit visit = petClinicFixture.createVisit()
                .getVisit();

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode(HttpStatus.SC_CREATED);

    }

    @Test
    public void shouldNotCreateVisitWithEmptyDescription() {
        //GIVEN
        Visit visit = petClinicFixture.createVisit()
                .getVisit();

        visit.setDescription("");

        //WHEN
        Response response = visitClient.createVisit(visit);

        //THEN
        response.then().statusCode(HttpStatus.SC_BAD_REQUEST);


    }

}
