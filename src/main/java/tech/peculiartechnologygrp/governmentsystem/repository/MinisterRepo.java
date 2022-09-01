package tech.peculiartechnologygrp.governmentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.peculiartechnologygrp.governmentsystem.model.Minister;

import java.util.Optional;


public interface MinisterRepo extends JpaRepository<Minister, Long> {
    void deleteMinisterById(Long id);
    Optional<Minister> findMinisterById(Long id);
}
