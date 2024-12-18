package ru.arsen.employerservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.arsen.employerservice.dto.JobSeekerResponse;
import ru.arsen.employerservice.dto.VacancyResponse;
import ru.arsen.employerservice.model.Selection;
import ru.arsen.employerservice.repository.SelectionRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional(readOnly = true)

public class SelectionService {

    private final JobSeekerService jobSeekerService;
    private final VacancyService vacancyService;
    private final SelectionRepository selectionRepository;

    @Autowired
    public SelectionService(JobSeekerService jobSeekerService, VacancyService vacancyService, SelectionRepository selectionRepository) {
        this.jobSeekerService = jobSeekerService;
        this.vacancyService = vacancyService;
        this.selectionRepository = selectionRepository;
    }


    public Selection findByEmail(String email) {
        return selectionRepository.findByJobSeekerEmail(email);
    }

    @Transactional
    public void seter(int id1, int id2){





        Selection selection = new Selection();


        selection.setVacancyId(id1);
        selection.setVacancyName(vacancyService.findVacancyById(id1).positionName());

        selection.setJobSeekerId(id2);
        selection.setJobSeekerName(jobSeekerService.findJobSeekerById(id2).name());
        selection.setJobSeekerEmail(jobSeekerService.findJobSeekerById(id2).email());

        selectionRepository.save(selection);
    }

    @Transactional
    public void selectVacancy() {
        // Получение списка соискателей и вакансий
        List<JobSeekerResponse> jobSeekerResponseList = jobSeekerService.findAllJobSeekers();
        List<VacancyResponse> vacancyResponseList = vacancyService.findAllVacancies();
        double prosent= 0.1;
        for (VacancyResponse vacancyResponse : vacancyResponseList) {
            // Извлечение требований вакансии
            String[] requirementsArray = vacancyResponse.requirements().split(" ");
            Set<String> requirementsSet = new HashSet<>(Arrays.asList(requirementsArray));
            int countRequirements = requirementsSet.size();

            double bestMatchPercentage = 0;
            int bestJobSeekerId = 0;

            for (JobSeekerResponse jobSeekerResponse : jobSeekerResponseList) {
                // Извлечение навыков соискателя
                String[] skillsArray = jobSeekerResponse.skills().split(" ");
                Set<String> skillsSet = new HashSet<>(Arrays.asList(skillsArray));

                // Вычисление количества совпадающих требований
                Set<String> intersection = new HashSet<>(requirementsSet);
                intersection.retainAll(skillsSet);
                int matchingSkillsCount = intersection.size();

                // Рассчет процента совпадений
                double matchPercentage = (double) matchingSkillsCount / (double) countRequirements;
                if (matchPercentage >= prosent) {
                    // Сравнение и сохранение лучшего совпадения
                    if (matchPercentage > bestMatchPercentage) {
                        bestMatchPercentage = matchPercentage;
                        bestJobSeekerId = jobSeekerResponse.id();
                    }
                }
            }
            if (bestJobSeekerId!=0) {

                // Установка соответствия вакансии и соискателя
                seter(vacancyResponse.id(), bestJobSeekerId);
            }
        }
    }

    public Selection getById(String jobSeekerId) {
        Selection jobSeeker = selectionRepository.findById(Long.valueOf(jobSeekerId))
                .orElseThrow(() -> new RuntimeException("JobSeeker not found"));;
        return jobSeeker;
    }

    @Transactional
    public void save(Selection jobSeeker) {
        selectionRepository.save(jobSeeker);
    }
}
