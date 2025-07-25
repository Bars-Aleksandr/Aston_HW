package task1;

import java.util.*;

public class MainTask1 {
    private Set<Student> students = new HashSet<Student>();

    public void createStudents() {
        students.add(new Student("Alex", "MathInformath", 2, new GenSubjectGradeHashMap().getSubjectGrade()));
        students.add(new Student("Bob", "MathInformath", 2, new GenSubjectGradeHashMap().getSubjectGrade()));
        students.add(new Student("Ben", "MathInformath", 2, new GenSubjectGradeHashMap().getSubjectGrade()));
        students.add(new Student("Mari", "mathematical", 1, new GenSubjectGradeHashMap().getSubjectGrade()));
        students.add(new Student("Elena", "mathematical", 1, new GenSubjectGradeHashMap().getSubjectGrade()));
        students.add(new Student("Katy", "mathematical", 1, new GenSubjectGradeHashMap().getSubjectGrade()));
    }

    public Set<Student> getStudents() {
        return students;
    }

    private double calculateAvgGradeStudent(Student student) {
        int count = 0;
        int sum = 0;
        for (Map.Entry<String, Integer> gradeHashMap : student.getSubjectGrade().entrySet()) {
            sum = sum + gradeHashMap.getValue();
            count++;
        }
        return sum / count;
    }

    public void selectCourseByAvgGrade() {
        List<Student> removeList = new ArrayList<>();
        for (Student student : students) {
            if (calculateAvgGradeStudent(student) < 3) {
                removeList.add(student);
            } else {
                int course = student.getStudyCourse();
                student.setStudyClass(++    course);
            }
        }
        students.removeAll(removeList);
    }

    public void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getStudyCourse() == course) {
                System.out.println("Курс: " + course +"\n" + student);
            }
        }
    }

}
