package com.rensilver.petsapi.services;

import com.rensilver.petsapi.dto.mapper.PetMapper;
import com.rensilver.petsapi.dto.request.PetDTO;
import com.rensilver.petsapi.dto.response.MessageResponseDTO;
import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.exception.PetNotFoundException;
import com.rensilver.petsapi.repositories.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    public MessageResponseDTO createPet(PetDTO petDTO) {
        Pet pet = petMapper.toModel(petDTO);
        Pet savedPet = petRepository.save(pet);

        MessageResponseDTO messageResponseDTO = createMessageResponse("Pet successfully created with ID ", savedPet.getId());

        return messageResponseDTO;
    }

    public PetDTO findById(Long id) throws PetNotFoundException {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
        return petMapper.toDTO(pet);
    }

    public List<PetDTO> listAll() {
        List<Pet> animal = petRepository.findAll();
        return animal.stream()
                .map(petMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MessageResponseDTO update(Long id, PetDTO petDTO) throws PetNotFoundException {
        petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));

        Pet updatedPet = petMapper.toModel(petDTO);
        Pet savedPet = petRepository.save(updatedPet);

        MessageResponseDTO messageResponse = createMessageResponse("Pet successfully updated with ID ", savedPet.getId());
        return messageResponse;
    }

    public void delete(Long id) throws PetNotFoundException {
        petRepository.findById(id)
                .orElseThrow(() -> new PetNotFoundException(id));
        petRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }
}
