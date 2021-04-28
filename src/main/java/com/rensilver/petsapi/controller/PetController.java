package com.rensilver.petsapi.controller;

import com.rensilver.petsapi.dto.PetDTO;
import com.rensilver.petsapi.entities.Owner;
import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.repositories.PetRepository;
import com.rensilver.petsapi.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@RestController
@RequestMapping("/pets")
public class PetController implements Serializable {

    @Autowired
    private PetService petService;

    @PostMapping
    public PetDTO insertPet(@RequestBody Pet pet) {
        return petService.savePet(pet);
    }

}
