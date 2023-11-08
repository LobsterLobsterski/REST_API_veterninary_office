package com.tomasz.vet.controllers;

import com.tomasz.vet.dto.AppointmentDto;
import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.mappers.impl.AppointmentMapper;
import com.tomasz.vet.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final AppointmentMapper appointmentMapper;

    public AppointmentController(AppointmentService appointmentService, AppointmentMapper appointmentMapper) {
        this.appointmentService = appointmentService;
        this.appointmentMapper = appointmentMapper;
    }

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDto> createAppointment(@RequestBody AppointmentDto appointmentDto){
        Appointment appointment = appointmentMapper.mapFrom(appointmentDto);
        Appointment saved = appointmentService.create(appointment);

        return new ResponseEntity<>(appointmentMapper.mapTo(saved), HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> getOneAppointment(@PathVariable Long id){
        Optional<Appointment> result = appointmentService.findOne(id);
        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointmentMapper.mapTo(result.get()), HttpStatus.OK);
    }
}
