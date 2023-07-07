package org.springframework.samples.petclinic.designPatterns;

//create a PetBuilder class to create objects of Pet class from org.springframework.samples.petclinic.model.Pet
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class PetBuilder {
    private Pet pet;

    public PetBuilder() {
        pet = new Pet();
    }

    public PetBuilder setName(String name) {
        pet.setName(name);
        return this;
    }

    public PetBuilder setBirthDate(LocalDate birthDate) {
        pet.setBirthDate(birthDate);
        return this;
    }

    public PetBuilder setType(PetType type) {
        pet.setType(type);
        return this;
    }

    public PetBuilder setOwner(Owner owner) {
        pet.setOwner(owner);
        return this;
    }

    public PetBuilder setVisits(Set<Visit> visits) {
        pet.setVisits(List.of(new Visit()));
        return this;
    }

    public Pet build() {
        return pet;
    }
}
