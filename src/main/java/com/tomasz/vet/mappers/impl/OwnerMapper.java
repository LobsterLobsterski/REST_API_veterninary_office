package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.OwnerDto;
import com.tomasz.vet.entities.OwnerEntity;
import com.tomasz.vet.mappers.Mapper;
import com.tomasz.vet.services.OwnerService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


public class OwnerMapper implements Mapper<OwnerEntity, OwnerDto> {

    private final ModelMapper modelMapper;

    public OwnerMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OwnerDto mapTo(OwnerEntity ownerEntity) {
        return modelMapper.map(ownerEntity, OwnerDto.class);
    }

    @Override
    public OwnerEntity mapFrom(OwnerDto ownerDto) {
        return modelMapper.map(ownerDto, OwnerEntity.class);
    }
}
