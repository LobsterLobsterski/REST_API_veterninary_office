package com.tomasz.vet.services;

import com.tomasz.vet.entities.Appointment;

import java.util.Optional;

public interface AppointmentService {
    Appointment create(Appointment appointment);

    Optional<Appointment> findOne(Long id);
}
