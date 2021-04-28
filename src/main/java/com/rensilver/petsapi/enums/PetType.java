package com.rensilver.petsapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PetType {

    DOG("Dog"),
    CAT("Cat"),
    BIRD("Bird");

    private final String description;

}
