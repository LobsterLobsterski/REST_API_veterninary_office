package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.VeterinarianDto;
import com.tomasz.vet.entities.VeterinarianEntity;
import com.tomasz.vet.mappers.Mapper;
import com.tomasz.vet.services.VeterinarianService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public class VeterinarianMapper implements Mapper<VeterinarianEntity, VeterinarianDto> {

    private final ModelMapper modelMapper;

    public VeterinarianMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public VeterinarianDto mapTo(VeterinarianEntity veterinarianEntity) {
        return modelMapper.map(veterinarianEntity, VeterinarianDto.class);
    }

    @Override
    public VeterinarianEntity mapFrom(VeterinarianDto veterinarianDto) {
        return modelMapper.map(veterinarianDto, VeterinarianEntity.class);
    }
}
