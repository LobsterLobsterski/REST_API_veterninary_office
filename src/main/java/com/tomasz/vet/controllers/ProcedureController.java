package com.tomasz.vet.controllers;

import com.tomasz.vet.domain.dto.ProcedureDto;
import com.tomasz.vet.domain.entities.ProcedureEntity;
import com.tomasz.vet.mappers.impl.ProcedureMapper;
import com.tomasz.vet.services.ProcedureService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProcedureController {

    private final ProcedureService procedureService;
    private final ProcedureMapper procedureMapper;

    public ProcedureController(ProcedureService procedureService, ProcedureMapper procedureMapper) {
        this.procedureService = procedureService;
        this.procedureMapper = procedureMapper;
    }

    @PostMapping("/procedure")
    public ResponseEntity<ProcedureDto> createProcedure(@RequestBody ProcedureDto procedureDto){
        ProcedureEntity procedureEntity = procedureMapper.mapFrom(procedureDto);
        ProcedureEntity saved = procedureService.create(procedureEntity);

        return new ResponseEntity<>(procedureMapper.mapTo(saved), HttpStatus.CREATED);
    }

    @GetMapping("/procedure")
    public Page<ProcedureDto> getAllProcedures(Pageable pageable){
        Page<ProcedureEntity> page = procedureService.findAll(pageable);

        return page.map(procedureMapper::mapTo);
    }

    @GetMapping("/procedure/{id}")
    public ResponseEntity<ProcedureDto> getOneProcedure(@PathVariable Long id){
        Optional<ProcedureEntity> result = procedureService.findOne(id);

        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity<>(procedureMapper.mapTo(result.get()), HttpStatus.OK);
    }

    @PutMapping("/procedure/{id}")
    public ResponseEntity<ProcedureDto> fullUpdateProcedure(@PathVariable Long id, @RequestBody ProcedureDto procedureDto){
        ProcedureEntity procedureEntity = procedureMapper.mapFrom(procedureDto);
        Optional<ProcedureEntity> result = procedureService.fullUpdate(id, procedureEntity);

        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(procedureMapper.mapTo(result.get()), HttpStatus.OK);
    }

}
