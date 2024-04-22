package com.example.spring.react.job;

import jakarta.persistence.Embedded;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }
    private Long id;
    private String title;
    private String type;
    private String description;
    private String location;
    private String salary;
    @Embedded
    private Company company;
    public JobResponse createJob(JobRequest jobRequest) {

        Job job = Job.builder()
                .title(jobRequest.title())
                .type(jobRequest.type())
                .description(jobRequest.description())
                .location(jobRequest.location())
                .salary(jobRequest.salary())
                .company(jobRequest.company())
                .build();

        jobRepository.save(job);

        JobResponse jobResponse = new JobResponse(
                job.getId(),
                job.getTitle(),
                job.getType(),
                job.getDescription(),
                job.getLocation(),
                job.getSalary(),
                job.getCompany()
        );
        return jobResponse;
    }

    public List<JobResponse> fetchAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobResponse> jobsList = jobs
                .stream()
                .map(job -> new JobResponse(
                        job.getId(),
                        job.getTitle(),
                        job.getType(),
                        job.getDescription(),
                        job.getLocation(),
                        job.getSalary(),
                        job.getCompany()
                )).toList();

        return jobsList;
    }

    public JobResponse fetchJobById(Long jobId) {
        Optional<Job> job = jobRepository.findById(jobId);
        if(job.isEmpty()){
            throw new RuntimeException("Job was not found");
        }
        JobResponse jobResponse = new JobResponse(
                job.get().getId(),
                job.get().getTitle(),
                job.get().getType(),
                job.get().getDescription(),
                job.get().getLocation(),
                job.get().getSalary(),
                job.get().getCompany()
        );
        return jobResponse;
    }

    public JobResponse updateJob(JobRequest jobRequest) {
        Optional<Job> job = jobRepository.findById(jobRequest.id());
        if(job.isEmpty()){
            throw new RuntimeException("No Job found");
        }

        Job updatedJob = Job.builder()
                .id(jobRequest.id())
                .title(jobRequest.title())
                .type(jobRequest.type())
                .description(jobRequest.description())
                .location(jobRequest.location())
                .salary(jobRequest.salary())
                .company(jobRequest.company())
                .build();

        jobRepository.save(updatedJob);

        JobResponse updatedJobResponse = new JobResponse(
                updatedJob.getId(),
                updatedJob.getTitle(),
                updatedJob.getType(),
                updatedJob.getDescription(),
                updatedJob.getLocation(),
                updatedJob.getSalary(),
                updatedJob.getCompany()
        );
        return updatedJobResponse;
    }

    public void deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
    }
}
