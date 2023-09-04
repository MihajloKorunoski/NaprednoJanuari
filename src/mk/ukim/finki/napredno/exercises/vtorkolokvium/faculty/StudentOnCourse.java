package mk.ukim.finki.napredno.exercises.vtorkolokvium.faculty;

class StudentOnCourse {
    String courseID;
    String studentID;
    int totalPoints;

    public StudentOnCourse(String courseID, String studentID, int totalPoints) {
        this.courseID = courseID;
        this.studentID = studentID;
        this.totalPoints = totalPoints;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getStudentID() {
        return studentID;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    int getGrade() {
        int grade = totalPoints / 10 + 1;
        if (grade < 5)
            grade = 5;
        else if (grade > 10)
            grade = 10;
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%s %d (%d)", studentID, totalPoints, getGrade());
    }

    public String reportWithCourse() {
        return String.format("%s %d (%d)", courseID, totalPoints, getGrade());
    }
}
