package ru.arsen.employerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.arsen.employerservice.model.Selection;

@Repository
public interface SelectionRepository extends JpaRepository<Selection, Long> {

    Selection findByJobSeekerEmail(String email);
}
