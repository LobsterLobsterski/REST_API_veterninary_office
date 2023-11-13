package com.tomasz.vet.services;

import com.tomasz.vet.domain.entities.ProcedureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProcedureService {
    ProcedureEntity create(ProcedureEntity procedureEntity);

    Page<ProcedureEntity> findAll(Pageable pageable);

    Optional<ProcedureEntity> findOne(Long id);

    Optional<ProcedureEntity> fullUpdate(Long id, ProcedureEntity procedureEntity);
}
