package com.example.LoggerPipeline.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public List<String> health(){
        return Arrays.asList("status: UP", "version: 1.0.0");
    }
}
