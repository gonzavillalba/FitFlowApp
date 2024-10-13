package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.TrainingDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingDiaryRepository extends JpaRepository<TrainingDiary, Long> {
}
