package ElaheHosseini_HW11_Maktab33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<Disc> discs = new ArrayList<>();
    private static Map<Person, Disc> personDiscMap = new HashMap<>();

    public static void main(String[] args) {
        updatePeapleDiscsState("22 12 98 eli java");
        updatePeapleDiscsState("1 1 99 eli java");
        for (Person person : people
        ) {
            System.out.println("late days: " + person.getLateDays());
        }
    }

    public static boolean updatePeapleDiscsState(String newEntry) {
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
        Person person = checkForExistenceOfThisPersonInBank(name);
        Disc disc = checkForExistenceOfThisDiscInBank(discName);
        Date date = new Date(day, month, year);
        if (personDiscMap.isEmpty() || !personDiscMap.get(person).equals(disc)) {
            personDiscMap.put(person, disc);
            borrowingProcess(person, disc, date);
        } else {
            deliveringProcess(person, disc, date);
            personDiscMap.remove(person);
        }

        return true;
    }

    public static Person checkForExistenceOfThisPersonInBank(String personName) {
        for (Person p : people
        ) {
            if (p.getName().equals(personName)) {
                return p;
            }
        }
        Person person = new Person(personName);
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
