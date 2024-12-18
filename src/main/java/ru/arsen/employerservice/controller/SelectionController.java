package ru.arsen.employerservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.arsen.employerservice.model.Selection;
import ru.arsen.employerservice.repository.SelectionRepository;
import ru.arsen.employerservice.service.SelectionService;

import java.util.List;

@RestController
@RequestMapping("/api/selection")

public class SelectionController {

    private final SelectionService selectionService;
    private final SelectionRepository selectionRepository;

    @Autowired
    public SelectionController(SelectionService selectionService, SelectionRepository selectionRepository) {
        this.selectionService = selectionService;
        this.selectionRepository = selectionRepository;
    }

    @GetMapping()
    public List<Selection> selectVacancy() {
        selectionRepository.deleteAll();
        selectionService.selectVacancy();
        return selectionRepository.findAll();
    }

    @GetMapping("/all")
    public List<Selection> selectAll() {
        return selectionRepository.findAll();
    }
}
