package com.recruitment.agency.demo;

import com.recruitment.agency.demo.model.Address;
import com.recruitment.agency.demo.model.ContactDetails;
import com.recruitment.agency.demo.model.Education;
import com.recruitment.agency.demo.model.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class DataGenerator {
    private final static String[] NAMES = "Armand,Olivia,Eunice,Gabriele,Luanne,Jada,Kia,Trina,Michiko,Ned,Marcela,Dorian,Phillis,Cara,Chia,Gillian,Mercedes,Adina,Annamarie,Rigoberto,Lenore,Ramon,Eve,Dacia,Michaele,Mayra,Colton,Rubie,Clarence,Gerri,Bethann,Charlette,Vada,Yvette,Duncan,Katheryn,Aletha,Zada,Wm,Ileana,Thaddeus,Nancey,Gwyneth,Loria,Hye,Leota,Ai,Heath,Demetrius,Alexia".split("\\,");
    private final static String[] SURNAMES = "Estes,Perkins,Blair,White,Preston,Green,Delgado,Ellis,Snow,Day,Watson,Shannon,Schroeder,Harrington,Estrada,Andersen,Sheppard,Harvey,Villanueva,Holt,Baxter,Bradshaw,Baker,Frederick,Osborne,Orr,Munoz,Thomas,Burnett,Gutierrez,Gregory,Collier,Montes,Taylor,Jacobson,Livingston,Valdez,Robles,Erickson,Callahan".split("\\,");
    private final static String[] PREFIXES = {"Street", "Avenue", "Boulevard"};
    private final static String[] GENDER = {"Male","Female","Other"};
    private final static String[] PROVINCES = {"Gauteng","North-West","Western Cape","Eastern Cape","Northern Cape","Limpopo","Mpumalanga"};
    private final static String[] CITIES = "Alexandra,Johannesburg,Lenasia,Midrand,Roodepoort,Sandton,Soweto,Mshongo,Klipfontienview,Orange Farm,Alberton,Germiston,Benoni,Boksburg,Brakpan,Clayville,Daveyton,Devon,Duduza,Edenvale,Ennerdale,Germiston,Impumelelo,Isando,Katlehong,Kempton Park,KwaThema,Nigel,Olifantsfontein,Reiger Park,Springs,Tembisa,Thokoza,Tsakane,Vosloorus,Wattville,Atteridgeville,Bronberg,Bronkhorstspruit,Centurion,Cullinan,Ekangala,Ga-Rankuwa,Hammanskraal,Irene,Mabopane,Mamelodi,Pretoria,Rayton,Refilwe,Soshanguve,Zithobeni,Boipatong,Bophelong,Evaton,Sebokeng,Sharpeville,Vanderbijlpark,Vereeniging".split("\\,");
    private final static String[] SUBURBS = "Dog,Puppy,Turtle,Rabbit,Parrot,Cat,Kitten,Goldfish,Mouse,Tropical fish,Hamster".split("\\,");
    private final static String[] MAIL_SERVER = {"gmail", "hotmail", "yahoo"};
    private final static String[] INSTITUTION = {"Wits","UJ","UP","TUT","UNISA","Curro High","NWU"};
    private final static String[] TYPE = {"Matric","Degree","Diploma","Masters","Honours","Doctorate"};

    private final static Random random = new Random();
    private final static Function<String[], String> selectItemRandomly = (arr) -> arr[random.nextInt(arr.length)];

    public static List<Person> createPeople(final int max_size) {

        Random random = new Random();

        List<Person> listOfPeople = new ArrayList<>(max_size);

        for (int i = 0; i < max_size; i++) {

            Person person = new Person();
            person.setName(selectItemRandomly.apply(NAMES));
            person.setMiddleName(selectItemRandomly.apply(NAMES));
            person.setSurname(selectItemRandomly.apply(SURNAMES));
            person.setGender(selectItemRandomly.apply(GENDER));
            person.setBirthDate(LocalDate.now().minusYears(random.nextInt(50)));

            person.setCurrentContactDetails(generateContactDetails(person));

            listOfPeople.add(person);
        }

        return listOfPeople;
    }

    public static boolean isAdult(Person person) {
        return ChronoUnit.YEARS.between(person.getBirthDate(),LocalDate.now())>20;
    }

    public static List<Education> generateEducation(Person person) {
        long age = ChronoUnit.YEARS.between(person.getBirthDate(),LocalDate.now());
        List<Education> educationList = new ArrayList<>();

        if (age>=25) {
            int qualifications = random.nextInt(4);
            LocalDate runningDate = LocalDate.now().minusYears(qualifications);
            for (int i=0;i<qualifications;i++) {
                Education education = new Education();
                education.setInstitutionName(selectItemRandomly.apply(INSTITUTION));
                education.setCategory(selectItemRandomly.apply(TYPE));
                education.setEnrollmentDate(runningDate);
                runningDate = runningDate.plusYears(1);
                education.setGraduationDate(runningDate);
                educationList.add(education);
            }
        }

        return educationList;
    }

    public static ContactDetails generateContactDetails(Person person) {
        String street =
                String.format("%d %s %s", 10 + random.nextInt(89), selectItemRandomly.apply(NAMES), selectItemRandomly.apply(PREFIXES));

        Address postalAddress = new Address();
        postalAddress.setStreet(street);
        postalAddress.setCity(selectItemRandomly.apply(CITIES));
        postalAddress.setSuburb(selectItemRandomly.apply(SUBURBS));
        postalAddress.setPostalCode(String.valueOf(1000 + random.nextInt(8999)));
        postalAddress.setState(selectItemRandomly.apply(PROVINCES));

        ContactDetails contactDetails = new ContactDetails();
        contactDetails.setPhysicalAddress(postalAddress);
        contactDetails.setEmail(String.format("%s.%s@%s.com", person.getName(), person.getSurname(), selectItemRandomly.apply(MAIL_SERVER)));
        contactDetails.setMobilePhone(
                String.format("0%d-%d-%d",
                        10 + random.nextInt(89),
                        100 + random.nextInt(899),
                        1000 + random.nextInt(8999)));
        contactDetails.setHomePhone(
                String.format("0%d-%d-%d",
                        10 + random.nextInt(89),
                        100 + random.nextInt(899),
                        1000 + random.nextInt(8999)));

        return contactDetails;
    }
}
