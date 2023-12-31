package com.tomasz.vet.services;

import com.tomasz.vet.domain.entities.AppointmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AppointmentService {
    AppointmentEntity create(AppointmentEntity appointment);

    Optional<AppointmentEntity> findOne(Long id);

    Page<AppointmentEntity> findAll(Pageable pageable);

    Optional<AppointmentEntity> fullUpdate(Long id, AppointmentEntity appointmentEntity);

    Optional<AppointmentEntity> partialUpdate(Long id, AppointmentEntity appointment);

    void delete(Long id);
}
