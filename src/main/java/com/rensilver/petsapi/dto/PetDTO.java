package com.rensilver.petsapi.dto;

import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO implements Serializable {

    private Long id;
    private String name;
    private Integer age;
    private PetType petType;

    List<OwnerDTO> owners = new ArrayList<>();

    public PetDTO(Pet entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.petType = entity.getPetType();
        this.owners = entity.getOwner().stream()
                .map(OwnerDTO::new).collect(Collectors.toList());
    }
}
