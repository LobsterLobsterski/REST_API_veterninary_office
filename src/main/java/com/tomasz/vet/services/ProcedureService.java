package com.tomasz.vet.services;

import com.tomasz.vet.domain.entities.ProcedureEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProcedureService {
    ProcedureEntity create(ProcedureEntity procedureEntity);

    Page<ProcedureEntity> findAll(Pageable pageable);
}
