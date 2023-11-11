package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.domain.dto.BillDto;
import com.tomasz.vet.domain.entities.BillEntity;
import com.tomasz.vet.mappers.Mapper;
import org.modelmapper.ModelMapper;


public class BillMapper implements Mapper<BillEntity, BillDto> {

    private final ModelMapper modelMapper;

    public BillMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BillDto mapTo(BillEntity billEntity) {
        return modelMapper.map(billEntity, BillDto.class);
    }

    @Override
    public BillEntity mapFrom(BillDto billDto) {
        return modelMapper.map(billDto, BillEntity.class);
    }
}
