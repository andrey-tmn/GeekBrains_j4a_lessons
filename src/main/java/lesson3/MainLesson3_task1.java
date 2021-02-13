package lesson3;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class MainLesson3_task1 {
    private static Scanner scanner = new Scanner(System.in);
    // Загадываем от 0 (включительно) до MAX_NUM (невключительно)
    private static int MAX_NUM = 10;
    // Количество попыток для игрока
    private static int MAX_TRY_CNT = 3;

    public static void main(String[] args) {
        int tryCnt = 0;
        int number = -1;

        while (true) {
            // Загадываем число, если оно не загадано
            if (number < 0) {
                number = ThreadLocalRandom.current().nextInt(MAX_NUM);
                tryCnt = 0;

                String msg = "Попробуйте угадать число от 0 (включительно) " +
                        "до %d (невключительно).%nКоличество доступных попыток: %d.%n";
                System.out.printf(msg, MAX_NUM, MAX_TRY_CNT);
            }

            // Получаем ответ пользователя, пока это не будет целое число
            // от 0 (включительно) до MAX_NUM (невключительно)
            int answer = -1;
            while ((answer < 0) || (answer >= MAX_NUM)) {
                System.out.println("Ваш вариант:");
                try {
                    answer = Integer.decode(scanner.nextLine());
                } catch (NumberFormatException nfe) { }
            }
            tryCnt++;

            // Если выиграл или проиграл
            if ((answer == number) || (MAX_TRY_CNT == tryCnt)) {
                if (answer == number) {
                    String msg = "Вы угадали число %d! Потребовалось попыток: %d.%n";
                    System.out.printf(msg, number, tryCnt);
                } else {
                    String msg = "Закончилось количество Ваших попыток, " +
                            "Вы не угадали число %d.%n";
                    System.out.printf(msg, number);
                }

                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                try {
                    if (1 == Integer.decode(scanner.nextLine()))
                        number = -1;
                    else
                        break;
                } catch (NumberFormatException nfe) {
                    break;
                }

            } else if (answer > number) {
                System.out.println("Загаданное число меньше " + answer + ".");
            } else {
                System.out.println("Загаданное число больше " + answer + ".");
            }
        }

        scanner.close();
    }
}
