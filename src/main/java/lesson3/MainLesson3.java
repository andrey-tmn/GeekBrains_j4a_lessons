package lesson3;

import java.util.Arrays;

public class MainLesson3 {
    static String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(words));
    }

    // Сгенерировать случайное положительное целое число
    // от 0 (включительно) до max (невключительно)
    public static int random(int max) {
        if (max <= 1) return 0;
        return (int) (Math.random() * max);
    }
}
