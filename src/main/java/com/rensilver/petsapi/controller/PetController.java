package com.rensilver.petsapi.controller;

import com.rensilver.petsapi.dto.request.PetDTO;
import com.rensilver.petsapi.dto.response.MessageResponseDTO;
import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.exception.PetNotFoundException;
import com.rensilver.petsapi.services.PetService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.io.Serializable;

@RestController
@RequestMapping("/pets")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetController implements Serializable {

    @Autowired
    private final PetService petService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PetDTO petDTO) {
        return petService.createPet(petDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PetDTO findById(@PathVariable Long id) throws PetNotFoundException {
        return petService.findById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long id, @RequestBody @Valid PetDTO petDTO) throws PetNotFoundException {
        return petService.update(id, petDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws PetNotFoundException {
        petService.delete(id);
    }
}
