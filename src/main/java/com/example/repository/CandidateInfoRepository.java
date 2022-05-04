package com.example.repository;

import com.example.entities.CandidateInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateInfoRepository extends JpaRepository<CandidateInfo, Integer> {
}
