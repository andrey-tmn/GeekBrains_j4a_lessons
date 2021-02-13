package lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class MainLesson3_task2 {
    private static Scanner scanner = new Scanner(System.in);
    private static String[] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon",
            "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
            "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        int curWordIndex = -1;
        int tryCnt = 0;
        char[] curWord = {};
        char[] openPartOfWord = new char[15];

        while (true) {
            // Загадываем слово, если оно не загадано
            if (curWordIndex < 0) {
                curWordIndex = random(words.length);
                curWord = words[curWordIndex].toCharArray();
                Arrays.fill(openPartOfWord, '#');
                tryCnt = 0;

                System.out.println("Вам загадано одно из " + words.length + " слов:");
                System.out.println(Arrays.toString(words));
            }

            // Запрашиваем ответ
            System.out.println("Ваш вариант:");
            String answer = scanner.nextLine();
            answer = answer.toLowerCase().trim();
            tryCnt++;

            if (answer.equals(words[curWordIndex])) {
                String msg = "Абсолютно верно! Это %s! Вам понадобилось попыток: %d.%n";
                System.out.printf(msg, answer, tryCnt);
                System.out.println("Хотите сыграть снова? Введите да, если хотите, ");
                System.out.println("любое другое значение для выхода:");
                String playAgain = scanner.nextLine();
                playAgain = playAgain.toLowerCase().trim();
                if (playAgain.equals("да"))
                    curWordIndex = -1;
                else
                    break;
            }
            else
            {
                char[] userAnswer = answer.toCharArray();
                for (int i = 0; i < 15; i++) {
                    if((i < userAnswer.length) && (i < curWord.length))
                    {
                        if(userAnswer[i] == curWord[i])
                            openPartOfWord[i] = userAnswer[i];
                    }
                }

                System.out.println("Нет, слово другое, но мы открыли буквы, которые совпали:");
                for (char ch : openPartOfWord) {
                    System.out.print(ch);
                }
                System.out.println();
            }
        }
    }

    // Сгенерировать случайное положительное целое число
    // от 0 (включительно) до max (невключительно)
    public static int random(int max) {
        if (max <= 1) return 0;
        return (int) (Math.random() * max);
    }
}
