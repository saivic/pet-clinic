package org.springframework.samples.petclinic.designPatterns;

import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.model.Visit;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

//create a PetFactory class to create objects of Pet class from org.springframework.samples.petclinic.model.Pet
public class PetFactory {
    public Pet createPet(String name, LocalDate birthDate, PetType type, Owner owner, Set<Visit> visits) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setBirthDate(birthDate);
        pet.setType(type);
        pet.setOwner(owner);
        pet.setVisits(List.of(new Visit()));
        return pet;
    }
} 
