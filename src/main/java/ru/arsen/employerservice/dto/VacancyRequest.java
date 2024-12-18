package ru.arsen.employerservice.dto;

import java.math.BigDecimal;

public record VacancyRequest (
        String positionName,
        String requirements,
        BigDecimal salary,
        String description,
        Integer employerId
){
}
