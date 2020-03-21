package ElaheHosseini_HW11_Maktab33;

import java.util.Objects;

public class Date implements Cloneable {
    int day, month, year;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public static int passedDays(Date date1, Date date2) {
        Date data1Copy = null;
        try {
            data1Copy = (Date) date1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        int passedDays = 0;

        while (!data1Copy.equals(date2)) {
            if ((data1Copy.getDay() < 30 && data1Copy.getMonth() != 12) || (data1Copy.getDay() < 29 && data1Copy.getMonth() == 12)) {
                data1Copy.setDay(data1Copy.getDay() + 1);
            } else {
                data1Copy.setDay(1);
                if (data1Copy.getMonth() == 12) {
                    data1Copy.setMonth(1);
                    data1Copy.setYear(data1Copy.getYear() + 1);
                } else {
                    data1Copy.setMonth(data1Copy.getMonth() + 1);
                }
            }
            passedDays++;
        }
        return passedDays + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Date date = (Date) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "Date{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
