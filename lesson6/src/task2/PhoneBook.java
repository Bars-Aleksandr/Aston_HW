package task2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.NoSuchElementException;


/*
Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.

 */
public class PhoneBook {
    private final Map<String, Set<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (!this.phoneBook.containsKey(surname)) {
            this.phoneBook.put(surname, new HashSet<>());
        }
        this.phoneBook.get(surname).add(phoneNumber);
    }
    public Set<String> get(String surname) throws NoSuchElementException {
        if (this.phoneBook.containsKey(surname)) {
            return this.phoneBook.get(surname);
        } else {
            throw new NoSuchElementException("Фамилия '" + surname + "' не найдена.");
        }

    }
}
