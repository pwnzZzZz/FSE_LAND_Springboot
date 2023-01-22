package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.services.StudentenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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

    @GetMapping("/insert")
    public String studentenEinfuegenFormular(Model model){
        Student student = new Student();
        //Dem template wird ein leeres Studentenobjekt hinzugefügt,
        //und geben es zur Befüllung an das Thymeleaf Frontend
        model.addAttribute("student", student);
        return "studenteneinfuegen";
    }

    @PostMapping("/insert")
    public String studentenEinfuegen(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "studenteneinfuegen";
        } else {
            this.studentenService.studentEinfuegen(student);
            return "redirect:/web/v1/studenten";
        }
    }




}
