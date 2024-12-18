package ru.arsen.employerservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VacancyResponse(
        Integer id,
        String positionName,
        String requirements,
        BigDecimal salary,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String employerName
) {
}
