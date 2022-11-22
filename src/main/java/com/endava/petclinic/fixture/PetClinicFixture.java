package com.endava.petclinic.fixture;

import com.endava.petclinic.client.OwnerClient;
import com.endava.petclinic.client.PetClient;
import com.endava.petclinic.client.PetTypeClient;
import com.endava.petclinic.client.VisitClient;
import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import com.endava.petclinic.testData.TestDataProvider;
import io.restassured.response.Response;
import lombok.Getter;
import org.apache.http.HttpStatus;

public class PetClinicFixture {

    private OwnerClient ownerClient = new OwnerClient();
    private PetClient petClient = new PetClient();

    private PetTypeClient petTypeClient = new PetTypeClient();

    private TestDataProvider dataProvider = new TestDataProvider();

    private VisitClient visitClient = new VisitClient();
    @Getter
    private Owner owner;
    @Getter
    private PetType petType;
    @Getter
    private Pet pet;
    @Getter
    private Visit visit;

    public PetClinicFixture createOwner() {

        owner = dataProvider.getOwner();
        Response response = ownerClient.createOwner(owner);
        response.then().statusCode(HttpStatus.SC_CREATED);

        Long id = response.body().jsonPath().getLong("id");
        owner.setId(id);

        return this;
    }

    public PetClinicFixture createPetType() {

        petType = dataProvider.getPetType();
        Response response = petTypeClient.addPetType(petType);
        response.then().statusCode(HttpStatus.SC_CREATED);

        Long id = response.body().jsonPath().getLong("id");
        petType.setId(id);

        return this;
    }

    public PetClinicFixture createPet() {
        createOwner();
        createPetType();
        pet = dataProvider.getPet(this.owner, this.petType);
        Response response = petClient.createPet(pet);
        response.then().statusCode(HttpStatus.SC_CREATED);

        Long id = response.body().jsonPath().getLong("id");
        pet.setId(id);

        return this;
    }

    public PetClinicFixture createVisit() {

        createPet();

        visit = dataProvider.getVisit(this.pet);
        Response response = visitClient.createVisit(visit);
        response.then().statusCode(HttpStatus.SC_CREATED);

        Long id = response.body().jsonPath().getLong("id");
        visit.setId(id);

        return this;
    }

}
