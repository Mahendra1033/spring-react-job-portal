package com.example.spring.react.job;

public record JobResponse(
        Long id,
        String name,
        String description,
        String location,
        String salary
) {
}
