package mk.ukim.finki.napredno.exercises.vtorkolokvium.faculty40;

import java.util.ArrayList;
import java.util.stream.IntStream;

class StudentOnThreeYearsStudies extends Student {

    public StudentOnThreeYearsStudies(String id) {
        super(id);
        IntStream.range(1, 7).forEach(i -> gradesByTerm.putIfAbsent(i, new ArrayList<>()));
    }

    @Override
    boolean addGrade(int term, String courseName, int grade) throws OperationNotAllowedException {
        validate(term);
        gradesByTerm.get(term).add(grade);
        courses.add(courseName);
        return countOfCoursesPassed() == 18;
    }

    @Override
    String getGraduationLog() {
        return super.getGraduationLog() + " in 3 years.";
    }
}