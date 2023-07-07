package org.springframework.samples.petclinic.service;

//class implements the PetTreatmentService interface
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetTreatment;
import org.springframework.samples.petclinic.repository.springdatajpa.SpringDataPetTreatmentRepository;
import org.springframework.stereotype.Service;

import org.springframework.samples.petclinic.exception.TreatmentNotFoundException;

@Service
public class PetTreatmentServiceImpl implements PetTreatmentService {

    @Autowired
    private SpringDataPetTreatmentRepository petTreatmentRepo;

    @Override
    public List<PetTreatment> findAllPetTreatments() {
        //throw TreatmentNotFoundException if list is empty
        List<PetTreatment> petTreatments = petTreatmentRepo.findAll();
        if (petTreatments.isEmpty()) {
            throw new TreatmentNotFoundException();
        }
        return petTreatments;
    }

    @Override
    public PetTreatment findPetTreatmentById(int id) {
        //throw TreatmentNotFoundException if petTreatment is null
        PetTreatment petTreatment = petTreatmentRepo.findPetTreatmentById(id);
        if (petTreatment == null) {
            throw new TreatmentNotFoundException();
        }
        return petTreatment;
    }

    @Override
    public List<PetTreatment> findPetTreatmentsByPetId(int petId) {
        //throw TreatmentNotFoundException if list is empty
        List<PetTreatment> petTreatments = petTreatmentRepo.findPetTreatmentsByPetId(petId);
        if (petTreatments.isEmpty()) {
            throw new TreatmentNotFoundException();
        }
        return petTreatments;
    }

    @Override
    public List<PetTreatment> findPetTreatmentsByVetId(int vetId) {
        //throw TreatmentNotFoundException if list is empty
        List<PetTreatment> petTreatments = petTreatmentRepo.findPetTreatmentsByVetId(vetId);
        if (petTreatments.isEmpty()) {
            throw new TreatmentNotFoundException();
        }
        return petTreatments;
    }

    @Override
    public List<PetTreatment> findPetTreatmentsBySpecialtyId(int specialtyId) {
        //throw TreatmentNotFoundException if list is empty
        List<PetTreatment> petTreatments = petTreatmentRepo.findPetTreatmentsBySpecialtyId(specialtyId);
        if (petTreatments.isEmpty()) {
            throw new TreatmentNotFoundException();
        }
        return petTreatments;
    }

    @Override
    public List<PetTreatment> findPetTreatmentsByDateRange(LocalDate startDate, LocalDate endDate) {
        //throw TreatmentNotFoundException if list is empty
        List<PetTreatment> petTreatments = petTreatmentRepo.findPetTreatmentsByDateRange(startDate, endDate);
        if (petTreatments.isEmpty()) {
            throw new TreatmentNotFoundException();
        }
        return petTreatments;
    }

    @Override
    public List<PetTreatment> findPetTreatmentsByPetIdAndDateRange(int petId, LocalDate startDate,
            LocalDate endDate) {
        //throw TreatmentNotFoundException if list is empty
        List<PetTreatment> petTreatments = petTreatmentRepo.findPetTreatmentsByPetIdAndDateRange(petId, startDate,
                endDate);
        if (petTreatments.isEmpty()) {
            throw new TreatmentNotFoundException();
        }
        return petTreatments;
    }

    @Override
    public void savePetTreatment(PetTreatment petTreatment) {
        petTreatmentRepo.save(petTreatment);
    }

    @Override
    public void deletePetTreatment(PetTreatment petTreatment) {
        petTreatmentRepo.delete(petTreatment);
    }

}
