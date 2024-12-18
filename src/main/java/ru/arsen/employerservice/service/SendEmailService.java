package ru.arsen.employerservice.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SendEmailService {

    private final JavaMailSender javaMailSender;




    @Value("$(spring.mail.username)")
    private String fromEmailId;

    @Autowired
    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(String to, String subject, String name, String vacancy, String acceptUrl, String declineUrl) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        LocalDate data = LocalDate.now();
        data = data.plusDays(4);
        String htmlComponent =  "<h3>Уважаемый(ая) " + name + ",</h3>" +
                "<p>Вы приглашены на собеседование на должность <strong>"+ vacancy+"</strong>, которое состоится <strong>" + data.toString() + "</strong>.</p>" +
                "<p>Пожалуйста, подтвердите или отклоните участие:</p>" +
                "<a href='" + acceptUrl + "' style='margin-right: 10px; padding: 10px 15px; color: white; background-color: green; text-decoration: none;'>Принять</a>" +
                "<a href='" + declineUrl + "' style='padding: 10px 15px; color: white; background-color: red; text-decoration: none;'>Отклонить</a>" +
                "<p>С уважением,<br>Команда Бюро по трудоустройству</p>";

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlComponent, true);
        helper.setFrom(fromEmailId);
        javaMailSender.send(mimeMessage);

    }

//    public void sendEmail(String to, String subject, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(to);
//        message.setSubject(subject);
//        message.setText(content);
//        message.setFrom(fromEmailId);
//        javaMailSender.send(message);
//    }
}
