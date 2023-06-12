package mk.ukim.finki.napredno.auditoriski.aud5.grades;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Course {
    private List<Student> students;

    public Course() {
        students = new ArrayList<>();
    }

    public void readData(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        students = bufferedReader.lines()
                .map(Student::createStudent)
                .collect(Collectors.toList());
    }

    public void printSortedData(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);

        students.stream().sorted().forEach(printWriter::println);
        printWriter.flush();
    }

    public void printDetailedData(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);

        students.forEach(i -> printWriter.println(i.printFullFormat()));
        printWriter.flush();
    }

    public void printGradeDistribution(OutputStream outputStream) {
        PrintWriter printWriter = new PrintWriter(outputStream);

        int[] gradeDistribution = new int[6];
        for (Student s : students) {
            gradeDistribution[s.getGrade() - 'A']++;
        }

//        for (int i = 0; i < 6; i++) {
//            printWriter.printf("%c -> %d\n", i + 'A', gradeDistribution[i]);
//        }
        IntStream.range(0,6)
                        .forEach(i ->  printWriter.printf("%c -> %d\n", i + 'A', gradeDistribution[i]));
        printWriter.flush();
    }
}
