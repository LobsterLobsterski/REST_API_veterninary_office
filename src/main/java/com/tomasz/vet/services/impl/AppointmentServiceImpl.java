package com.tomasz.vet.services.impl;

import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.repositories.AppointmentRepository;
import com.tomasz.vet.services.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        if (!appointmentRepository.existsById(id)){
            return Optional.empty();
        }
        return appointmentRepository.findById(id);
    }

    @Override
    public Page<Appointment> findAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }
}
