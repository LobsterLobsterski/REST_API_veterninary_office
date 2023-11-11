package com.tomasz.vet.controllers;

import com.tomasz.vet.domain.dto.AppointmentDto;
import com.tomasz.vet.domain.entities.AppointmentEntity;
import com.tomasz.vet.mappers.impl.AppointmentMapper;
import com.tomasz.vet.services.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        AppointmentEntity appointment = appointmentMapper.mapFrom(appointmentDto);
        AppointmentEntity saved = appointmentService.create(appointment);

        return new ResponseEntity<>(appointmentMapper.mapTo(saved), HttpStatus.CREATED);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> getOneAppointment(@PathVariable Long id){
        Optional<AppointmentEntity> result = appointmentService.findOne(id);
        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointmentMapper.mapTo(result.get()), HttpStatus.OK);
    }

    @GetMapping("/appointment")
    public Page<AppointmentDto> getAllAppointments(Pageable pageable){
        Page<AppointmentEntity> result = appointmentService.findAll(pageable);

        return result.map(appointmentMapper::mapTo);
    }

    @PutMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> fullUpdateAppointment(@RequestBody AppointmentDto appointmentDto, @PathVariable Long id){
        AppointmentEntity appointmentEntity = appointmentMapper.mapFrom(appointmentDto);
        Optional<AppointmentEntity> updated = appointmentService.fullUpdate(id, appointmentEntity);

        if(updated.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointmentMapper.mapTo(updated.get()), HttpStatus.OK);

    }

    @PatchMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> partialUpdateAppointment(@RequestBody AppointmentDto appointmentDto, @PathVariable Long id){
        AppointmentEntity appointment = appointmentMapper.mapFrom(appointmentDto);
        Optional<AppointmentEntity> result = appointmentService.partialUpdate(id, appointment);
        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(appointmentMapper.mapTo(result.get()), HttpStatus.OK);
    }

    @DeleteMapping("/appointment/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentService.delete(id);
    }
}
