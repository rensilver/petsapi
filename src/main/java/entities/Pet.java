package entities;

import enums.PetType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pet {

    private String name;
    private Integer age;
    private Owner owner;
    private PetType petType;
}
