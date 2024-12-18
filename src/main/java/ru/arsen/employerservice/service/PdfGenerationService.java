//package ru.arsen.employerservice.service;
//
//
//import com.itextpdf.kernel.font.PdfFontFactory;
//import com.itextpdf.kernel.pdf.PdfDocument;
//import com.itextpdf.kernel.pdf.PdfWriter;
//import com.itextpdf.layout.Document;
//import com.itextpdf.layout.element.Paragraph;
//import org.springframework.stereotype.Service;
//
//import java.io.FileOutputStream;
//import java.time.LocalDate;
//
//@Service
//public class PdfGenerationService {
//
//    public void generatePdf(String vacancy, String name){
//        String outputFilePath = "contract.pdf";
//
//        // Заполнение шаблона данных
//        String documentNumber = "12345";
//        LocalDate now = LocalDate.now();
//        String date =  now.toString();
//        String employerName = "ООО «Пример»";
//        String employerActivity = vacancy;
//
//        String applicantName = name;
//        String applicantQualification = "Специалист";
//        String applicantProfession = "Программист";
//
//        String agencyName = "Бюро по трудоустройству «Работа»";
//        String agencyAddress = "г. Москва, ул. Карьерная, 10";
//        String agencyPhone = "+7 (987) 654-32-10";
//
//        String paymentConditions = "по договоренности";
//        String startDate = now.toString();
//        String commissionRate = "10% от заработной платы";
//        String commissionPaymentTerm = "в течение 10 рабочих дней";
//        int notificationDays = 5;
//
//        try {
//            // Путь к файлу шрифта (например, Arial)
//            String fontPath = "/System/Library/Fonts/Supplemental/Arial.ttf";  // Путь для macOS, проверьте его точность
//
//            // Создание документа PDF
//            PdfWriter writer = new PdfWriter(new FileOutputStream(outputFilePath));
//            PdfDocument pdf = new PdfDocument(writer);
//            Document document = new Document(pdf);
//
//            // Создание шрифта с поддержкой кириллицы
//            // Здесь мы указываем кодировку BaseFont.IDENTITY_H, чтобы поддерживать кириллицу
//            com.itextpdf.kernel.font.PdfFont font = PdfFontFactory.createFont(fontPath);
//
//            // Добавление текста в документ с использованием шрифта
//            document.setFont(font);
//
//            document.add(new Paragraph("ДОГОВОР О СОТРУДНИЧЕСТВЕ № " + documentNumber));
//            document.add(new Paragraph("Дата составления: " + date));
//            document.add(new Paragraph(" "));
//            document.add(new Paragraph("Работодатель: " + employerName + ", вид деятельности: " + employerActivity));
//            document.add(new Paragraph("в дальнейшем именуемый «Работодатель», с одной стороны, и Соискатель: " + applicantName + ", квалификация: " + applicantQualification + ", профессия: " + applicantProfession ));
//            document.add(new Paragraph("заключили настоящий договор о сотрудничестве через Бюро по трудоустройству, которое представляет собой организацию " + agencyName + ", адрес: " + agencyAddress + ", телефон: " + agencyPhone + ", в дальнейшем именуемое «Бюро», на следующих условиях:"));
//            document.add(new Paragraph(" "));
//            document.add(new Paragraph("1. Условия трудоустройства"));
//            document.add(new Paragraph("Соискатель трудоустраивается на должность: " + vacancy + ". Работодатель обязуется предоставить Соискателю все условия для выполнения работы на указанной должности. Оплата труда: " + paymentConditions + ". Работодатель принимает Соискателя на работу с " + startDate + "."));
//            document.add(new Paragraph(" "));
//            document.add(new Paragraph("2. Комиссионные Бюро"));
//            document.add(new Paragraph("В случае успешного трудоустройства Соискателя, Работодатель обязуется выплатить Бюро комиссионные в размере " + commissionRate + ". Комиссионные выплачиваются в срок " + commissionPaymentTerm + ", начиная с момента выхода Соискателя на работу."));
//            document.add(new Paragraph(" "));
//            document.add(new Paragraph("3. Ответственность сторон"));
//            document.add(new Paragraph("В случае отказа от трудоустройства со стороны Работодателя или Соискателя после заключения договора, стороны обязаны уведомить друг друга за " + notificationDays + " дней. В случае нарушения условий договора любая из сторон имеет право расторгнуть договор, уведомив об этом за " + notificationDays + " дней."));
//            document.add(new Paragraph(" "));
//            document.add(new Paragraph("4. Подписи сторон"));
//            document.add(new Paragraph("Работодатель: _______________ / [Ф.И.О.]"));
//            document.add(new Paragraph("Соискатель: _______________ / [Ф.И.О.]"));
//            document.add(new Paragraph("Бюро по трудоустройству: _______________ / [Ф.И.О. представителя]"));
//
//            // Закрытие документа
//            document.close();
//
//            System.out.println("PDF создан успешно!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//}
