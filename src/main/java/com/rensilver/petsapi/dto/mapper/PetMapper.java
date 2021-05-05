package com.rensilver.petsapi.dto.mapper;

import com.rensilver.petsapi.dto.request.PetDTO;
import com.rensilver.petsapi.entities.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {

    Pet toModel(PetDTO dto);

    PetDTO toDTO(Pet dto);
}
