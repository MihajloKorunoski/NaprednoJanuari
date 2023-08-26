package mk.ukim.finki.napredno.ispitni.vtorkolokvium.faculty40;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Faculty {
    Map<String, Student> studentsById;
    Map<String, Course> coursesByName;
    StringBuilder logs;

    public Faculty() {
        studentsById = new HashMap<>();
        coursesByName = new HashMap<>();
        logs = new StringBuilder();
    }

    void addStudent(String id, int yearsOfStudies) {
        studentsById.put(id, yearsOfStudies == 3 ? new StudentOnThreeYearsStudies(id) : new StudentOnFourYearsStudies(id));
    }

    void addGradeToStudent(String studentId, int term, String courseName, int grade) throws OperationNotAllowedException {
        Student student = studentsById.get(studentId);
        boolean graduated = student.addGrade(term, courseName, grade);
        coursesByName.putIfAbsent(courseName, new Course(courseName));
        coursesByName.get(courseName).addGrade(grade);
        if (graduated) {
            logs.append(student.getGraduationLog()).append("\n");
            studentsById.remove(studentId);
        }
    }

    String getFacultyLogs() {
        return logs.deleteCharAt(logs.length()-1).toString();
    }

    String getDetailedReportForStudent(String id) {
        return studentsById.get(id).getDetailedReport();
    }

    void printFirstNStudents(int n) {
        Comparator<Student> studentComparator = Comparator.comparing(Student::countOfCoursesPassed)
                .thenComparing(Student::averageGrade)
                .thenComparing(Student::getId).reversed();
        TreeSet<Student> students = new TreeSet<>(studentComparator);
        students.addAll(studentsById.values());
        students.stream()
                .limit(n)
                .forEach(student -> System.out.println(student.getShortReport()));
    }

    void printCourses() {
        Comparator<Course> courseComparator = Comparator.comparing(Course::getStudentsCount)
                .thenComparing(Course::getCourseAverageGrade)
                .thenComparing(Course::getCourseName);
        TreeSet<Course> coursesSet = new TreeSet<>(courseComparator);
        coursesSet.addAll(coursesByName.values());
        coursesSet.forEach(System.out::println);
    }
}

