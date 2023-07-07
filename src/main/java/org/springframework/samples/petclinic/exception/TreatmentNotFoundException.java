package org.springframework.samples.petclinic.exception;

//custom exception class for the PetTreatment entity not found
public class TreatmentNotFoundException extends RuntimeException {

    public TreatmentNotFoundException(String message) {
        super(message);
    }

    //default constructor with message "Treatment not found"
    public TreatmentNotFoundException() {
        super("Treatment not found");
    }
}
