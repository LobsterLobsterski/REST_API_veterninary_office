package com.tomasz.vet.controllers;

import com.tomasz.vet.dto.AppointmentDto;
import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.mappers.impl.AppointmentMapper;
import com.tomasz.vet.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    private AppointmentService appointmentService;
    private AppointmentMapper appointmentMapper;

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

    @GetMapping("/appointment")
    public R
}
