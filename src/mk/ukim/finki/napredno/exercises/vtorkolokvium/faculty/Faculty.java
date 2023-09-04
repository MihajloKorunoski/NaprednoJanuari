package mk.ukim.finki.napredno.exercises.vtorkolokvium.faculty;

import java.util.*;
import java.util.stream.Collectors;

class Faculty {
    Map<String, List<StudentOnCourse>> studentByCourse = new HashMap<>();
    Map<String, List<StudentOnCourse>> coursesByStudent = new HashMap<>();

    public void addInfo(String courseId, String studentId, int totalPoints) {
        StudentOnCourse studentOnCourse = new StudentOnCourse(courseId, studentId, totalPoints);

        studentByCourse.computeIfAbsent(studentId, k -> new ArrayList<>()).add(studentOnCourse);
        coursesByStudent.computeIfAbsent(courseId, k -> new ArrayList<>()).add(studentOnCourse);
    }

    public void printCourseReport(String courseId, String comparatorStr, boolean descending) {
        List<StudentOnCourse> student = studentByCourse.get(courseId);

        Comparator<StudentOnCourse> comparator = getComparator(comparatorStr, descending);

        student.stream()
                .sorted(comparator)
                .forEach(System.out::println);
    }

    private static Comparator<StudentOnCourse> getComparator(String comparatorStr, boolean descending) {
        Comparator<StudentOnCourse> comparator;

        if (comparatorStr.equalsIgnoreCase("byid"))
            comparator = Comparator.comparing(StudentOnCourse::getCourseID);
        else
            comparator = Comparator.comparing(StudentOnCourse::getGrade)
                    .thenComparing(StudentOnCourse::getTotalPoints)
                    .thenComparing(StudentOnCourse::getStudentID);

        if (descending)
            comparator = comparator.reversed();
        return comparator;
    }

    public void printStudentReport(String studentId) {

        Comparator<StudentOnCourse> comparator = Comparator.comparing(StudentOnCourse::getCourseID);

        coursesByStudent.get(studentId)
                .stream()
                .sorted(comparator)
                .forEach(s -> System.out.println(s.reportWithCourse()));
    }

    public Map<Integer, Integer> gradeDistribution(String courseId) {
//        List<StudentOnCourse> studentOnCourses = studentByCourse.get(courseId);
//        Map<Integer,Integer> countingMap = new TreeMap<>();
//
//        for(StudentOnCourse studentOnCourse : studentOnCourses){
//            int grade = studentOnCourse.getGrade();
//            countingMap.putIfAbsent(grade, 0);
//            countingMap.computeIfPresent(grade, (key,value) -> ++value);
//        }
//        return countingMap;

        return studentByCourse.get(courseId)
                .stream()
                .collect(Collectors.groupingBy(
                        StudentOnCourse::getGrade,
                        HashMap::new,
                        Collectors.summingInt(grade -> 1)
                ));
    }
}
