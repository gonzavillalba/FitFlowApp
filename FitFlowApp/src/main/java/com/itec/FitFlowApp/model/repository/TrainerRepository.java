package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {
    Optional<Trainer> findByDni(String dni);
}
