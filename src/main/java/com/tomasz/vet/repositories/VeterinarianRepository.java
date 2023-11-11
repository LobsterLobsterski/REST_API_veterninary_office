package com.tomasz.vet.repositories;

import com.tomasz.vet.entities.VeterinarianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<VeterinarianEntity, Long> {
}
