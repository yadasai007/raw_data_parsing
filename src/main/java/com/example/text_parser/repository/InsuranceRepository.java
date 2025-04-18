package com.example.text_parser.repository;

import com.example.text_parser.model.InsuranceData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceData, Long> {
	InsuranceData findByClaimOcc(String claimNumber);
}
