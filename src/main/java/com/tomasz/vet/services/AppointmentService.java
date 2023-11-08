package com.tomasz.vet.services;

import com.tomasz.vet.entities.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AppointmentService {
    Appointment create(Appointment appointment);

    Optional<Appointment> findOne(Long id);

    Page<Appointment> findAll(Pageable pageable);
}
