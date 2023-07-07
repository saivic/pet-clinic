package org.springframework.samples.petclinic.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.samples.petclinic.dto.PetTreatmentDto;
import org.springframework.samples.petclinic.model.PetTreatment;

@Mapper
public interface PetTreatmentMapper {

    PetTreatmentMapper INSTANCE = Mappers.getMapper(PetTreatmentMapper.class);

    @Mapping(source = "pet.id", target = "petId")
    @Mapping(source = "pet.name", target = "petName")
    @Mapping(source = "vet.id", target = "vetId")
    @Mapping(source = "vet.firstName", target = "vetFirstName")
    @Mapping(source = "specialty.id", target = "specialtyId")
    @Mapping(source = "specialty.name", target = "specialtyName")
    PetTreatmentDto petTreatmentToPetTreatmentDto(PetTreatment petTreatment);

    @Mapping(source = "petId", target = "pet.id")
    @Mapping(source = "vetId", target = "vet.id")
    @Mapping(source = "specialtyId", target = "specialty.id")
    PetTreatment petTreatmentDtoToPetTreatment(PetTreatmentDto petTreatmentDto);

    List<PetTreatmentDto> petTreatmentToPetTreatmentDto(List<PetTreatment> petTreatment);

    List<PetTreatment> petTreatmentDtoToPetTreatment(List<PetTreatmentDto> petTreatmentDto);

}