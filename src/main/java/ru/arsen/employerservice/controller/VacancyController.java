package ru.arsen.employerservice.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arsen.employerservice.dto.VacancyRequest;
import ru.arsen.employerservice.dto.VacancyResponse;
import ru.arsen.employerservice.model.Vacancy;
import ru.arsen.employerservice.service.VacancyService;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")

public class VacancyController {

    private final VacancyService vacancyService;

    @Autowired
    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping
    public ResponseEntity<List<VacancyResponse>> getAllVacancies() {
        return new ResponseEntity<>(vacancyService.findAllVacancies(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VacancyResponse> createVacancy(@RequestBody VacancyRequest vacancyRequest) {
        VacancyResponse vacancyResponse = vacancyService.save(vacancyRequest);
        return new ResponseEntity<>(vacancyResponse, HttpStatus.CREATED);
    }
}
