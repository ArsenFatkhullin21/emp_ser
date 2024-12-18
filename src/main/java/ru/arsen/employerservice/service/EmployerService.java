package ru.arsen.employerservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arsen.employerservice.dto.EmployerRequest;
import ru.arsen.employerservice.dto.EmployerResponse;
import ru.arsen.employerservice.model.Employer;
import ru.arsen.employerservice.repository.EmployerRepository;

import java.util.List;

@Service

@Transactional(readOnly = true)
public class EmployerService {


    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<EmployerResponse> getAllEmployers() {
        return employerRepository.findAll()
                .stream().map(this::mapToResponse)
                .toList();
    }

    private EmployerResponse mapToResponse(Employer employer) {

        return new EmployerResponse(
                employer.getId(),
                employer.getName(),
                employer.getActivityType(),
                employer.getEmail()
        );

    }

    public Employer getEmployerById(Integer id) {
        return employerRepository.findById(id).orElse(null);
    }

    @Transactional
    public Employer saveEmployer(EmployerRequest employerRequest) {
        Employer employer = new Employer();
        employer.setName(employerRequest.name());
        employer.setEmail(employerRequest.email());
        employer.setActivityType(employerRequest.activityType());
        return employerRepository.save(employer);
    }

    @Transactional
    public void updateEmployer(Integer id, Employer employer) {
        employer.setId(id);
        employerRepository.save(employer);
    }

    @Transactional
    public void deleteEmployer(Integer id) {
        employerRepository.deleteById(id);
    }
}
