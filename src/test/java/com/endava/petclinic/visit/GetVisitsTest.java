package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class GetVisitsTest extends TestBaseClass {


    @Test
    public void shouldGetAllVisits() {
        //GIVEN

        //WHEN
        Response allVisits = visitClient.getAllVisits();

        //THEN
        allVisits.then().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldGetVisitById(){
       //GIVEN
        Visit visit = petClinicFixture.createVisit().getVisit();

        //WHEN
        Response response = visitClient.getVisitById(visit.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_OK);

    }

}
