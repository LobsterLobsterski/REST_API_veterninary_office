package com.tomasz.vet.services;

import com.tomasz.vet.domain.dto.BillDto;
import com.tomasz.vet.domain.entities.BillEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BillService {
    BillEntity create(BillEntity billEntity);

    Optional<BillEntity> findOne(Long id);

    Page<BillEntity> findAll(Pageable pageable);
}
