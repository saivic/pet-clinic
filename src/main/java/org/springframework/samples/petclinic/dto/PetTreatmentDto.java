package org.springframework.samples.petclinic.dto;

//  data transfer object (DTO) class PetTreatmentDto for the PetTreatment entity
//  PetTreatmentDto has the following attributes:
//  id (Integer)
//  petId (Integer)
// petName (String)
//  vetId (Integer)
// vetFirstName (String)
//  treatmentDate (LocalDate)
//  description (String)
//  specialtyId (Integer)
//  specialtyName (String)

import java.time.LocalDate;

public class PetTreatmentDto {

    private Integer id;

    private Integer petId;

    private String petName;

    private Integer vetId;

    private String vetFirstName;

    private LocalDate treatmentDate;

    private String description;

    private Integer specialtyId;

    private String specialtyName;

    public Integer getId() {
        return this.id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getPetId() {
        return this.petId;
    }

    public void setPetId(final Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return this.petName;
    }

    public void setPetName(final String petName) {
        this.petName = petName;
    }

    public Integer getVetId() {
        return this.vetId;
    }

    public void setVetId(final Integer vetId) {
        this.vetId = vetId;
    }

    public String getVetFirstName() {
        return this.vetFirstName;
    }

    public void setVetFirstName(final String vetFirstName) {
        this.vetFirstName = vetFirstName;
    }

    public LocalDate getTreatmentDate() {
        return this.treatmentDate;
    }

    public void setTreatmentDate(final LocalDate treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getSpecialtyId() {
        return this.specialtyId;
    }

    public void setSpecialtyId(final Integer specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialtyName() {
        return this.specialtyName;
    }

    public void setSpecialtyName(final String specialtyName) {
        this.specialtyName = specialtyName;
    }

}


