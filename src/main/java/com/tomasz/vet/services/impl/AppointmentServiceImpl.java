package com.tomasz.vet.services.impl;

import com.tomasz.vet.entities.AppointmentEntity;
import com.tomasz.vet.repositories.AppointmentRepository;
import com.tomasz.vet.services.AppointmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.StreamSupport;


@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentEntity create(AppointmentEntity appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Optional<AppointmentEntity> findOne(Long id) {
        if (!appointmentRepository.existsById(id)){
            return Optional.empty();
        }
        return appointmentRepository.findById(id);
    }

    @Override
    public Page<AppointmentEntity> findAll(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }

    @Override
    public Optional<AppointmentEntity> fullUpdate(Long id, AppointmentEntity appointmentEntity) {
        if (!appointmentRepository.existsById(id)){
            return Optional.empty();
        }
        appointmentEntity.setId(id);
        return Optional.of(appointmentRepository.save(appointmentEntity));
    }

    @Override
    public Optional<AppointmentEntity> partialUpdate(Long id, AppointmentEntity appointment) {
        if (!appointmentRepository.existsById(id)){
            return Optional.empty();
        }
        appointment.setId(id);

        //get the existing entity, check if the passed dtos attribute is present and if so overwrite the
        //existing entities attribute
        return appointmentRepository.findById(id).map(existing -> {
            Optional.ofNullable(appointment.getRegistrationDate()).ifPresent(existing::setRegistrationDate);
            Optional.ofNullable(appointment.getAppointmentDate()).ifPresent(existing::setAppointmentDate);
            Optional.ofNullable(appointment.getPet()).ifPresent(existing::setPet);
            Optional.ofNullable(appointment.getVeterinarian()).ifPresent(existing::setVeterinarian);
            return appointmentRepository.save(existing);
        });
    }
}
