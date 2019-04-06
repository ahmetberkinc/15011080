package com.example.k5odev;

public class ExampleCourse {

    private String course_name;
    private String student_count;
    private String average_point;
    private String points;

    public ExampleCourse(String course_name, String student_count, String average_point,String points) {
        this.course_name = course_name;
        this.student_count = student_count;
        this.average_point = average_point;
        this.points = points;

    }


    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getStudent_count() {
        return student_count;
    }

    public void setStudent_count(String student_count) {
        this.student_count = student_count;
    }

    public String getAverage_point() {
        return average_point;
    }

    public void setAverage_point(String average_point) {
        this.average_point = average_point;
    }
}
