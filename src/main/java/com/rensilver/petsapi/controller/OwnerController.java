package com.rensilver.petsapi.controller;

import com.rensilver.petsapi.dto.OwnerDTO;
import com.rensilver.petsapi.entities.Owner;
import com.rensilver.petsapi.repositories.OwnerRepository;
import com.rensilver.petsapi.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    public OwnerDTO insertOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }
}
