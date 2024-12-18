//package ru.arsen.employerservice.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import ru.arsen.employerservice.service.PdfGenerationService;
//
//@RestController
//@RequestMapping("/api")
//public class PdfGenerationController {
//
//    private final PdfGenerationService pdfGenerationService;
//
//    @Autowired
//    public PdfGenerationController(PdfGenerationService pdfGenerationService) {
//        this.pdfGenerationService = pdfGenerationService;
//    }
//
//    @GetMapping("/generate")
//    public void generatePdf(@RequestParam String vacancy, @RequestParam String name) {
//        pdfGenerationService.generatePdf(vacancy, name);
//    }
//}
