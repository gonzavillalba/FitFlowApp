package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.Stagnation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StagnationRepository extends JpaRepository<Stagnation, Long> {
}
