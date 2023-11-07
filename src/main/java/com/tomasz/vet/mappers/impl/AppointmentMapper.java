package com.tomasz.vet.mappers.impl;

import com.tomasz.vet.dto.AppointmentDto;
import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper implements Mapper<Appointment, AppointmentDto> {

    private final ModelMapper modelMapper;

    public AppointmentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AppointmentDto mapTo(Appointment appointment) {
        return modelMapper.map(appointment, AppointmentDto.class);
    }

    @Override
    public Appointment mapFrom(AppointmentDto appointmentDto) {
        return modelMapper.map(appointmentDto, Appointment.class);
    }
}
