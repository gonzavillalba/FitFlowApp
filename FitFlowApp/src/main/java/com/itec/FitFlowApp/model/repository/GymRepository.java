package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GymRepository extends JpaRepository<Gym, Long> {
    Optional<Gym> findByGymCode(String GymCode);


}
