package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.NutritionalPlan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionalPlanRepository extends JpaRepository<NutritionalPlan, Long> {
    NutritionalPlan findByNutCode(String nutCode);
}
