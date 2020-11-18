package com.pet.platform.controller;

import com.pet.platform.entity.Signal;
import com.pet.platform.service.SignalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/signals")
public class SignalController {

    private final SignalService signalService;

    @GetMapping
    public ResponseEntity<?> get() {
        return new ResponseEntity<>(signalService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Signal signalRequestModel) {
        return new ResponseEntity<>(signalService.save(signalRequestModel), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> create(@PathVariable String id) {
        return new ResponseEntity<>(signalService.update(Long.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete( @PathVariable String id) {
        return new ResponseEntity<>(signalService.remove(Long.valueOf(id)), HttpStatus.OK);
    }
}
