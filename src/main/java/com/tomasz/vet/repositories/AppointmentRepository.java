package com.tomasz.vet.repositories;

import com.tomasz.vet.entities.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long>,
        PagingAndSortingRepository<AppointmentEntity, Long> {
}
