import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private int year;
    private int month; // 0-based (0 is for January)
    private int day;

    // Constructor for today's date
    public MyDate() {
        // Get the current date
        setCurrentDate();
    }

    // Constructor with time since 1970 in milliseconds
    public MyDate(long milliseconds) {
        // Set the date from milliseconds since 1970
        setDateFromMilliseconds(milliseconds);
    }

    // Constructor with specified year, month, and day
    public MyDate(int year, int month, int day) {
        // Set the date with year, month, and day
        setDate(year, month, day);
    }

    // Getters for year, month, and day
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    // Set the date from milliseconds since 1970
    public void setDateFromMilliseconds(long milliseconds) {
        // Convert milliseconds to date and set year, month, and day
        Date date = new Date(milliseconds);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Set the current date
    public void setCurrentDate() {
        // Get the current date and set year, month, and day
        Calendar calendar = Calendar.getInstance();
        this.year = calendar.get(Calendar.YEAR);
        this.month = calendar.get(Calendar.MONTH);
        this.day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    // Set a new date with specified year, month, and day
    public void setDate(int year, int month, int day) {
        // Set year, month, and day
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Convert the date to a string
    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month + 1, day); // Adding 1 to month for readability
    }

    // Example usage
    public static void main(String[] args) {
        // Create a MyDate object for the current date
        MyDate currentDate = new MyDate();
        System.out.println("Current Date: " + currentDate);

        // Create a MyDate object with a specified date (e.g., February 1, 2023)
        MyDate customDate = new MyDate(2023, 1, 1);
        System.out.println("Custom Date: " + customDate);

        // Set a new date using elapsed time (milliseconds since January 1, 1970)
        long elapsedMillis = 1685827200000L; // Example elapsed time for September 5, 2023
        customDate.setDateFromMilliseconds(elapsedMillis);
        System.out.println("Updated Custom Date: " + customDate);
    }
}
