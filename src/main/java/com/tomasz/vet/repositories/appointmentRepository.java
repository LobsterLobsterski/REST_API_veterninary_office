package com.tomasz.vet.repositories;

import com.tomasz.vet.entities.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface appointmentRepository extends CrudRepository<Appointment, Long> {
}
