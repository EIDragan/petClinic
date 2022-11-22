package com.endava.petclinic;

import com.endava.petclinic.client.OwnerClient;
import com.endava.petclinic.client.PetClient;
import com.endava.petclinic.client.PetTypeClient;
import com.endava.petclinic.client.VisitClient;
import com.endava.petclinic.extensions.TestExecutionExtension;
import com.endava.petclinic.fixture.PetClinicFixture;
import com.endava.petclinic.services.DBService;
import com.endava.petclinic.testData.TestDataProvider;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(TestExecutionExtension.class)
public class TestBaseClass {

    protected OwnerClient ownerClient = new OwnerClient();
    protected TestDataProvider testDataProvider = new TestDataProvider();

    protected PetClient petClient = new PetClient();

    protected PetTypeClient petTypeClient = new PetTypeClient();

    protected PetClinicFixture petClinicFixture = new PetClinicFixture();

    protected VisitClient visitClient = new VisitClient();

}
