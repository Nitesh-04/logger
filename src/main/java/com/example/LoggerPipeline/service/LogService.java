package com.example.LoggerPipeline.service;

import com.example.LoggerPipeline.model.LogEntry;
import com.example.LoggerPipeline.model.Severity;
import com.example.LoggerPipeline.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<LogEntry> getAllLogs() {
        return logRepository.findAll();
    }

    public List<LogEntry> getLogsBySeverity(Severity severity) {
        return logRepository.findBySeverity(severity);
    }


}
