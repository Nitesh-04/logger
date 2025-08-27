package com.example.LoggerPipeline.controller;

import com.example.LoggerPipeline.model.LogEntry;
import com.example.LoggerPipeline.model.Severity;
import com.example.LoggerPipeline.repository.LogRepository;
import com.example.LoggerPipeline.service.LogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping
    public ResponseEntity<LogEntry> createLog(@RequestBody LogRequest request) {
        LogEntry saved = logService.saveLog(
                request.getMessage(),
                request.getSeverity(),
                request.getUserId()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/severity/{severity}")
    public List<LogEntry> getLogsBySeverity(@PathVariable Severity severity) {
        return logService.getLogsBySeverity(severity);
    }

    @GetMapping("/user/{userId}")
    public List<LogEntry> getLogsByUserId(@PathVariable String userId) {
        return logService.getLogsByUserId(userId);
    }

    public static class LogRequest {
        private String message;
        private Severity severity;
        private String userId;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Severity getSeverity() {
            return severity;
        }

        public void setSeverity(Severity severity) {
            this.severity = severity;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }

}
