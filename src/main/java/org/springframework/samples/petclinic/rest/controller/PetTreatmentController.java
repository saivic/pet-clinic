package org.springframework.samples.petclinic.rest.controller;

//rest controller for the CRUD operations on the PetTreatmentService with mappings for /pettreatments
//use PetTreatmentDTO to transfer data between the client and the server

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.dto.PetTreatmentDto;
import org.springframework.samples.petclinic.exception.TreatmentNotFoundException;
import org.springframework.samples.petclinic.mapper.PetTreatmentMapper;
import org.springframework.samples.petclinic.model.PetTreatment;
import org.springframework.samples.petclinic.service.PetTreatmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pettreatments")
public class PetTreatmentController {

    @Autowired
    private PetTreatmentService petTreatmentService;

    @Autowired
    private PetTreatmentMapper petTreatmentMapper;

    @GetMapping
    public ResponseEntity<List<PetTreatmentDto>> getAllPetTreatments() throws TreatmentNotFoundException {
        List<PetTreatment> petTreatments = petTreatmentService.findAllPetTreatments();
        if (petTreatments.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PetTreatmentDto> petTreatmentDtos = petTreatments.stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDto).collect(Collectors.toList());
        return new ResponseEntity<>(petTreatmentDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetTreatmentDto> getPetTreatmentById(@PathVariable int id)
            throws TreatmentNotFoundException {
        PetTreatment petTreatment = petTreatmentService.findPetTreatmentById(id);
        if (petTreatment == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(petTreatmentMapper.petTreatmentToPetTreatmentDto(petTreatment), HttpStatus.OK);
    }

    @GetMapping("/pet/{petId}")
    public ResponseEntity<List<PetTreatmentDto>> getPetTreatmentsByPetId(@PathVariable int petId)
            throws TreatmentNotFoundException {
        List<PetTreatment> petTreatments = petTreatmentService.findPetTreatmentsByPetId(petId);
        if (petTreatments.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PetTreatmentDto> petTreatmentDtos = petTreatments.stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDto).collect(Collectors.toList());
        return new ResponseEntity<>(petTreatmentDtos, HttpStatus.OK);
    }

    @GetMapping("/vet/{vetId}")
    public ResponseEntity<List<PetTreatmentDto>> getPetTreatmentsByVetId(@PathVariable int vetId)
            throws TreatmentNotFoundException {
        List<PetTreatment> petTreatments = petTreatmentService.findPetTreatmentsByVetId(vetId);
        if (petTreatments.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PetTreatmentDto> petTreatmentDtos = petTreatments.stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDto).collect(Collectors.toList());
        return new ResponseEntity<>(petTreatmentDtos, HttpStatus.OK);
    }

    @GetMapping("/specialty/{specialtyId}")
    public ResponseEntity<List<PetTreatmentDto>> getPetTreatmentsBySpecialtyId(@PathVariable int specialtyId)
            throws TreatmentNotFoundException {
        List<PetTreatment> petTreatments = petTreatmentService.findPetTreatmentsBySpecialtyId(specialtyId);
        if (petTreatments.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PetTreatmentDto> petTreatmentDtos = petTreatments.stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDto).collect(Collectors.toList());
        return new ResponseEntity<>(petTreatmentDtos, HttpStatus.OK);
    }

    @GetMapping("/date/{startDate}/{endDate}")
    public ResponseEntity<List<PetTreatmentDto>> getPetTreatmentsByDateRange(@PathVariable LocalDate startDate,
            @PathVariable LocalDate endDate) throws TreatmentNotFoundException {
        List<PetTreatment> petTreatments = petTreatmentService.findPetTreatmentsByDateRange(startDate, endDate);
        if (petTreatments.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PetTreatmentDto> petTreatmentDtos = petTreatments.stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDto).collect(Collectors.toList());
        return new ResponseEntity<>(petTreatmentDtos, HttpStatus.OK);
    }

    @GetMapping("/pet/{petId}/date/{startDate}/{endDate}")
    public ResponseEntity<List<PetTreatmentDto>> getPetTreatmentsByPetIdAndDateRange(@PathVariable int petId,
            @PathVariable LocalDate startDate, @PathVariable LocalDate endDate) throws TreatmentNotFoundException {
        List<PetTreatment> petTreatments = petTreatmentService.findPetTreatmentsByPetIdAndDateRange(petId, startDate,
                endDate);
        if (petTreatments.isEmpty()) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<PetTreatmentDto> petTreatmentDtos = petTreatments.stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDto).collect(Collectors.toList());
        return new ResponseEntity<>(petTreatmentDtos, HttpStatus.OK);
    }

}