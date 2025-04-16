package com.example.text_parser.repository;

import com.example.text_parser.model.InsuranceData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<InsuranceData, Long> {
}
