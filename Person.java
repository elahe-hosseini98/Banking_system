package ElaheHosseini_HW11_Maktab33;

import java.util.Objects;

public class Person {
    String name;
    int lateDays;
    Date borrowingDate;
    Disc inHandDisc;

    public Person (String name) {
        this.name = name;
    }

    public void borrow(Disc disc, Date date) {
        borrowingDate = date;
        disc.setBorrowed(true);
    }

    public void deliver (Disc disc, Date date){
        lateDays = Date.passedDays(borrowingDate, date);
        disc.setBorrowed(false);
    }

    public int getLateDays() {
        return lateDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
