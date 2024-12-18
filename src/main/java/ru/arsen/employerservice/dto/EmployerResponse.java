package ru.arsen.employerservice.dto;

import ru.arsen.employerservice.model.Employer;
import ru.arsen.employerservice.model.Vacancy;

import java.util.List;

public record EmployerResponse (
        Integer id,
        String name,
        String activityType,
        String email


){
}
