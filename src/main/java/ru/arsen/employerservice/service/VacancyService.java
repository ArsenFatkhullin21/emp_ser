package ru.arsen.employerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arsen.employerservice.dto.VacancyRequest;
import ru.arsen.employerservice.dto.VacancyResponse;
import ru.arsen.employerservice.model.Employer;
import ru.arsen.employerservice.model.Vacancy;
import ru.arsen.employerservice.repository.EmployerRepository;
import ru.arsen.employerservice.repository.VacancyRepository;

import java.util.List;

@Service

@Transactional(readOnly = true)
public class VacancyService {

    private final VacancyRepository vacancyRepository;
    private final EmployerRepository employerRepository;

    @Autowired
    public VacancyService(VacancyRepository vacancyRepository, EmployerRepository employerRepository) {
        this.vacancyRepository = vacancyRepository;
        this.employerRepository = employerRepository;
    }


    public List<VacancyResponse> findAllVacancies() {
        return vacancyRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private VacancyResponse mapToResponse(Vacancy vacancy) {
        Employer employer = employerRepository.findById(vacancy.getEmployer().getId())
                .orElseThrow(() -> new IllegalArgumentException("Работодатель не найден"));
        return new VacancyResponse(
                vacancy.getId(),
                vacancy.getPositionName(),
                vacancy.getRequirements(),
                vacancy.getSalary(),
                vacancy.getDescription(),
                vacancy.getCreatedAt(),
                vacancy.getUpdatedAt(),
                employer.getName()
        );
    }

    public VacancyResponse findVacancyById(Integer id) {
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Вакансия не найден"));
        return mapToResponse(vacancy);
    }

    @Transactional
    public VacancyResponse save(VacancyRequest vacancyRequest) {
        Employer employer = employerRepository.findById(vacancyRequest.employerId())
                .orElseThrow(() -> new IllegalArgumentException("Работодатель не найден"));

        Vacancy vacancy = new Vacancy();

        vacancy.setPositionName(vacancyRequest.positionName());
        vacancy.setRequirements(vacancyRequest.requirements());
        vacancy.setSalary(vacancyRequest.salary());
        vacancy.setDescription(vacancyRequest.description());
        vacancy.setEmployer(employer);

        Vacancy savedVacancy = vacancyRepository.save(vacancy);

        return new VacancyResponse(
                savedVacancy.getId(),
                savedVacancy.getPositionName(),
                savedVacancy.getRequirements(),
                savedVacancy.getSalary(),
                savedVacancy.getDescription(),
                savedVacancy.getCreatedAt(),
                savedVacancy.getUpdatedAt(),
                employer.getName()
        );
    }



}
