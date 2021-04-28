package com.rensilver.petsapi.dto;


import com.rensilver.petsapi.entities.Owner;
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
public class OwnerDTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String cpf;

    public OwnerDTO(Owner entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.lastName = entity.getLastName();
        this.cpf = entity.getCpf();
    }
}
