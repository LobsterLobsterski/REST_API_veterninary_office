package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.PrescriptionDto;
import com.tomasz.vet.entities.PrescriptionEntity;
import com.tomasz.vet.mappers.Mapper;
import com.tomasz.vet.services.PrescriptionService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public class PrescriptionMapper implements Mapper<PrescriptionEntity, PrescriptionDto> {

    private final ModelMapper modelMapper;

    public PrescriptionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PrescriptionDto mapTo(PrescriptionEntity prescriptionEntity) {
        return modelMapper.map(prescriptionEntity, PrescriptionDto.class);
    }

    @Override
    public PrescriptionEntity mapFrom(PrescriptionDto prescriptionDto) {
        return modelMapper.map(prescriptionDto, PrescriptionEntity.class);
    }
}
