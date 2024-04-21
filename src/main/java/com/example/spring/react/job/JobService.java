package com.example.spring.react.job;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public JobResponse createJob(JobRequest jobRequest) {
        Job job = Job.builder()
                .name(jobRequest.name())
                .description(jobRequest.description())
                .location(jobRequest.location())
                .salary(jobRequest.salary())
                .build();
        jobRepository.save(job);

        JobResponse jobResponse = new JobResponse(
                job.getId(),
                job.getName(),
                job.getDescription(),
                job.getLocation(),
                job.getSalary()
        );
        return jobResponse;
    }

    public List<JobResponse> fetchAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        List<JobResponse> jobsList = jobs
                .stream()
                .map(job -> new JobResponse(
                        job.getId(),
                        job.getName(),
                        job.getDescription(),
                        job.getLocation(),
                        job.getSalary()
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
                job.get().getName(),
                job.get().getDescription(),
                job.get().getLocation(),
                job.get().getSalary()
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
                .name(jobRequest.name())
                .description(jobRequest.description())
                .location(jobRequest.location())
                .salary(jobRequest.salary())
                .build();

        jobRepository.save(updatedJob);

        JobResponse updatedJobResponse = new JobResponse(
                updatedJob.getId(),
                updatedJob.getName(),
                updatedJob.getDescription(),
                updatedJob.getLocation(),
                updatedJob.getSalary()
        );
        return updatedJobResponse;
    }

    public String deleteJob(Long jobId) {
        jobRepository.deleteById(jobId);
        return "Job with the id "+jobId+" is deleted";
    }
}
