package com.example.spring.react.job;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    private String name;
    private String companyDescription;
    private String contactEmail;
    private String contactPhone;
}
