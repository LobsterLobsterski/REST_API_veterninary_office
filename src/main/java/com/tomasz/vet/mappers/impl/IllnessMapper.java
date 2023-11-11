package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.BillDto;
import com.tomasz.vet.dto.IllnessDto;
import com.tomasz.vet.entities.BillEntity;
import com.tomasz.vet.entities.IllnessEntity;
import com.tomasz.vet.mappers.Mapper;
import com.tomasz.vet.services.IllnessService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

public class IllnessMapper implements Mapper<IllnessEntity, IllnessDto> {

    private final ModelMapper modelMapper;

    public IllnessMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public IllnessDto mapTo(IllnessEntity illnessEntity) {
        return modelMapper.map(illnessEntity, IllnessDto.class);
    }

    @Override
    public IllnessEntity mapFrom(IllnessDto illnessDto) {
        return modelMapper.map(illnessDto, IllnessEntity.class);
    }
}
