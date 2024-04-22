package com.example.spring.react.job;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "job")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Job {

    @Id
    @SequenceGenerator(
            name = "job_sequence",
            sequenceName = "job_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "job_sequence",
            strategy = SEQUENCE
    )
    private Long id;
    private String title;
    private String type;
    private String description;
    private String location;
    private String salary;
    @Embedded
    private Company company;

}
