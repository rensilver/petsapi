package com.rensilver.petsapi.mapper;

import com.rensilver.petsapi.dto.mapper.PetMapper;
import com.rensilver.petsapi.dto.request.OwnerDTO;
import com.rensilver.petsapi.dto.request.PetDTO;
import com.rensilver.petsapi.entities.Owner;
import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.utils.PetUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PetMapperTest {

    @Autowired
    private PetMapper petMapper;

    @Test
    void testGivenPetDTOThenReturnPetEntity() {
        PetDTO petDTO = PetUtils.createFakeDTO();
        Pet pet = petMapper.toModel(petDTO);

        assertEquals(petDTO.getName(), pet.getName());
        assertEquals(petDTO.getAge(), pet.getAge());
        assertEquals(petDTO.getPetType(), pet.getPetType());

        Owner owner = pet.getOwners().get(0);
        OwnerDTO ownerDTO = petDTO.getOwners().get(0);

        assertEquals(ownerDTO.getFirstName(), owner.getFirstName());
        assertEquals(ownerDTO.getLastName(), owner.getLastName());
        assertEquals(ownerDTO.getCpf(), owner.getCpf());
    }

    @Test
    void testGivenPetEntityThenReturnPetDTO() {
        Pet pet = PetUtils.createFakeEntity();
        PetDTO petDTO = petMapper.toDTO(pet);

        assertEquals(pet.getName(), petDTO.getName());
        assertEquals(pet.getAge(), petDTO.getAge());
        assertEquals(pet.getPetType(), petDTO.getPetType());

        Owner owner = pet.getOwners().get(0);
        OwnerDTO ownerDTO = petDTO.getOwners().get(0);

        assertEquals(owner.getFirstName(), ownerDTO.getFirstName());
        assertEquals(owner.getLastName(), ownerDTO.getLastName());
        assertEquals(owner.getCpf(), ownerDTO.getCpf());
    }
}
