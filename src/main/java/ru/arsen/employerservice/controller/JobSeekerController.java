package ru.arsen.employerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arsen.employerservice.dto.JobSeekerRequest;
import ru.arsen.employerservice.dto.JobSeekerResponse;
import ru.arsen.employerservice.service.JobSeekerService;

import java.util.List;

@RestController
@RequestMapping("/api/jobseeker")

public class JobSeekerController {


    private final JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping
    public ResponseEntity<List<JobSeekerResponse>> findAll() {
        return new ResponseEntity<>(jobSeekerService.findAllJobSeekers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<JobSeekerResponse> createJobSeeker(@RequestBody JobSeekerRequest jobSeekerRequest) {
        JobSeekerResponse jobSeekerResponse = jobSeekerService.saveJobSeeker(jobSeekerRequest);
        return new ResponseEntity<>(jobSeekerResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobSeekerResponse> findById(@PathVariable Integer id) {
        return new ResponseEntity<>(jobSeekerService.findJobSeekerById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JobSeekerResponse> updateJobSeeker(@PathVariable Integer id, @RequestBody JobSeekerRequest jobSeekerRequest) {
        return new ResponseEntity<>(jobSeekerService.updateJobSeeker(id, jobSeekerRequest),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteJobSeeker(@PathVariable Integer id) {
        jobSeekerService.deleteJobSeekerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
