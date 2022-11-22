package com.endava.petclinic.visit;

import com.endava.petclinic.TestBaseClass;
import com.endava.petclinic.model.Visit;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class UpdateVisitTest extends TestBaseClass {

    @Test
    public void shouldUpdateVisitGivenValidData() {
        //GIVEN
        Visit visit = petClinicFixture.createVisit().getVisit();
        visit.setDate("2022/11/22");

        //WHEN
        Response response = visitClient.updateVisit(visit.getId(), visit);

        System.out.println(visit);
        System.out.println(visit.getId());

        //THEN
        response.then().statusCode(HttpStatus.SC_NO_CONTENT);

    }

}
