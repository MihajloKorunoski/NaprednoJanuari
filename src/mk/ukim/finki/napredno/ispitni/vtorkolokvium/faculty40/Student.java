package mk.ukim.finki.napredno.ispitni.vtorkolokvium.faculty40;

import java.util.*;

abstract class Student {
    String id;
    Map<Integer, List<Integer>> gradesByTerm;
    Set<String> courses;

    public Student(String id) {
        this.id = id;
        gradesByTerm = new TreeMap<>();
        courses = new TreeSet<>();
    }

    String getGraduationLog() {
        return String.format("Student with ID %s graduated with average grade %.2f", id, averageGrade());
    }

    double averageGrade() {
        return gradesByTerm.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(i -> i)
                .average()
                .orElse(5.0);
    }

    double averageGradeForTerm(int term) {
        return gradesByTerm.get(term).stream().mapToInt(i -> i).average().orElse(5.0);
    }

    abstract boolean addGrade(int term, String courseName, int grade) throws OperationNotAllowedException;

    void validate(int term) throws OperationNotAllowedException {
        if (!gradesByTerm.containsKey(term))
            throw new OperationNotAllowedException(String.format("Term %d is not possible for student with ID %s", term, id));
        if (gradesByTerm.get(term).size() == 3)
            throw new OperationNotAllowedException(String.format("Student %s already has 3 grades in term %d", id, term));
    }

    int countOfCoursesPassed() {
        return gradesByTerm.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    public String getDetailedReport() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Student: %s\n", id));
        gradesByTerm.keySet().forEach(term -> sb.append(getTermReport(term)).append("\n"));
        sb.append(String.format("Average grade: %.2f\nCourses attended: %s",
                averageGrade(),
                String.join(",", courses)
        ));
        return sb.toString();
    }

    public String getShortReport() {
        return String.format("Student: %s Courses passed: %d Average grade: %.2f",
                id,
                countOfCoursesPassed(),
                averageGrade());
    }

    String getTermReport(int term) {
        return String.format("Term %d\nCourses: %d\nAverage grade for term: %.2f",
                term,
                gradesByTerm.get(term).size(),
                averageGradeForTerm(term)
        );
    }

    String getId() {
        return id;
    }
}
