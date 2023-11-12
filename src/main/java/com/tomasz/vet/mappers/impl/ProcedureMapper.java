package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.domain.dto.ProcedureDto;
import com.tomasz.vet.domain.entities.ProcedureEntity;
import com.tomasz.vet.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
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
