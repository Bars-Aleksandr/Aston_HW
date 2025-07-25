package task1;

import java.util.HashMap;

public class Student {
    private final String firstname;
    private String studyGroup;
    private int course;
    private HashMap<String, Integer> subjectGrade = new HashMap<String, Integer>();

    public Student(String firstname, String studyGroup, int course, HashMap<String, Integer> subjectGrade) {
        this.firstname = firstname;
        this.studyGroup = studyGroup;
        this.course = course;
        this.subjectGrade = subjectGrade;
    }

    public String getFirstname() {
        return firstname;
    }


    public int getStudyCourse() {
        return course;
    }

    public void setStudyClass(int course) {
        this.course = course;
    }

    public HashMap<String, Integer> getSubjectGrade() {
        return subjectGrade;
    }

    @Override
    public String toString() {
        return "firstname = '" + firstname + '\'';
    }
}
