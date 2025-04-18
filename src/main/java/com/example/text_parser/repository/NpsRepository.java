package com.example.text_parser.repository;

import com.example.text_parser.model.NpsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NpsRepository extends JpaRepository<NpsData, Integer> {
}