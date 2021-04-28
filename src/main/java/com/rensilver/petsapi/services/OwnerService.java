package com.rensilver.petsapi.services;

import com.rensilver.petsapi.dto.OwnerDTO;
import com.rensilver.petsapi.entities.Owner;
import com.rensilver.petsapi.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Transactional
    public OwnerDTO saveOwner(Owner dto) {
        Owner entity = new Owner();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setCpf(dto.getCpf());
        dto = ownerRepository.save(entity);
        return new OwnerDTO(dto);
    }
}
