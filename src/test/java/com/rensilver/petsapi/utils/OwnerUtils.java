package com.rensilver.petsapi.utils;

import com.rensilver.petsapi.dto.request.OwnerDTO;
import com.rensilver.petsapi.entities.Owner;

public class OwnerUtils {

    private static final String FIRST_NAME = "Janice";
    private static final String LAST_NAME = "Barbosa";
    private static final String CPF = "05465632101";
    private static final long OWNER_ID = 1L;

    public static OwnerDTO createFakeDTO() {
        return OwnerDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .build();
    }

    public static Owner createFakeEntity() {
        return Owner.builder()
                .id(OWNER_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF)
                .build();
    }

}
