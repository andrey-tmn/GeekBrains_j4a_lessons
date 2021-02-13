package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class MainLesson3_task2 {
    Scanner scanner = new Scanner(System.in);
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        int curWordIndex = -1;
        char[] curWord = {};
        while (true) {
            // Загадываем слово
            if(curWordIndex < 0)
            {
               curWordIndex = random(words.length);
               curWord = words[curWordIndex].toCharArray();
            }

            for (char ch: curWord) {
                System.out.print(ch);
            }

            break;
        }
        //System.out.println(Arrays.toString(words));
        //input_number = scanner.nextInt();
    }

    // Сгенерировать случайное положительное целое число
    // от 0 (включительно) до max (невключительно)
    public static int random(int max) {
        if (max <= 1) return 0;
        return (int) (Math.random() * max);
    }
}
