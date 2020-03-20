package ElaheHosseini_HW11_Maktab33;

import java.util.Objects;

public class Disc {
    boolean isBorrowed;
    String name;

    public Disc(String name) {
        this.name = name;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
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
        Disc disc = (Disc) o;
        return Objects.equals(name, disc.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
