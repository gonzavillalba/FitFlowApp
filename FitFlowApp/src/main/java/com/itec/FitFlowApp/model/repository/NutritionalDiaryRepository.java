package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.NutritionalDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NutritionalDiaryRepository extends JpaRepository<NutritionalDiary, Long> {
}
