package com.pet.platform.service;

import com.pet.platform.entity.Grantor;
import com.pet.platform.repository.GrantorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class GrantorService {

    private final GrantorRepository grantorRepository;

    public List<Grantor> findAll() {
        return grantorRepository.findAll();
    }

    public Grantor save(Grantor grantor) {
        return grantorRepository.saveAndFlush(grantor);
    }

    public Grantor update(Grantor grantor) {
        return grantorRepository.save(grantor);
    }

    public Grantor update(Long id) {

        Grantor result = Optional.of(grantorRepository.findById(id)).orElse(null).get();
        if (result == null) {
            log.error("Grantor with id {} is not found", id);
            return null;
        }

        return grantorRepository.save(result);
    }

    public boolean remove(Long id) {
        try {
            grantorRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            log.error("An error occurred while deleting Grantor with id {}", id, e);
            return false;
        }
    }
}
