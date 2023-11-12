package com.tomasz.vet.services.impl;

import com.tomasz.vet.domain.entities.BillEntity;
import com.tomasz.vet.repositories.BillRepository;
import com.tomasz.vet.services.BillService;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {

    private final BillRepository billRepository;

    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public BillEntity create(BillEntity billEntity) {
        return billRepository.save(billEntity);
    }
}
