package com.rensilver.petsapi.dto.request;

import com.rensilver.petsapi.enums.PetType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;

    @NotEmpty
    private Integer age;

    @Enumerated(EnumType.STRING)
    private PetType petType;

    @Valid
    @NotEmpty
    private List<OwnerDTO> owners;

   /* public PetDTO(Pet entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.petType = entity.getPetType();
        this.owners = entity.getOwner().stream()
                .map(OwnerDTO::new).collect(Collectors.toList());
    }*/
}
