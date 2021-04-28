package com.rensilver.petsapi.repositories;

import com.rensilver.petsapi.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}

