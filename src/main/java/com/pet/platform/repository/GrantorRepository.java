package com.pet.platform.repository;

import com.pet.platform.entity.Grantor;
import com.pet.platform.entity.Signal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrantorRepository extends JpaRepository<Grantor, Long> {
}
