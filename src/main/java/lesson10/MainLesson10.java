package lesson10;

import java.util.HashMap;
import java.util.Map;

public class MainLesson10 {
    public static void main(String[] args) {
        task1();
    }

    private static void task1() {
        String[] words = {"один", "два", "три", "три", "три", "четыре", "пять",
                "пять", "шесть", "семь", "восемь", "девять", "десять", "десять"};
        Map<String, Integer> wordsCnt = new HashMap<>();

        for (String word : words) {
            if (wordsCnt.containsKey(word))
                wordsCnt.put(word, wordsCnt.get(word) + 1);
            else
                wordsCnt.put(word, 1);
        }

        String msg = "Слово «%s» в массиве используется раз: %d.%n";
        for (Map.Entry<String, Integer> entry : wordsCnt.entrySet()) {
            System.out.printf(msg, entry.getKey(), entry.getValue());
        }

        System.out.println();

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "+7-919-32-11-111");
        phoneBook.add("Петров", "+7-920-32-22-222");
        phoneBook.add("Петров", "+7-922-32-33-333");
        phoneBook.add("Кузнецов", "+7-959-32-44-444");

        phoneBook.get("Иванов");
        phoneBook.get("Отсутствующий");
        phoneBook.get("Петров");
    }
}
