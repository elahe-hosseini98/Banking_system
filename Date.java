package ElaheHosseini_HW11_Maktab33;

import java.util.Objects;

public class Date {
    int day, month, year;

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
        int passedDays = 0;

        while (!date1.equals(date2)) {
            if ((date1.getDay() < 30 && date1.getMonth() != 12) || (date1.getDay() < 29 && date1.getMonth() == 12)) {
                date1.setDay(date1.getDay() + 1);
            } else {
                date1.setDay(1);
                if (date1.getMonth() == 12) {
                    date1.setMonth(1);
                    date1.setYear(date1.getYear() + 1);
                } else {
                    date1.setMonth(date1.getMonth() + 1);
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
}
