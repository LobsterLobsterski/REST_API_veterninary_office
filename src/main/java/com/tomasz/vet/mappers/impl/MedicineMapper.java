package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.MedicineDto;
import com.tomasz.vet.entities.MedicineEntity;
import com.tomasz.vet.mappers.Mapper;
import com.tomasz.vet.services.MedicineService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
