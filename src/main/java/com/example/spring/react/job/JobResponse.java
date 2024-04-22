package com.example.spring.react.job;

public record JobResponse(
        Long id,
        String title,
        String type,
        String description,
        String location,
        String salary,
        Company company
) {
}
