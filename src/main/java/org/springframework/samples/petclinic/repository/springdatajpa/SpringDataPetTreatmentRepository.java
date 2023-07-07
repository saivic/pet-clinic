package org.springframework.samples.petclinic.repository.springdatajpa;

import java.time.LocalDate;

//repository interface for the PetTreatment entity
//this repository extends JpaRepository for CRUD methods 

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.PetTreatment;

public interface SpringDataPetTreatmentRepository extends JpaRepository<PetTreatment, Integer> {
    
     
        List<PetTreatment> findAll();

        PetTreatment findPetTreatmentById(int id);

        //query to find all treatments for a pet
        List<PetTreatment> findPetTreatmentsByPetId(int petId);

        //query to find all treatments for a vet
        List<PetTreatment> findPetTreatmentsByVetId(int vetId);

        //query to find all treatments for a specialty
        List<PetTreatment> findPetTreatmentsBySpecialtyId(int specialtyId);

        //query to find all treatments between two dates
        @Query("SELECT p FROM PetTreatment p WHERE p.treatmentDate BETWEEN ?1 AND ?2")
        List<PetTreatment> findPetTreatmentsByDateRange(LocalDate startDate, LocalDate endDate);

        //complex query to find all treatments for a pet between two dates
        @Query("SELECT p FROM PetTreatment p WHERE p.pet.id = ?1 AND p.treatmentDate BETWEEN ?2 AND ?3")
        List<PetTreatment> findPetTreatmentsByPetIdAndDateRange(int petId, LocalDate startDate, LocalDate endDate);




        
}











