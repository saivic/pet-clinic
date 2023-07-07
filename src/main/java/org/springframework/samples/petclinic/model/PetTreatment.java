package org.springframework.samples.petclinic.model;

// create a model class PetTreatment with the following attributes:
// id (Integer)
// pet (Pet)
// vet (Vet)
// treatmentDate (LocalDate)
// description (String)
// specialty (Specialty)
// PetTreatment is a subclass of BaseEntity
// PetTreatment has a ManyToOne relationship with Pet
// PetTreatment has a ManyToOne relationship with Vet
// PetTreatment has a ManyToOne relationship with Specialty

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet_treatments")
public class PetTreatment extends BaseEntity {

    @Column(name = "treatment_date")
    private LocalDate treatmentDate;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    @ManyToOne
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

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

    public Pet getPet() {
        return this.pet;
    }

    public void setPet(final Pet pet) {
        this.pet = pet;
    }

    public Vet getVet() {
        return this.vet;
    }

    public void setVet(final Vet vet) {
        this.vet = vet;
    }

    public Specialty getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(final Specialty specialty) {
        this.specialty = specialty;
    }

    //toString
    @Override
    public String toString() {
        return "PetTreatment{" +
                "treatmentDate=" + this.treatmentDate +
                ", description='" + this.description + '\'' +
                ", pet=" + this.pet +
                ", vet=" + this.vet +
                ", specialty=" + this.specialty +
                '}';
    }
}



