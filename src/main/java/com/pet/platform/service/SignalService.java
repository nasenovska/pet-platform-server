package com.pet.platform.service;

import com.pet.platform.entity.Signal;
import com.pet.platform.repository.SignalRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignalService {

    private final SignalRepository signalRepository;

    public List<Signal> findAll() {
        return signalRepository.findAll();
    }

    public Signal find(Long id) {
        return Optional.of(signalRepository.findById(id)).orElse(null).get();
    }

    public Signal save(Signal signal) {
        return signalRepository.saveAndFlush(signal);
    }

    public Signal update(Signal signal) {
        return signalRepository.save(signal);
    }

    public Signal update(Long id) {

        Signal result = Optional.of(signalRepository.findById(id)).orElse(null).get();
        if (result == null) {
            log.error("Signal with id {} is not found", id);
            return null;
        }

        return signalRepository.save(result);
    }

    public boolean remove(Long id) {
        try {
            signalRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("An error occurred while deleting Signal with id {}", id, e);
            return false;
        }
    }
}
