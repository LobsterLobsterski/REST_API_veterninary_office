package com.tomasz.vet.services.impl;

import com.tomasz.vet.domain.entities.ProcedureEntity;
import com.tomasz.vet.repositories.ProcedureRepository;
import com.tomasz.vet.services.ProcedureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public Page<ProcedureEntity> findAll(Pageable pageable) {
        return procedureRepository.findAll(pageable);
    }

    @Override
    public Optional<ProcedureEntity> findOne(Long id) {
        return procedureRepository.findById(id);
    }
}
