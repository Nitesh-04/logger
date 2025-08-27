package com.example.LoggerPipeline.service;

import com.example.LoggerPipeline.model.LogEntry;
import com.example.LoggerPipeline.model.Severity;
import com.example.LoggerPipeline.repository.LogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LogService {
    private final LogRepository logRepository;

    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public LogEntry saveLog(String message, Severity severity, String userId){
        LogEntry logEntry = new LogEntry(message,severity,userId);
        logEntry.setTimestamp(LocalDateTime.now());
        return logRepository.save(logEntry);
    }

    public Page<LogEntry> getAllLogs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        return logRepository.findAll(pageable);
    }

    public Page<LogEntry> getLogsBySeverity(Severity severity, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        return logRepository.findBySeverity(severity, pageable);
    }

    public Page<LogEntry> getLogsByUserId(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("timestamp").descending());
        return logRepository.findByUserId(userId, pageable);
    }


}
