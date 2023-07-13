package org.springframework.samples.petclinic.rest.controller;

//rest controller for the CRUD operations on the PetTreatmentService with mappings for /pettreatments
//use PetTreatmentDTO to transfer data between the client and the server

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.dto.PetTreatmentDto;
import org.springframework.samples.petclinic.exception.TreatmentNotFoundException;
import org.springframework.samples.petclinic.mapper.PetTreatmentMapper;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.model.PetTreatment;
import org.springframework.samples.petclinic.model.Specialty;
import org.springframework.samples.petclinic.model.Vet;
import org.springframework.samples.petclinic.rest.dto.VetDto;
import org.springframework.samples.petclinic.service.PetTreatmentService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/async")
    public CompletableFuture<ResponseEntity<List<PetTreatmentDto>>> getAllPetTreatmentsAsync() throws TreatmentNotFoundException {
        return CompletableFuture.completedFuture(new ResponseEntity<>(petTreatmentService.findAllPetTreatments().stream()
                .map(petTreatmentMapper::petTreatmentToPetTreatmentDto).collect(Collectors.toList()), HttpStatus.OK));
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

    //method for savePetTreatment in PetTreatmentService
    @PostMapping
    public ResponseEntity<PetTreatmentDto> savePetTreatment(@RequestBody PetTreatmentDto petTreatmentDto) {
        HttpHeaders headers = new HttpHeaders();
        PetTreatment petTreatment = petTreatmentMapper.petTreatmentDtoToPetTreatment(petTreatmentDto);
        this.petTreatmentService.savePetTreatment(petTreatment);
        headers.setLocation(UriComponentsBuilder.newInstance().path("/api/pettreatments/{id}").buildAndExpand(petTreatment.getId()).toUri());
        return new ResponseEntity<>(petTreatmentMapper.petTreatmentToPetTreatmentDto(petTreatment), headers, HttpStatus.CREATED);
    }

    //method for updatePetTreatment in PetTreatmentService
    @PutMapping("/{id}")
    public ResponseEntity<PetTreatmentDto> updatePetTreatment(@PathVariable int id,
            @RequestBody PetTreatmentDto petTreatmentDto) throws TreatmentNotFoundException {
        PetTreatment petTreatment = petTreatmentService.findPetTreatmentById(id);
        if (petTreatment == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        petTreatment.setDescription(petTreatmentDto.getDescription());
        petTreatment.setTreatmentDate(petTreatmentDto.getTreatmentDate());
        petTreatmentService.savePetTreatment(petTreatment);
        return new ResponseEntity<>(petTreatmentMapper.petTreatmentToPetTreatmentDto(petTreatment), HttpStatus.OK);
    }

    //method for deletePetTreatment in PetTreatmentService
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePetTreatment(@PathVariable int id) throws TreatmentNotFoundException {
        PetTreatment petTreatment = petTreatmentService.findPetTreatmentById(id);
        if (petTreatment == null) {
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        petTreatmentService.deletePetTreatment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //add post mapping for adding a new pet trearment request using addTreatmentToQueue method
    @PostMapping("/addtreatment")
    public ResponseEntity<List<PetTreatmentDto>> addTreatmentToQueue(@RequestBody PetTreatmentDto petTreatmentDto) {
        HttpHeaders headers = new HttpHeaders();
        PetTreatment petTreatment = petTreatmentMapper.petTreatmentDtoToPetTreatment(petTreatmentDto);
        List<PetTreatment> schedule =  this.petTreatmentService.addTreatmentToQueue(petTreatment);
        return new ResponseEntity<>(petTreatmentMapper.petTreatmentToPetTreatmentDto(schedule), headers, HttpStatus.CREATED);
    }
}
