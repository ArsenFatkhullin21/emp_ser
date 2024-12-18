package ru.arsen.employerservice.controller;



import jakarta.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.arsen.employerservice.model.Selection;
import ru.arsen.employerservice.service.SelectionService;
import ru.arsen.employerservice.service.SendEmailService;

@RestController
@RequestMapping("/api")
public class EmailController {

    private final SendEmailService sendEmailService;

    private final SelectionService selectionService;

    @Autowired
    public EmailController(SendEmailService sendEmailService, SelectionService selectionService) {
        this.sendEmailService = sendEmailService;

        this.selectionService = selectionService;
    }

    @GetMapping("sendEmail/{email}")
    public String sendEmail(@PathVariable String email) throws MessagingException {



        Selection sel = selectionService.findByEmail(email);


        String name = sel.getJobSeekerName();

        String vacancy = sel.getVacancyName();

        String jobSeekerId = String.valueOf(sel.getId());

        String acceptUrl = "http://localhost:8081/interview/accept?jobSeekerId=" + jobSeekerId;
        String declineUrl = "http://localhost:8081/interview/decline?jobSeekerId=" + jobSeekerId;


        sendEmailService.sendEmail(email,"Приглашение на собеседование", name, vacancy, acceptUrl, declineUrl);
        return "success";
    }

}

