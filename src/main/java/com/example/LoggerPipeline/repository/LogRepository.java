package com.example.LoggerPipeline.repository;

import com.example.LoggerPipeline.model.LogEntry;
import com.example.LoggerPipeline.model.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<LogEntry,Long> {
    List<LogEntry> findBySeverity(Severity severity); // Spring auto-implements this based on method name
    List<LogEntry> findByUserId(String userId);
}
