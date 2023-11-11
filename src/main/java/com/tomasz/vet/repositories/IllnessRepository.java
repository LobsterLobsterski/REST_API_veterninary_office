package com.tomasz.vet.repositories;

import com.tomasz.vet.entities.IllnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends JpaRepository<IllnessEntity, String> {
}
