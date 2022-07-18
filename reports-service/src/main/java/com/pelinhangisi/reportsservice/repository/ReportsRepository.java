package com.pelinhangisi.reportsservice.repository;

import com.pelinhangisi.reportsservice.entity.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, String> {
}
