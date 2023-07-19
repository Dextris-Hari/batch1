package com.dextris.repository;

import com.dextris.entity.LeaveReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveReportRepository extends JpaRepository<LeaveReport, String> {
}
