package com.example.LoggerPipeline.controller;

import com.example.LoggerPipeline.model.LogEntry;
import com.example.LoggerPipeline.model.Severity;
import com.example.LoggerPipeline.repository.LogRepository;
import com.example.LoggerPipeline.service.LogService;
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
    public LogEntry createLog(@RequestBody LogRequest request) {
        return logService.saveLog(
                request.getMessage(),
                request.getSeverity(),
                request.getUserId()
        );
    }

    @GetMapping
    public List<LogEntry> getAllLogs() {
        return logService.getAllLogs();
    }

    @GetMapping("/severity/{severity}")
    public List<LogEntry> getLogsBySeverity(@PathVariable Severity severity) {
        return logService.getLogsBySeverity(severity);
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
