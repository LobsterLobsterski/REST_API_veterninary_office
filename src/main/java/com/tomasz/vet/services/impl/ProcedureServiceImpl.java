package com.tomasz.vet.services.impl;

import com.tomasz.vet.domain.entities.ProcedureEntity;
import com.tomasz.vet.repositories.ProcedureRepository;
import com.tomasz.vet.services.ProcedureService;
import org.springframework.stereotype.Service;

@Service
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;

    public ProcedureServiceImpl(ProcedureRepository procedureRepository) {
        this.procedureRepository = procedureRepository;
    }

    @Override
    public ProcedureEntity create(ProcedureEntity procedureEntity) {
        return procedureRepository.save(procedureEntity);
    }
}
