package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.domain.dto.MedicineDto;
import com.tomasz.vet.domain.entities.MedicineEntity;
import com.tomasz.vet.mappers.Mapper;
import org.modelmapper.ModelMapper;

public class MedicineMapper implements Mapper<MedicineEntity, MedicineDto> {

    private final ModelMapper modelMapper;

    public MedicineMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public MedicineDto mapTo(MedicineEntity medicineEntity) {
        return modelMapper.map(medicineEntity, MedicineDto.class);
    }

    @Override
    public MedicineEntity mapFrom(MedicineDto medicineDto) {
        return modelMapper.map(medicineDto, MedicineEntity.class);
    }
}
