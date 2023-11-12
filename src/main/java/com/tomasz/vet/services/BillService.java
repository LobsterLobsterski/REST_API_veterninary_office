package com.tomasz.vet.services;

import com.tomasz.vet.domain.entities.BillEntity;

import java.util.Optional;

public interface BillService {
    BillEntity create(BillEntity billEntity);

    Optional<BillEntity> findOne(Long id);
}
