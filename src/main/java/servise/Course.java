package servise;

import java.sql.Date;

public class Course {

    private static String title;
    private static Date startDate;
    private  int lecturerCode;

    public Course(String title, Date startDate, int lecturerCode) {
        this.title = title;
        this.startDate = startDate;
        this.lecturerCode = lecturerCode;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getLecturerCode() {
        return lecturerCode;
    }

    public void setLecturerCode(int lecturerCode) {
        this.lecturerCode = lecturerCode;
    }
}
