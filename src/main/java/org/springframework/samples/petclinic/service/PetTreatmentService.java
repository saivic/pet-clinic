package org.springframework.samples.petclinic.service;

//create a service interface for the PetTreatment entity

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.samples.petclinic.model.PetTreatment;

public interface PetTreatmentService {

    List<PetTreatment> findAllPetTreatments();

    CompletableFuture<List<PetTreatment>> findAllPetTreatmentsAsync();
    PetTreatment findPetTreatmentById(int id);

    List<PetTreatment> findPetTreatmentsByPetId(int petId);

    List<PetTreatment> findPetTreatmentsByVetId(int vetId);

    List<PetTreatment> findPetTreatmentsBySpecialtyId(int specialtyId);

    List<PetTreatment> findPetTreatmentsByDateRange(LocalDate startDate, LocalDate endDate);

    List<PetTreatment> findPetTreatmentsByPetIdAndDateRange(int petId, LocalDate startDate, LocalDate endDate);

    void savePetTreatment(PetTreatment petTreatment);

    void deletePetTreatment(PetTreatment petTreatment);

    List<PetTreatment> addTreatmentToQueue(PetTreatment petTreatment);

}
