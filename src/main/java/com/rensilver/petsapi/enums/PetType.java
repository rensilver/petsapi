package com.rensilver.petsapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PetType {

    CAO("Cão"),
    GATO("Gato"),
    PASSARO("PASSARO");

    private final String description;

}
