package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.Foot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootRepository extends JpaRepository<Foot, Long> {
    Foot findByName(String name);
}
