package mk.ukim.finki.napredno.labs.contacts;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringJoiner;
import java.util.stream.Collectors;

class Faculty {

    private String name;
    private ArrayList<Student> students;

    public Faculty(String name, ArrayList<Student> students) {
        this.name = name;
        this.students = students;
    }

    public Student getStudent(long index) {
        return students.stream()
                .filter(each -> each.getIndex() == index)
                .findFirst()
                .orElse(null);
    }

    public double getAverageNumberOfContacts() {
        return students.stream()
                .mapToInt(Student::getContactsSize)
                .average()
                .orElse(0.0);
    }

    public int countStudentsFromCity(String city) {
        return (int) students.stream()
                .filter(each -> each.getCity().equals(city))
                .count();
    }

    public Object getStudentWithMostContacts() {
        return students.stream()
                .max(Comparator.comparingInt(Student::getContactsSize)
                        .thenComparingLong(Student::getIndex))
                .orElse(null);
    }

    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", "}");
        String studentString = students.stream()
                .map(Student::toString)
                .collect(Collectors.joining(", ", "[", "]"));
        joiner.add(Student.keyValue("fakultet", name))
                .add(Student.keyValueNoQuotes("studenti", studentString));
        return joiner.toString();
    }
}
