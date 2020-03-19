package ElaheHosseini_HW11_Maktab33;

import java.util.Objects;

public class Person {
    String name;
    int lateDays;

    public Person (String name) {
        this.name = name;
    }

    public void borrow(Disc disc, Date date) {
        synchronized (disc) {

        }
    }

    public void deliver (Disc disc, Date date){
    }

    public int getLateDays() {
        return lateDays;
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
