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
    private final static String[] COMPANIES = "Absa Group Ltd,Anchor Group Limited,ArcelorMittal SA Limited,AFROCENTRIC INV CORP LTD,ADVTECH LTD,Adaptit Holdings Limited,Adcorp Holdings Limited,ALLIED ELECTRONICS CORP,AECI Limited,Alexander Forbes Group Holdings Ltd,Afrimat Limited,African Oxygen Limited,ANGLO AMERICAN PLC,Adcock Ingram Hldgs Ltd,Anglo American Plat Ltd,ANGLOGOLD ASHANTI LTD,Anheuser Busch Inbev SA,Aspen Pharmacare Hldgs L,Astoria Investments Ltd.,African Rainbow Min Ltd,ASTRAL FOODS LTD,ARGENT INDUSTRIAL LTD,Ascendis Health Ltd,ASHINF,ASHMID,ASHT40,Austro Group Ltd,ASSORE LTD,Attacq Limited,AVI LTD,Alviva Holdings Ltd,Arrowhead Properties A,Brait SE,BARLOWORLD LTD,BHP Group Limited,Bid Corp Ltd,BLUE LABEL TELECOMS LTD,Crypto: 0.01 Bitcoins,British American Tob plc,Bidvest Ltd,Capital&Counties Prop pl,COMPAGNIE FIN RICHEMONT,Calgro M3 Hldgs Ltd,Cons Infrastructure Grp,City Lodge Hotels Ltd,CLOVER INDUSTRIES LTD,Clicks Group Ltd,COMBINED MOTOR HLDGS LTD,CORONATION FUND MNGRS LD,CONDUIT CAPITAL LTD,CURRO HOLDINGS LIMITED,CAPITEC BANK HLDGS LTD,Capital and Regional Plc,CASHBUILD LTD,CSEW40,Capevin Holdings Ltd,Dis-chem Pharmacies Limited,DIVTRX,Delta Property Fund Ltd,DRD Gold Ltd,DISTELL GROUP LTD,Discovery Ltd,DATATEC LTD,EMIRA PROPERTY FUND,EOH HOLDINGS LTD,ETFRHO,EXXARO RESOURCES LTD,FAMOUS BRANDS LTD,Fortress Inc Fund Ltd A,Fortress Inc Fund Ltd B,Finbond Group Ltd,FIRSTRAND LTD,GOLD FIELDS LTD,NEW GOLD ISSUER LTD,Glencore Xstrata plc,GRINDROD LTD,GRAND PARADE INV LTD,GROWTHPOINT PROP LTD,Harmony GM Co Ltd,Hosken Cons Inv Ltd,HUDACO INDUSTRIES LTD,Hulamin Ltd,Hammerson PLC,HOLDSPORT LIMITED,Hyprop Inv Ltd,Investec Australia Prop,International Hotel Group Limited,Impala Platinum Hlgs Ltd,INVESTEC LTD,INVESTEC PLC,INVESTEC PROPERTY FUND L,IMPERIAL HOLDINGS LTD,ITALTILE LTD,Intu Properties plc,INVICTA HOLDINGS LTD,JSE LTD,KAP Industrial Hldgs Ltd,KUMBA IRON ORE LTD,PSG Konsult Limited,Long4Life Ltd,Liberty Holdings Ltd,LEWIS GROUP LTD,Life Healthc Grp Hldgs L,MAPPSG,MAPPSP,Master Drilling Grp Ltd,Mediclinic Internat Ltd,METROFILE HOLDINGS LTD,MIX TELEMATICS LTD,MONDI PLC,MPACT LIMITED,MERAFE RESOURCES LTD,MR PRICE GROUP LTD,MASSMART HOLDINGS LTD,Metair Investments Ltd,Motus Holdings Ltd.,Momentum Met Holdings Ltd,MTN GROUP LTD,Murray & Roberts Hldgs,NEDBANK GROUP LTD,NEW EUROPE PROP INV PLC,NEWFSA,NEWUSD,NFEMOM,NFGOVI,NFILBI,NFSH40,NFSWIX,NFTRCI,New Gold Platinum ETF,NORTHAM PLATINUM LTD,Niveus Investments Ltd,Nampak Ltd,NASPERS LTD -N-,NEPI Rockcastle PLC,NET 1 UEPS TECH INC,NETCARE LIMITED,OCEANA GROUP LTD,OCTODEC INVEST LTD,OLD MUTUAL PLC,OMNIA HOLDINGS LTD,PAN AFRICAN RESOURCE PLC,PIONEER FOODS GROUP LTD,Peregrine Holdings Limit,PIK N PAY STORES LTD,PPC Limited,Steinhoff Africa Retail Ltd,PSG Group Ltd,PTXSPY,PTXTEN,RAFFIN,RAFIND,RAFISA,RAFRES,ROYAL BAFOKENG PLATINUM,RAUBEX GROUP LTD,RCL Foods Limited,Redefine Properties Ltd,Reinet Inv Soc Anon,REMGRO LTD,Resilient Prop Inc Fund,Rhodes Food Group Pty Ltd,Rolfes Technology Hldgs,Reunert Ltd,RMB HOLDINGS LTD,Rand Merchant Ins Hldgs,Redefine International P,South32 Ltd,SA CORP REAL ESTATE FUND,SAPPI LTD,STANDARD BANK GROUP LTD,Stadio Holdings Ltd,Sephaku Holdings Ltd,Sibanye Gold Limited,Shoprite Holdings Ltd,Sanlam Limited,Steinhoff Int Hldgs Ltd,Santam Limited,Santova Logistics Ltd,Sasol Limited,SUPER GROUP LTD,THE SPAR GROUP LTD,Sirius Real Estate Ltd,Stor-Age Property REIT Ltd,STAN40,STANSX,STPROP,Satrix 40 Portfolio,STX500,STXDIV,STXEMG,STXFIN,STXIND,STXQUA,STXRAF,STXRES,STXSWX,STXWDM,SUN INTERNATIONAL LTD,SPUR CORPORATION LTD,Sygnia Limited,DB X-TRACKERS DJ EU ST 5,Db x-trackers MSCI Japan,DB X-TRACKERS FTSE 100,DB X-TRACKERS COL IN USA,DB X-TRACKERS COL IN WLD,Tiger Brands Ltd,Texton Property Fund Ltd,The Foschini Group Limit,Telkom SA SOC Ltd,TONGAAT HULETT LTD,TRENCOR LTD,Truworths Int Ltd,Tower Property Fund Ltd,VUKILE PROPERTY FUND LTD,Vodacom Group Ltd,Wilson Bayly Hlm-Ovc Ltd,WOOLWORTHS HOLDINGS LTD,WESCOAL HOLDINGS LTD,Zeder Inv Ltd".split(",");
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

    public static List<Education> generateEmploymentHistory(Person person) {
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
