package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.domain.dto.OwnerDto;
import com.tomasz.vet.domain.entities.OwnerEntity;
import com.tomasz.vet.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
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
