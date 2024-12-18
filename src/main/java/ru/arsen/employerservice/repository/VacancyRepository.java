package ru.arsen.employerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.arsen.employerservice.model.Vacancy;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {
}
