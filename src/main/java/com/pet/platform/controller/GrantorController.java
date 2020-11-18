package com.pet.platform.controller;

import com.pet.platform.entity.Grantor;
import com.pet.platform.service.GrantorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1/grantors")
public class GrantorController {

    private final GrantorService grantorService;

    @GetMapping
    public ResponseEntity<?> get() {
        return new ResponseEntity<>(grantorService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Grantor grantorRequestModel) {
        return new ResponseEntity<>(grantorService.save(grantorRequestModel), HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<?> create(@PathVariable String id) {
        return new ResponseEntity<>(grantorService.update(Long.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete( @PathVariable String id) {
        return new ResponseEntity<>(grantorService.remove(Long.valueOf(id)), HttpStatus.OK);
    }
}
