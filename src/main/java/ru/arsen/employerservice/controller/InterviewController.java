package ru.arsen.employerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.arsen.employerservice.model.JobSeeker;
import ru.arsen.employerservice.model.Selection;
import ru.arsen.employerservice.service.SelectionService;

@RestController
public class InterviewController {

    private final SelectionService selectionService;

    @Autowired
    public InterviewController(SelectionService selectionService) {
        this.selectionService = selectionService;
    }


    @GetMapping("/interview/accept")
    public String acceptInterview(@RequestParam String jobSeekerId) {
        Selection jobSeeker = selectionService.getById(jobSeekerId);
        jobSeeker.setAccepted(true);
        selectionService.save(jobSeeker);
        return "accepted";
    }

    @GetMapping("/interview/decline")
    public String declineInterview(@RequestParam String jobSeekerId) {
        Selection jobSeeker = selectionService.getById(jobSeekerId);
        jobSeeker.setAccepted(false);
        selectionService.save(jobSeeker);
        return "decline";
    }
}
