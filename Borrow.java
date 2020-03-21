package ElaheHosseini_HW11_Maktab33;

public class Borrow {
    private Date borrowingDate;
    private String discName;

    public Borrow(Date date, String discName) {
        this.borrowingDate = date;
        this.discName = discName;
    }

    public Date getBorrrowingDate() {
        return borrowingDate;
    }

    public boolean isLate(Date deliveryDate) {
        if (Date.passedDays(borrowingDate, deliveryDate) > 7) return true;
        return false;
    }

    public int lateDays (Date deliveryDate) {
        if (isLate(deliveryDate)) return (Date.passedDays(borrowingDate, deliveryDate) - 7);
        return 0;
    }

    public String getDiscName() {
        return discName;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "discName='" + discName + '\'' +
                '}';
    }
}
