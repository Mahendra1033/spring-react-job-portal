package com.example.spring.react;

import com.example.spring.react.job.Company;
import com.example.spring.react.job.Job;
import com.example.spring.react.job.JobRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    @Autowired
    private JobRepository jobRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void addData() {
        List<Job> addJobs = Arrays.asList(
                new Job(
                        1L,
                        "Senior React Developer",
                        "Full-Time",
                        "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
                        "Boston, MA",
                        "$70K - $80K",
                        new Company(
                                "NewTek Solutions",
                                "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
                                "contact@teksolutions.com",
                                "555-555-5555"
                        )
                ),

                new Job(
                        2L,
                        "React Developer",
                        "Full-Time",
                        "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
                        "Dallas, MA",
                        "$60K - $80K",
                        new Company(
                                "Virtusa Solutions",
                                "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
                                "contact@teksolutions.com",
                                "555-555-5555"
                        )
                ),

                new Job(
                        3L,
                        "React.Js Developer",
                        "Full-Time",
                        "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
                        "New York, NY",
                        "$70K - $80K",
                        new Company(
                                "NewTek Solutions",
                                "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
                                "contact@teksolutions.com",
                                "555-555-5555"
                        )
                ),

                new Job(
                        4L,
                        "Full stack React Developer",
                        "Full-Time",
                        "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
                        "New Jersey, MA",
                        "$50K - $60K",
                        new Company(
                                "NewTek Solutions",
                                "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
                                "contact@teksolutions.com",
                                "555-555-5555"
                        )
                ),

                new Job(
                        5L,
                        "React Native Developer",
                        "Part-Time",
                        "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
                        "Boston, MA",
                        "$70K - $80K",
                        new Company(
                                "NewTek Solutions",
                                "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
                                "contact@teksolutions.com",
                                "555-555-5555"
                        )
                ),

                new Job(
                        6L,
                        "Junior React Developer",
                        "Part-Time",
                        "We are seeking a talented Front-End Developer to join our team in Boston, MA. The ideal candidate will have strong skills in HTML, CSS, and JavaScript, with experience working with modern JavaScript frameworks such as React or Angular.",
                        "Boston, MA",
                        "$40K - $45K",
                        new Company(
                                "NewTek Solutions",
                                "NewTek Solutions is a leading technology company specializing in web development and digital solutions. We pride ourselves on delivering high-quality products and services to our clients while fostering a collaborative and innovative work environment.",
                                "contact@teksolutions.com",
                                "555-555-5555"
                        )
                )
        );

        jobRepository.saveAll(addJobs);

    }

}
