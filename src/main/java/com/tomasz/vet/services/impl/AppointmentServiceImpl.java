package com.tomasz.vet.services.impl;

import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.repositories.appointmentRepository;
import com.tomasz.vet.services.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService {

    private final appointmentRepository appointmentRepository;

    public AppointmentServiceImpl(com.tomasz.vet.repositories.appointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }
}
