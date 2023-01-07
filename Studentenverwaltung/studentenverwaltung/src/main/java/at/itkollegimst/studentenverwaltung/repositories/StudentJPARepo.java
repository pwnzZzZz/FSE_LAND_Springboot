package at.itkollegimst.studentenverwaltung.repositories;

import at.itkollegimst.studentenverwaltung.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Ermöglicht den angenehmen Datenbankzugriff über den ORM (Objektrelationalen Mapper) Hibernate JPA
 */
@Repository
public interface StudentJPARepo extends JpaRepository<Student, Long> {
    //Spring Boot Syntax für Methoden, über die konkrete Implementierungen generiert werden (e.g. find...)
    List<Student> findAllByPlz(String plz);
}
