package ElaheHosseini_HW11_Maktab33;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private ArrayList<Disc> inHandDisc = new ArrayList<>();
    private ArrayList<Borrow> borrowList = new ArrayList<>();
    private float penaltyRate, penalty = 0;

    public Person(String name) {
        this.name = name;
    }

    public void borrow(Disc disc, Date date) {
        Borrow borrow = new Borrow(date, disc.getName());
        borrowList.add(borrow);
        disc.setBorrowed(true);
        inHandDisc.add(disc);
    }

    public void deliver(Disc disc, Date date) {
        inHandDisc.remove(disc);
        disc.setBorrowed(false);
        addPenalty(disc, date);
    }

    public void addPenalty(Disc disc, Date deliveryDate) {
        Borrow borrow = null;
        for (Borrow b : borrowList
        ) {
            if (b.getDiscName().equals(disc.getName())) {
                borrow = b;
                borrowList.remove(b);
                break;
            }
        }
        penalty += borrow.lateDays(deliveryDate) * penaltyRate;
    }

    public float getPenalty() {
        return penalty;
    }

    public void setPenaltyRate(float penaltyRate) {
        this.penaltyRate = penaltyRate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPenaltyRate() {
        return penaltyRate;
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
