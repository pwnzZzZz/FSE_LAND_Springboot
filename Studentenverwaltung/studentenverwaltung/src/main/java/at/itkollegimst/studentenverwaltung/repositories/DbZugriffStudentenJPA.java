package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import org.springframework.stereotype.Component;

import java.util.List;

//hierdurch kann ein entsprechendes Objekt erzeugt
//und zurückgegeben werden
@Component
public class DbZugriffStudentenImpl implements  DbZugriffStudenten{

    @Override
    public Student studentSpeichern(Student student) {
        return null;
    }

    @Override
    public List<Student> alleStudenten() {
        return null;
    }

    @Override
    public List<Student> alleStudentenAusDemOrt(String plz) {
        return null;
    }

    @Override
    public Student studentMitId(Long id) throws StudentNichtGefunden {
        return null;
    }

    @Override
    public void studentLoeschenMitId(Long id) {

    }
}
