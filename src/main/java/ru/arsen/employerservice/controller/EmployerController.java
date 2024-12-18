package ru.arsen.employerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arsen.employerservice.dto.EmployerRequest;
import ru.arsen.employerservice.dto.EmployerResponse;
import ru.arsen.employerservice.model.Employer;
import ru.arsen.employerservice.service.EmployerService;

import java.util.List;

@RestController
@RequestMapping("/api/employers")

public class EmployerController {

    private final EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping
    public ResponseEntity<List<EmployerResponse>> getAllEmployers() {
        return new ResponseEntity<>(employerService.getAllEmployers(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employer> createEmployer(@RequestBody EmployerRequest employerRequest) {
        Employer createdEmployer = employerService.saveEmployer(employerRequest);
        return new ResponseEntity<>(createdEmployer, HttpStatus.CREATED);

    }
}
