package com.tomasz.vet.services.impl;

import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.repositories.AppointmentRepository;
import com.tomasz.vet.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<Appointment> findOne(Long id) {
        return appointmentRepository.findById(id);
    }
}
