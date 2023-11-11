package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.PetDto;
import com.tomasz.vet.entities.PetEntity;
import com.tomasz.vet.mappers.Mapper;
import com.tomasz.vet.services.PetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


public class PetMapper implements Mapper<PetEntity, PetDto> {

    private final ModelMapper modelMapper;

    public PetMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public PetDto mapTo(PetEntity petEntity) {
        return modelMapper.map(petEntity, PetDto.class);
    }

    @Override
    public PetEntity mapFrom(PetDto petDto) {
        return modelMapper.map(petDto, PetEntity.class);
    }
}
