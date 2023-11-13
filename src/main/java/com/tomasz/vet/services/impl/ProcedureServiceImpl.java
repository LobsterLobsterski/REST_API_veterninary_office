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

    @Override
    public Optional<ProcedureEntity> fullUpdate(Long id, ProcedureEntity procedureEntity) {
        if (!procedureRepository.existsById(id)){
            return Optional.empty();
        }
        procedureEntity.setId(id);
        return Optional.of(procedureRepository.save(procedureEntity));
    }

    @Override
    public Optional<ProcedureEntity> partialUpdate(Long id, ProcedureEntity procedureEntity) {
        if (!procedureRepository.existsById(id)){
            return Optional.empty();
        }
        procedureEntity.setId(id);
        System.out.println("----------------------"+procedureEntity.getCost());
        return procedureRepository.findById(id).map(existingProcedure -> {
            Optional.ofNullable(procedureEntity.getName()).ifPresent(existingProcedure::setName);
            Optional.ofNullable(procedureEntity.getCost()).ifPresent(existingProcedure::setCost);
            Optional.ofNullable(procedureEntity.getComments()).ifPresent(existingProcedure::setComments);
            Optional.ofNullable(procedureEntity.getOnBills()).ifPresent(existingProcedure::setOnBills);
            return existingProcedure;
        });
    }

    @Override
    public void delete(Long id) {
        procedureRepository.deleteById(id);
    }
}
