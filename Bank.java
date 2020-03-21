package ElaheHosseini_HW11_Maktab33;

import java.util.*;

public class Bank {
    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<Disc> discs = new ArrayList<>();
    private static Map<Person, Disc> personDiscMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfAction, penaltyRate;

        while (true) {
            String numOfActionAndPenaltyRate = scanner.nextLine();
            String[] arrOfStr = numOfActionAndPenaltyRate.split(" ");
            try {
                numOfAction = Integer.parseInt(arrOfStr[0]);
                penaltyRate = Integer.parseInt(arrOfStr[1]);
                break;
            } catch (Exception e) {
                System.out.println("__ERROR: bad input!");
            }
        }

        for (int i = 0; i < numOfAction; i++) {
            while (true) {
                String newEntry = scanner.nextLine();
                if (updatePeapleDiscsState(penaltyRate, newEntry)) break;
            }
        }

        finesPrinter();
        notReturnedDiscs();
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
        if (personDiscMap.isEmpty() || !Objects.equals(personDiscMap.get(person), disc)) {
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

    public static void finesPrinter() {
        System.out.println("Fines:");
        for (Person person : people
        ) {
            System.out.println(person.getName() + ": " + person.getPenalty());
        }
    }

    public static void notReturnedDiscs() {
        System.out.println("Borrowed Discs:");
        for (Person person : people
        ) {
            if (!person.getBorrowList().isEmpty()) {
                for (Borrow borrowData : person.getBorrowList()
                ) {
                    System.out.println(borrowData.getDiscName());
                }
            }
        }
    }
}
