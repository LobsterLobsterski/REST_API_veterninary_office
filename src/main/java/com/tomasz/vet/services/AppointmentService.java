package com.tomasz.vet.services;

import com.tomasz.vet.entities.Appointment;
import org.springframework.stereotype.Service;

@Service
public interface AppointmentService {
    Appointment create(Appointment appointment);
}
