package com.rensilver.petsapi.services;

import com.rensilver.petsapi.dto.PetDTO;
import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    @Transactional
    public PetDTO savePet(Pet dto) {
        Pet entity = new Pet();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setPetType(dto.getPetType());
        entity.setOwner(dto.getOwner());
        dto = petRepository.save(entity);
        return new PetDTO(dto);
    }
}
