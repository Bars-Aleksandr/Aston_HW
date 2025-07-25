package task1;

import java.util.HashMap;
import java.util.Random;

public class GenSubjectGradeHashMap {
    private String[] subjects = {"Русский язык",
            "Литература",
            "Алгебра",
            "Геометрия",
            "Физика",
            "Химия",
            "Биология",
            "История"};
    private HashMap<String, Integer> subjectGrade = new HashMap<String, Integer>();

    public GenSubjectGradeHashMap() {
        Random random = new Random();
        for (String subject : subjects) {
            this.subjectGrade.put(subject, random.nextInt(5) + 1);
        }
    }

    public HashMap<String, Integer> getSubjectGrade() {
        return subjectGrade;
    }
}
