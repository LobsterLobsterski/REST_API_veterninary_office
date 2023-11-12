package com.tomasz.vet.controllers;

import com.tomasz.vet.domain.dto.BillDto;
import com.tomasz.vet.domain.entities.BillEntity;
import com.tomasz.vet.mappers.impl.BillMapper;
import com.tomasz.vet.services.BillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/bills")
    public Page<BillDto> findAllBills(Pageable pageable){
        return billService.findAll(pageable).map(billMapper::mapTo);
    }

    @PutMapping("/bills/{id}")
    public ResponseEntity<BillDto> fullUpdateBill(@PathVariable Long id, @RequestBody BillDto billDto){
        BillEntity billEntity = billMapper.mapFrom(billDto);
        Optional<BillEntity> result = billService.fullUpdate(id, billEntity);
        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billMapper.mapTo(result.get()), HttpStatus.OK);

    }

    @PatchMapping("/bills/{id}")
    public ResponseEntity<BillDto> partialUpdateBill(@PathVariable Long id, @RequestBody BillDto billDto){
        BillEntity billEntity = billMapper.mapFrom(billDto);
        Optional<BillEntity> result = billService.partialUpdate(id, billEntity);

        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billMapper.mapTo(result.get()), HttpStatus.OK);
    }

    @DeleteMapping("/bills/{id}")
    public void deleteBill(@PathVariable Long id){
        billService.delete(id);
    }
}
