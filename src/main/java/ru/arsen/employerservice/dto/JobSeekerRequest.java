package ru.arsen.employerservice.dto;

public record JobSeekerRequest(
        String name,
        String profession,
        String skills,
        String email,
        String phone
) {
}
