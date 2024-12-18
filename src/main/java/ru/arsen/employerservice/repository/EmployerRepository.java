package ru.arsen.employerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.arsen.employerservice.model.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Integer> {
}
