package com.example.LoggerPipeline.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    @Enumerated(EnumType.STRING)
    public Severity severity;

    private LocalDateTime timestamp;

    private String userId;

    public LogEntry() {}

    public LogEntry(String message, Severity severity, String userId) {
        this.message = message;
        this.severity = severity;
        this.timestamp = LocalDateTime.now();
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
