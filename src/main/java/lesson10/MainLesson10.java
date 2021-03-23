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
        for(Map.Entry<String, Integer> entry : wordsCnt.entrySet()) {
            System.out.printf(msg, entry.getKey(), entry.getValue());
        }
    }
}
