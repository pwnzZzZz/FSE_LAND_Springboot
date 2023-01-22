package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.services.StudentenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//Spring-MVC Controller, der durch die Thymeleafintegration auch mit Thymeleaftemplates arbeitet
@Controller
@RequestMapping("/web/v1/studenten")
public class StudentThymeleafController {

    private StudentenService studentenService;

    //Konstruktorinjektion -> autowired
    public StudentThymeleafController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }

    @GetMapping
    public String gibAlleStudenten(Model model){
        model.addAttribute("allStudents", this.studentenService.alleStudenten());
        return "allestudenten"; //templatename ohne .html
    }

}
