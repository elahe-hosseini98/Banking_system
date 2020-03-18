package ElaheHosseini_HW11_Maktab33;

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
}
