package com.tomasz.vet.controllers;

import com.tomasz.vet.domain.dto.BillDto;
import com.tomasz.vet.domain.entities.BillEntity;
import com.tomasz.vet.mappers.impl.BillMapper;
import com.tomasz.vet.services.BillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BillController {

    private final BillService billService;
    private final BillMapper billMapper;

    public BillController(BillService billService, BillMapper billMapper) {
        this.billService = billService;
        this.billMapper = billMapper;
    }

    @PostMapping("/bills")
    public ResponseEntity<BillDto> createBill(@RequestBody BillDto billDto){
        BillEntity billEntity = billMapper.mapFrom(billDto);
        BillEntity saved = billService.create(billEntity);

        return new ResponseEntity<>(billMapper.mapTo(saved), HttpStatus.CREATED);
    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<BillDto> findOneBill(@PathVariable Long id){
        Optional<BillEntity> result = billService.findOne(id);
        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billMapper.mapTo(result.get()), HttpStatus.OK);
    }
}
