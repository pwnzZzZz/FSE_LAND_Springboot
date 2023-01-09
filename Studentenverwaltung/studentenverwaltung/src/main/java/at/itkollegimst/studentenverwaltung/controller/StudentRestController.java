package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.itkollegimst.studentenverwaltung.exceptions.StudentValidierungFehlgeschlagen;
import at.itkollegimst.studentenverwaltung.services.StudentenService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;

//SpringBoot Framework WEB
//Für die Kommunikation mit einer REST-API
//REST-Controller -> alle Methoden haben einen HTTP-Response Body (default JSON-Format)
@RestController
//Das @RequestMapping gilt für alle Methoden ohne weitere URL-Angabe
@RequestMapping("/api/v1/studenten")
public class StudentRestController {

    private StudentenService studentenService;

    public StudentRestController(StudentenService studentenService) {
        this.studentenService = studentenService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> gibAlleStudenten(){
        //.ok -> HTTP 200
        //Aus den Objekten wird JSON generiert
        return ResponseEntity.ok(this.studentenService.gibAlleStudenten());
    }


    @PostMapping
    //@RequestBody -> generiert aus dem HTTP-POST-Request ein Student-Objekt
    //wenn entsprechende Daten als JSON mitgegeben werden

    public ResponseEntity<Student> studentEinfuegen(@Valid @RequestBody Student student, BindingResult bindingResult) throws StudentValidierungFehlgeschlagen {
        String errors = "";
        if(bindingResult.hasErrors()){
            for(ObjectError error : bindingResult.getAllErrors()){
                errors += "\nValidierungsfehler für Objekt " + error.getObjectName() +
                        " im Feld " + ((FieldError)error).getField() + " mit folgendem Problem: " +
                        error.getDefaultMessage();
            }
            throw new StudentValidierungFehlgeschlagen(errors);
        } else {
            return ResponseEntity.ok(this.studentenService.studentEinfuegen(student));
        }
    }

    @DeleteMapping("/{id}")
    //
    public String studentLoeschen(@PathVariable Long id){
        this.studentenService.studentLoeschenMitId(id);
        return "Student gelöscht!";
    }


    @GetMapping("/mitplz/{plz}")
    public ResponseEntity<List<Student>> alleStudentenMitPLZ(@PathVariable String plz){
        return ResponseEntity.ok(this.studentenService.alleStudentenMitPlz(plz));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> studentMitId(@PathVariable Long id) throws StudentNichtGefunden {
        return ResponseEntity.ok(this.studentenService.studentMitId(id));
    }

}
