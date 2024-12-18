package ru.arsen.employerservice.dto;

import java.util.List;

public record EmployerRequest(
        String name,
        String activityType,
        String email,
        List<VacancyResponse> vacancies
) {
}
