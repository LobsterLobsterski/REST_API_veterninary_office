package com.tomasz.vet.repositories;

import com.tomasz.vet.domain.entities.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<BillEntity, Long> {
}
