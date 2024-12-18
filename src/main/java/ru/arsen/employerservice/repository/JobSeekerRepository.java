package ru.arsen.employerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.arsen.employerservice.model.JobSeeker;


@Repository
public interface JobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

    JobSeeker findByEmail(String email);
}
