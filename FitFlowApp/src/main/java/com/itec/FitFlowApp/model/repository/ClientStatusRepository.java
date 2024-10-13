package com.itec.FitFlowApp.model.repository;

import com.itec.FitFlowApp.model.entity.ClientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStatusRepository extends JpaRepository<ClientStatus, Long> {
}
