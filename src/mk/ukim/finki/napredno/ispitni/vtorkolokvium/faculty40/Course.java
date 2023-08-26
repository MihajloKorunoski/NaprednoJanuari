package mk.ukim.finki.napredno.ispitni.vtorkolokvium.faculty40;

import java.util.IntSummaryStatistics;

class Course {
    String courseName;
    IntSummaryStatistics statistics;

    public Course(String courseName) {
        this.courseName = courseName;
        statistics = new IntSummaryStatistics();
    }

    void addGrade(int grade) {
        statistics.accept(grade);
    }

    @Override
    public String toString() {
        return String.format("%s %d %.2f", courseName, statistics.getCount(), statistics.getAverage());
    }

    int getStudentsCount() {
        return (int) statistics.getCount();
    }

    double getCourseAverageGrade() {
        return statistics.getAverage();
    }

    public String getCourseName() {
        return courseName;
    }
}