package com.example.spring.react.job;

public record JobRequest(
        Long id,
        String name,
        String description,
        String location,
        String salary
) {
}
