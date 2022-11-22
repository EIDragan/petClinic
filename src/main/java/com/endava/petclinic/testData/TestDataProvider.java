package com.endava.petclinic.testData;

import com.endava.petclinic.model.Owner;
import com.endava.petclinic.model.Pet;
import com.endava.petclinic.model.PetType;
import com.endava.petclinic.model.Visit;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataProvider {

    private Faker faker = new Faker();

    public Owner getOwner() {

        Owner owner = new Owner();
        owner.setFirstName(faker.name().firstName()); //generam un nume de tip first name
        owner.setLastName(faker.name().lastName());
        owner.setAddress(faker.address().fullAddress());
        owner.setCity(faker.address().city());
        owner.setTelephone(faker.number().digits(faker.number().numberBetween(1, 11)));

        return owner;
    }

    public String getNumberWithDigits(int min, int max) {
        return faker.number().digits(faker.number().numberBetween(min, max));
    }

    public Pet getPet(Owner owner, PetType petType) {

        Pet pet = new Pet();
        pet.setBirthDate(getRandomDate());
        pet.setName(faker.name().fullName());
        pet.setOwner(owner);
        pet.setType(petType);

        return pet;
    }

    public String getRandomDate() {

        Integer randomYear = ThreadLocalRandom.current().nextInt(1980, 2022);
        Integer randomMonth = ThreadLocalRandom.current().nextInt(1, 13);
        Integer randomDay = ThreadLocalRandom.current().nextInt(1, 28);
        LocalDate randomDate = LocalDate.of(randomYear, randomMonth, randomDay);

        return randomDate.format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    }

    public PetType getPetType() {

        PetType petType = new PetType();
        petType.setName(faker.name().name());

        return petType;

    }

    public Visit getVisit(Pet pet) {

        Visit visit = new Visit();
        visit.setDate(getRandomDate());
        visit.setDescription(faker.name().bloodGroup());
        visit.setPet(pet);

        return visit;
    }

}
