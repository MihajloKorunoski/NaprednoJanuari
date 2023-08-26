package mk.ukim.finki.napredno.ispitni.vtorkolokvium.faculty40;

import java.util.ArrayList;
import java.util.stream.IntStream;

class StudentOnFourYearsStudies extends Student {

    public StudentOnFourYearsStudies(String id) {
        super(id);
        IntStream.range(1, 9).forEach(i -> gradesByTerm.putIfAbsent(i, new ArrayList<>()));
    }

    @Override
    boolean addGrade(int term, String courseName, int grade) throws OperationNotAllowedException {
        validate(term);
        gradesByTerm.get(term).add(grade);
        courses.add(courseName);
        return countOfCoursesPassed() == 24;
    }

    @Override
    String getGraduationLog() {
        return super.getGraduationLog() + " in 4 years.";
    }
}