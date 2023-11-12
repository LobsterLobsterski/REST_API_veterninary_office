package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.domain.dto.IllnessDto;
import com.tomasz.vet.domain.entities.IllnessEntity;
import com.tomasz.vet.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
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
