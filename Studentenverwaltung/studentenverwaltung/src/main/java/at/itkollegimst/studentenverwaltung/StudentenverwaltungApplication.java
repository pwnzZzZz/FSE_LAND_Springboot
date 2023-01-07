package at.itkollegimst.studentenverwaltung;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.repositories.StudentJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentenverwaltungApplication implements ApplicationRunner {

	//@Autowired: dependency injection Mechanismus von Spring Boot
	//Injeziert in die studentJPARepo-Variable ein entsprechendes Objekt vom Typ StudenTJPARepo
	//das den vollen Datenbankzugriff ermöglicht
	//Es müssen keine Objekte mehr mit new erstellt werden!
	@Autowired
	StudentJPARepo studentJPARepo;


	public static void main(String[] args) {
		SpringApplication.run(StudentenverwaltungApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		//Zur Laufzeit injezierte Implementierung
		//Standardmethoden des Repositories können verwendet werden, e.g. save
		this.studentJPARepo.save(new Student("Marcel Schranz", "6471"));
		this.studentJPARepo.save(new Student("Günter Hasel", "6460"));
		this.studentJPARepo.save(new Student("Maria Brunsteiner", "8080"));
	}
}
