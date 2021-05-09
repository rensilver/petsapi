package com.rensilver.petsapi.utils;

import com.rensilver.petsapi.dto.request.PetDTO;
import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.enums.PetType;

import java.util.Collections;

public class PetUtils {

    private static final String NAME = "Lady";
    private static final Integer AGE = 6;
    private static final PetType PET_TYPE = PetType.BIRD;
    private static final long PET_ID = 1L;

    public static PetDTO createFakeDTO() {
        return PetDTO.builder()
                .name(NAME)
                .age(AGE)
                .petType(PET_TYPE)
                .owners(Collections.singletonList(OwnerUtils.createFakeDTO()))
                .build();
    }

    public static Pet createFakeEntity() {
        return Pet.builder()
                .id(PET_ID)
                .name(NAME)
                .petType(PET_TYPE)
                .owners(Collections.singletonList(OwnerUtils.createFakeEntity()))
                .build();
    }
}
