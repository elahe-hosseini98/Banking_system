package ElaheHosseini_HW11_Maktab33;

public class Borrow {
    Date date;
    String discName;

    public Borrow(Date date, String discName) {
        this.date = date;
        this.discName = discName;
    }

    public Date getDate() {
        return date;
    }

    public boolean isLate(Date deliveryDate) {
        //todo
        return false;
    }

    public String getDiscName() {
        return discName;
    }
}
