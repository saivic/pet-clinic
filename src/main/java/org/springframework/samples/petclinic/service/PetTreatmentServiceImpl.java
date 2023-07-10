package org.springframework.samples.petclinic.service;

//class implements the PetTreatmentService interface
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.PetTreatment;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.repository.springdatajpa.SpringDataPetTreatmentRepository;
import org.springframework.samples.petclinic.repository.springdatajpa.SpringDataSpecialtyRepository;
import org.springframework.samples.petclinic.repository.springdatajpa.SpringDataVetRepository;
import org.springframework.security.access.method.P;
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

    Queue<PetTreatment> treatmentQueue = new LinkedList<PetTreatment>();

    //method to add treatment to queue and call the processTreatmentRequest method
    @Override
    public List<PetTreatment> addTreatmentToQueue(PetTreatment petTreatment) {
        treatmentQueue.add(petTreatment);
        List<PetTreatment> scheduledTreatments = scheduleTreatmentRequest();
        return scheduledTreatments;
    }
    

    private SpringDataVetRepository vetRepo;

    //mthod to find all available vets
    public List<Vet> findAllAvailableVets() {
        List<Vet> availableVets = (List<Vet>) vetRepo.findAll();
        return availableVets;
    }

    //method implementing fcfs algorithm to schedule a particular treatment request based on available vets
    public List<PetTreatment> scheduleTreatmentRequest() {
        List<PetTreatment> scheduledTreatments = new ArrayList<PetTreatment>();
        List<Vet> availableVets = findAllAvailableVets();
        while (!treatmentQueue.isEmpty() && !availableVets.isEmpty()) {
            PetTreatment treatment = treatmentQueue.poll();
            Vet vet = availableVets.get(0);
            treatment.setVet(vet);
            scheduledTreatments.add(treatment);
            Vet assignedVet = availableVets.remove(0);
            availableVets.add(assignedVet);
        }
        return scheduledTreatments;
    }
    
}
