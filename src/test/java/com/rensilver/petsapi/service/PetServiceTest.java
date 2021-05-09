package com.rensilver.petsapi.service;

import com.rensilver.petsapi.dto.mapper.PetMapper;
import com.rensilver.petsapi.dto.request.PetDTO;
import com.rensilver.petsapi.dto.response.MessageResponseDTO;
import com.rensilver.petsapi.entities.Pet;
import com.rensilver.petsapi.repositories.PetRepository;
import com.rensilver.petsapi.services.PetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.rensilver.petsapi.utils.PetUtils.createFakeDTO;
import static com.rensilver.petsapi.utils.PetUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PetServiceTest {

    @Mock
    private PetRepository petRepository;

    @Mock
    private PetMapper petMapper;

    @InjectMocks
    private PetService petService;

    @Test
    void testGivenPetDTOThenReturnSavedMessage() {
        PetDTO petDTO = createFakeDTO();
        Pet expectedSavedPet = createFakeEntity();

        when(petMapper.toModel(petDTO)).thenReturn(expectedSavedPet);
        when(petRepository.save(any(Pet.class))).thenReturn(expectedSavedPet);

        MessageResponseDTO expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPet.getId());
        MessageResponseDTO successMessage = petService.createPet(petDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedSuccessMessage(Long savedPersonId) {
        return MessageResponseDTO.builder()
                .message("Pet successfully created with ID " + savedPersonId)
                .build();
    }
}
