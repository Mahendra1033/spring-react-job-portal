package com.example.spring.react.job;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/add")
    public JobResponse createJob(@RequestBody JobRequest jobRequest){
        return jobService.createJob(jobRequest);
    }

    @GetMapping
    public List<JobResponse> fetchAllJobs(){
        return jobService.fetchAllJobs();
    }

    @GetMapping(path = "/{id}")
    public JobResponse fetchJobById(@PathVariable("id") Long jobId){
        return jobService.fetchJobById(jobId);
    }

    @PutMapping("/update")
    public JobResponse updateJob(@RequestBody JobRequest jobRequest){
        return jobService.updateJob(jobRequest);
    }

    @DeleteMapping("{id}")
    public void deleteJob(@PathVariable("id") Long jobId){
        jobService.deleteJob(jobId);
    }

}
