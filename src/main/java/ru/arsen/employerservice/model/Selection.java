package ru.arsen.employerservice.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;


@Entity
@Table(name = "selection")
public class Selection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long vacancyId;
    private String vacancyName;
    private long jobSeekerId;
    private String jobSeekerName;
    private String jobSeekerEmail;
    private Boolean accepted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(long vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getVacancyName() {
        return vacancyName;
    }

    public void setVacancyName(String vacancyName) {
        this.vacancyName = vacancyName;
    }

    public long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }

    public String getJobSeekerName() {
        return jobSeekerName;
    }

    public void setJobSeekerName(String jobSeekerName) {
        this.jobSeekerName = jobSeekerName;
    }

    public String getJobSeekerEmail() {
        return jobSeekerEmail;
    }

    public void setJobSeekerEmail(String jobSeekerEmail) {
        this.jobSeekerEmail = jobSeekerEmail;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Selection() {
    }

    public Selection(Long id, long vacancyId, String vacancyName, long jobSeekerId, String jobSeekerName, String jobSeekerEmail, Boolean accepted) {
        this.id = id;
        this.vacancyId = vacancyId;
        this.vacancyName = vacancyName;
        this.jobSeekerId = jobSeekerId;
        this.jobSeekerName = jobSeekerName;
        this.jobSeekerEmail = jobSeekerEmail;
        this.accepted = accepted;
    }
}
