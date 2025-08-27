package com.example.LoggerPipeline.repository;

import com.example.LoggerPipeline.model.LogEntry;
import com.example.LoggerPipeline.model.Severity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntry,Long> {
    Page<LogEntry> findBySeverity(Severity severity, Pageable pageable); // Spring auto-implements this based on method name
    Page<LogEntry> findByUserId(String userId, Pageable pageable);
}
