package com.endava.petclinic.client;

import com.endava.petclinic.model.Visit;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class VisitClient extends BaseClient {

    public Response createVisit(Visit visit) {

        return getBasicRestConfig()
                .contentType(ContentType.JSON)
                .body(visit)
                .post("api/visits");

    }

    public Response getAllVisits() {

        return getBasicRestConfig()
                .get("api/visits");

    }

    public Response getVisitById(Long id) {

        return getBasicRestConfig()
                .pathParam("visitId", id)
                .get("api/visits/{visitId}");

    }

    public Response updateVisit(Long id, Visit visit) {

        return getBasicRestConfig()
                .pathParam("visitId", id)
                .contentType(ContentType.JSON)
                .body(visit)
                .put("api/visits/{visitId}");

    }

    public Response deleteVisitById(Long id) {

        return getBasicRestConfig()
                .pathParam("visitId", id)
                .delete("api/visits/{visitId}");

    }

}
