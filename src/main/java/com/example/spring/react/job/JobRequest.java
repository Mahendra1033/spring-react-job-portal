package com.example.spring.react.job;

import jakarta.persistence.Embedded;

public record JobRequest(
        Long id,
        String title,
        String type,
        String description,
        String location,
        String salary,
        Company company
) {
}
