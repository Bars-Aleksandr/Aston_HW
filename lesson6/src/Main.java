import task1.MainTask1;
import task2.PhoneBook;

public class Main {
    public static void main(String[] args) {
        MainTask1 task1 = new MainTask1();
        task1.createStudents();
        task1.selectCourseByAvgGrade();
        task1.printStudents(task1.getStudents(), 3);


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+37529123456");
        phoneBook.add("Иванов", "+375441111111");
        phoneBook.add("Петров", "+375332584769");

        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));
    }
}