package ElaheHosseini_HW11_Maktab33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<Disc> discs = new ArrayList<>();
    private static Map<Person, Disc> personDiscMap = new HashMap<>();

    public static void main(String[] args) {
        updatePeapleDiscsState(10, "22 12 98 Eli java");
        updatePeapleDiscsState(10,"1 1 99 Eli java");
       /* updatePeapleDiscsState(10,"2 4 99 Atefe Shimi");
        updatePeapleDiscsState(10,"3 5 99 Negar English");
        updatePeapleDiscsState(10,"4 4 99 Atefe Shimi");*/
        for (Person person : people
        ) {
            System.out.println("penalty for '" + person.getName() + "': " + person.getPenalty());
            System.out.println("penaltyRate for '" + person.getName() + "': " + person.getPenaltyRate());
        }
    }

    public static boolean updatePeapleDiscsState(float penaltyRate, String newEntry) {
        int day, month, year;
        String name, discName;
        String[] arrOfStr = newEntry.split(" ");
        try {
            day = Integer.parseInt(arrOfStr[0]);
            month = Integer.parseInt(arrOfStr[1]);
            year = Integer.parseInt(arrOfStr[2]);
            name = arrOfStr[3];
            discName = arrOfStr[4];
        } catch (Exception e) {
            System.out.println("__ERROR: bad input!");
            return false;
        }
        Person person = checkForExistenceOfThisPersonInBank(penaltyRate, name);
        Disc disc = checkForExistenceOfThisDiscInBank(discName);
        Date date = new Date(day, month, year);
        System.out.println(person.getName());
        if (personDiscMap.isEmpty() || !personDiscMap.get(person).equals(disc)) {
            personDiscMap.put(person, disc);
            borrowingProcess(person, disc, date);
        } else {
            deliveringProcess(person, disc, date);
            personDiscMap.remove(person);
        }

        return true;
    }

    public static Person checkForExistenceOfThisPersonInBank(float penaltyRate, String personName) {
        for (Person p : people
        ) {
            if (p.getName().equals(personName)) {
                return p;
            }
        }
        Person person = new Person(personName);
        person.setPenaltyRate(penaltyRate);
        people.add(person);
        return person;
    }

    public static Disc checkForExistenceOfThisDiscInBank(String DiscName) {
        for (Disc d : discs
        ) {
            if (d.getName().equals(DiscName)) {
                return d;
            }
        }
        Disc disc = new Disc(DiscName);
        discs.add(disc);
        return disc;
    }

    public static void borrowingProcess(Person person, Disc disc, Date borrowingDate) {
        person.borrow(disc, borrowingDate);
    }

    public static void deliveringProcess(Person person, Disc disc, Date deliveringDate) {
        person.deliver(disc, deliveringDate);
    }
}
