package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

//@Component: Hierdurch kann ein entsprechendes Objekt von SpringBoot
//erzeugt und zurückgegeben werden
@Component
public class DbZugriffStudentenJPA implements  DbZugriffStudenten{

    @Autowired
    private StudentJPARepo studentJPARepo;


    public DbZugriffStudentenJPA(StudentJPARepo studentJPARepo) {
        this.studentJPARepo = studentJPARepo;
    }

    @Override
    public Student studentSpeichern(Student student) {
        return this.studentJPARepo.save(student);
    }

    @Override
    public List<Student> alleStudenten() {
        return this.studentJPARepo.findAll();
    }

    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return this.studentJPARepo.findAllByPlz(plz);
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        Optional<Student> optStudent = this.studentJPARepo.findById(id);
        //Überprüft ob im Optional ein Student-Objekt ist
        if(optStudent.isPresent()){
            return optStudent.get();
        }else{
            throw new StudentNichtGefunden("Student mit der Id " + id + " nicht gefunden!");
        }

    }

    @Override
    public void studentLoeschenMitId(Long id) {

    }
}
