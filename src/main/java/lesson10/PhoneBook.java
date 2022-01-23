package lesson10;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> phones = new HashMap<>();

    // Добавить запись: Фамилия - телефон
    public void add(String surname, String phone) {
        Set<String> record = phones.get(surname);
        if (null == record)
            record = new HashSet<>();
        record.add(phone);
        phones.put(surname, record);
    }

    // Вывести все телефоны для указанной фамилии
    public void get(String surname) {
        Set<String> record = phones.get(surname);
        if (null == record)
            System.out.printf("Фамилии %s нет в телефонном справочнике.%n", surname);
        else
            System.out.println(surname + ": " + record);
    }
}
