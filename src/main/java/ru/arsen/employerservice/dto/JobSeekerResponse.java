package ru.arsen.employerservice.dto;

import java.time.LocalDateTime;

public record JobSeekerResponse(
        Integer id,
        String name,
        String profession,
        String skills,
        String email,
        String phone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
