package com.recruitment.agency.demo;

import com.recruitment.agency.demo.model.Address;
import com.recruitment.agency.demo.model.ContactDetails;
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
import java.util.function.Function;

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
        this.mockDataGenerator().forEach(person -> {
            personRepository.save(person);
			log.info("Finished saving person: " + person.toString());
        });
    }

    private List<Person> mockDataGenerator() {
        final int max_size = 10;

        final String[] NAMES = "Armand,Olivia,Eunice,Gabriele,Luanne,Jada,Kia,Trina,Michiko,Ned,Marcela,Dorian,Phillis,Cara,Chia,Gillian,Mercedes,Adina,Annamarie,Rigoberto,Lenore,Ramon,Eve,Dacia,Michaele,Mayra,Colton,Rubie,Clarence,Gerri,Bethann,Charlette,Vada,Yvette,Duncan,Katheryn,Aletha,Zada,Wm,Ileana,Thaddeus,Nancey,Gwyneth,Loria,Hye,Leota,Ai,Heath,Demetrius,Alexia".split("\\,");
        final String[] SURNAMES = "Estes,Perkins,Blair,White,Preston,Green,Delgado,Ellis,Snow,Day,Watson,Shannon,Schroeder,Harrington,Estrada,Andersen,Sheppard,Harvey,Villanueva,Holt,Baxter,Bradshaw,Baker,Frederick,Osborne,Orr,Munoz,Thomas,Burnett,Gutierrez,Gregory,Collier,Montes,Taylor,Jacobson,Livingston,Valdez,Robles,Erickson,Callahan".split("\\,");
        final String[] PREFIXES = {"Street", "Avenue", "Boulevard"};
        final String[] CITIES = "Alexandra,Johannesburg,Lenasia,Midrand,Roodepoort,Sandton,Soweto,Mshongo,Klipfontienview,Orange Farm,Alberton,Germiston,Benoni,Boksburg,Brakpan,Clayville,Daveyton,Devon,Duduza,Edenvale,Ennerdale,Germiston,Impumelelo,Isando,Katlehong,Kempton Park,KwaThema,Nigel,Olifantsfontein,Reiger Park,Springs,Tembisa,Thokoza,Tsakane,Vosloorus,Wattville,Atteridgeville,Bronberg,Bronkhorstspruit,Centurion,Cullinan,Ekangala,Ga-Rankuwa,Hammanskraal,Irene,Mabopane,Mamelodi,Pretoria,Rayton,Refilwe,Soshanguve,Zithobeni,Boipatong,Bophelong,Evaton,Sebokeng,Sharpeville,Vanderbijlpark,Vereeniging".split("\\,");
        final String[] MAIL_SERVER = {"gmail", "hotmail", "yahoo"};

        Random random = new Random();

        Function<String[], String> selectItemRandomly = (arr) -> arr[random.nextInt(arr.length)];

        List<Person> listOfPeople = new ArrayList<>(max_size);

        for (int i = 0; i < max_size; i++) {
            String street =
                    String.format("%d. %s %s", 10 + random.nextInt(89), selectItemRandomly.apply(NAMES), selectItemRandomly.apply(PREFIXES));

            Person person =
                    Person.builder()
                            .name(selectItemRandomly.apply(NAMES))
                            .middleName(selectItemRandomly.apply(NAMES))
                            .surname(selectItemRandomly.apply(SURNAMES))
                            .birthDate(LocalDate.now().minusYears(random.nextInt(50)))
                            .build();

            Address postalAddress = new Address();
            postalAddress.setStreet(street);
			postalAddress.setCity(selectItemRandomly.apply(CITIES));
			postalAddress.setPostalCode(String.valueOf(1000 + random.nextInt(8999)));

            ContactDetails contactDetails = new ContactDetails();
			contactDetails.setPhysicalAddress(postalAddress);
			contactDetails.setEmail(String.format("%s.%s@%s.com", person.getName(), person.getSurname(), selectItemRandomly.apply(MAIL_SERVER)));
			contactDetails.setMobilePhone(
                                    String.format("0%d-%d-%d",
                                            10 + random.nextInt(89),
                                            100 + random.nextInt(899),
                                            1000 + random.nextInt(8999)));

            person.setContactDetails(contactDetails);

            listOfPeople.add(person);
        }

        return listOfPeople;
    }

}
