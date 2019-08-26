package com.recruitment.agency.demo;

import com.recruitment.agency.demo.model.Person;
import com.recruitment.agency.demo.services.PersonRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@Log
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person =
				Person.builder()
						.name("Letlhogonolo")
						.surname("Segoe")
						.birthDate(LocalDate.of(1985, Month.MARCH,18))
						.build();
		personRepository.save(person);
		log.info("Finished saving person: "+person.toString());
	}

	private List<Person> mockDataGenerator() {
		final int max_size = 1000;
		String[] NAMES = "Armand,Olivia,Eunice,Gabriele,Luanne,Jada,Kia,Trina,Michiko,Ned,Marcela,Dorian,Phillis,Cara,Chia,Gillian,Mercedes,Adina,Annamarie,Rigoberto,Lenore,Ramon,Eve,Dacia,Michaele,Mayra,Colton,Rubie,Clarence,Gerri,Bethann,Charlette,Vada,Yvette,Duncan,Katheryn,Aletha,Zada,Wm,Ileana,Thaddeus,Nancey,Gwyneth,Loria,Hye,Leota,Ai,Heath,Demetrius,Alexia".split("\\,");
		String[] SURNAMES = "Estes,Perkins,Blair,White,Preston,Green,Delgado,Ellis,Snow,Day,Watson,Shannon,Schroeder,Harrington,Estrada,Andersen,Sheppard,Harvey,Villanueva,Holt,Baxter,Bradshaw,Baker,Frederick,Osborne,Orr,Munoz,Thomas,Burnett,Gutierrez,Gregory,Collier,Montes,Taylor,Jacobson,Livingston,Valdez,Robles,Erickson,Callahan".split("\\,");

		List<Person> listOfPeople = new ArrayList<>(max_size);
		Random random = new Random();
		for (int i=0;i<max_size;i++) {
			Person person =
					Person.builder()
					.name(NAMES[random.nextInt(NAMES.length)])
					.surname(SURNAMES[random.nextInt(SURNAMES.length)])
					.birthDate(LocalDate.now().minusYears(random.nextInt(50)))
					.build();
			listOfPeople.add(person);
		}
		return listOfPeople;
	}
}
