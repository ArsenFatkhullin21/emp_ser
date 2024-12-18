package ru.arsen.employerservice.service;

import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arsen.employerservice.dto.JobSeekerRequest;
import ru.arsen.employerservice.dto.JobSeekerResponse;
import ru.arsen.employerservice.model.JobSeeker;
import ru.arsen.employerservice.repository.JobSeekerRepository;


import java.util.List;

@Service

@Transactional(readOnly = true)
public class JobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;

    @Autowired
    public JobSeekerService(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }


    public List<JobSeekerResponse> findAllJobSeekers() {
        return jobSeekerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }



    public JobSeekerResponse findJobSeekerById(Integer id) {
         JobSeeker jobSeeker = jobSeekerRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("JobSeeker not found"));
         return mapToResponse(jobSeeker);
    }

    public JobSeekerResponse findByEmail(String email) {
        JobSeeker jobSeeker = jobSeekerRepository.findByEmail(email);
        return mapToResponse(jobSeeker);
    }


    @Transactional
    public JobSeekerResponse saveJobSeeker(JobSeekerRequest jobSeekerRequest) {
        JobSeeker jobSeeker = new JobSeeker();
        return getJobSeekerResponse(jobSeekerRequest, jobSeeker);
    }

    @NotNull
    private JobSeekerResponse getJobSeekerResponse(JobSeekerRequest jobSeekerRequest, JobSeeker jobSeeker) {
        jobSeeker.setName(jobSeekerRequest.name());
        jobSeeker.setProfession(jobSeekerRequest.profession());
        jobSeeker.setSkills(jobSeekerRequest.skills());
        jobSeeker.setEmail(jobSeekerRequest.email());
        jobSeeker.setPhone(jobSeekerRequest.phone());

        jobSeekerRepository.save(jobSeeker);
        return mapToResponse(jobSeeker);
    }

    @Transactional
    public JobSeekerResponse updateJobSeeker(Integer id,JobSeekerRequest request) {
        JobSeeker jobSeeker = jobSeekerRepository.findById(id).orElseThrow(() -> new RuntimeException("JobSeeker not found"));

        return getJobSeekerResponse(request, jobSeeker);

    }

    @Transactional
    public void deleteJobSeekerById(Integer id) {
        jobSeekerRepository.deleteById(id);
    }


    private JobSeekerResponse mapToResponse(JobSeeker jobSeeker) {
        return new JobSeekerResponse(
                jobSeeker.getId(),
                jobSeeker.getName(),
                jobSeeker.getProfession(),
                jobSeeker.getSkills(),
                jobSeeker.getEmail(),
                jobSeeker.getPhone(),
                jobSeeker.getCreatedAt(),
                jobSeeker.getUpdatedAt()
        );
    }
}
