package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.ProcedureDto;
import com.tomasz.vet.entities.ProcedureEntity;
import com.tomasz.vet.mappers.Mapper;
import com.tomasz.vet.services.ProcedureService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


public class ProcedureMapper implements Mapper<ProcedureEntity, ProcedureDto> {

    private final ModelMapper modelMapper;

    public ProcedureMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ProcedureDto mapTo(ProcedureEntity procedureEntity) {
        return modelMapper.map(procedureEntity, ProcedureDto.class);
    }

    @Override
    public ProcedureEntity mapFrom(ProcedureDto procedureDto) {
        return modelMapper.map(procedureDto, ProcedureEntity.class);
    }
}
