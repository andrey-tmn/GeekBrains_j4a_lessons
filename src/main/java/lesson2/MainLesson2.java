package lesson2;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MainLesson2 {
    public static void main(String[] args) {

        System.out.println("Задание 1: создать массив случайных 1 и 0, после инвертировать");
        binaryArrayReverse();
        System.out.println();

        System.out.println("Задание 2: создать массив из 8 элементов = (индекс * 3)");
        arrayMultiplicationBy3();
        System.out.println();

        System.out.println("Задание 3: числа меньше 6 умножить на 2");
        arrayLessThan6();
        System.out.println();

        System.out.println("Задание 4: диагонали матрицы заполнить единицами");
        fillMatrixDiagonalsIs1();
        System.out.println();

        System.out.println("Задание 5: мин и макс значения в массиве");
        showArrayExtremums();
        System.out.println();

        System.out.println("Задание 6: найти \"баланс\" в массиве");
        testBalanceMethod();
        System.out.println();

        System.out.println("Задание 7: смещение массива");
        testArrayShiftMethod();
        System.out.println();
    }

    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    // С помощью цикла и условия заменить 0 на 1, 1 на 0
    private static void binaryArrayReverse() {
        final int SIZE = 10;
        int[] arr1 = new int[SIZE];
        // Заполняем случайным образом значениями 1 и 0
        Arrays.setAll(arr1, i -> (Math.random() < 0.5) ? 0 : 1);
        System.out.println(Arrays.toString(arr1));

        //Меняем 0 на 1, 1 на 0
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (0 == arr1[i]) ? 1 : 0;
        }
        System.out.println(Arrays.toString(arr1));
    }

    // 2. Задать пустой целочисленный массив размером 8.
    // С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21
    private static void arrayMultiplicationBy3() {
        final int SIZE = 8;
        int[] arr1 = new int[SIZE];
        // Заполняем 0 3 6 9 12 15 18 21
        Arrays.setAll(arr1, i -> i * 3);
        System.out.println(Arrays.toString(arr1));
    }

    // 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
    // пройти по нему циклом, и числа меньшие 6 умножить на 2
    // !!! слово "меньшие" используется в оригинальном тексте задания
    private static void arrayLessThan6() {
        int[] arr1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr1));

        //Если меньше 6 - умножаем на 2
        Arrays.setAll(arr1, i -> (arr1[i] < 6) ? arr1[i] * 2 : arr1[i]);
        System.out.println(Arrays.toString(arr1));
    }

    // 4. Создать квадратный двумерный целочисленный массив
    // (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
    // заполнить его диагональные элементы единицами
    private static void fillMatrixDiagonalsIs1() {
        final int SIZE = 7;
        int[][] arr1 = new int[SIZE][SIZE];
        System.out.printf("Создали матрицу %dx%d:%n", SIZE, SIZE);
        showMatrix(arr1);

        // Заполняем диагонали единицами
        for (int i = 0; i < arr1.length; i++) {
            // Основная диагональ
            arr1[i][i] = 1;
            // Побочная диагональ
            arr1[i][(arr1.length - 1) - i] = 1;
        }
        System.out.println("Теперь диагонали заполнены единицами:");
        showMatrix(arr1);
    }

    // Красиво вывести нашу матрицу
    private static void showMatrix(int[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.printf("%2d", arr1[i][j]);
            }
            System.out.println();
        }
    }

    // 5. ** Задать одномерный массив и найти в нем минимальный и
    // максимальный элементы (без помощи интернета)
    private static void showArrayExtremums() {
        int[] arr1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr1));

        //Переменные для хранения максимума и минимума
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] < min) {
                min = arr1[i];
            }
            if (arr1[i] > max) {
                max = arr1[i];
            }
        }
        System.out.printf("Минимальное значение: %d, максимальное: %d.%n", min, max);
    }

    // 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
    // метод должен вернуть true, если в массиве есть место,
    // в котором сумма левой и правой части массива равны.
    // Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
    // checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
    // эти символы в массив не входят
    private static void testBalanceMethod() {
        // Есть баланс
        //int[] arr1 = {6, 7, 12, 25};
        //int[] arr1 = {5, 6, 11};
        //int[] arr1 = {5, 5};
        //int[] arr1 = {11, 6, 5};
        // Нет баланса
        int[] arr1 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        //int[] arr1 = {11, 6, 4};
        //int[] arr1 = {5, 5, 5};
        //int[] arr1 = {5, 0};
        //int[] arr1 = {10, 5, 5, 5};
        System.out.println(Arrays.toString(arr1));
        if (checkBalance(arr1))
            System.out.println("В заданном массиве найден баланс!");
        else
            System.out.println("В заданном массиве не найден баланс:(");
    }

    // Ищет "баланс" в массиве
    private static boolean checkBalance(int[] arr1) {
        // Если у нас нет хотя бы двух элементов - не будет и баланса
        if (arr1.length < 2) return false;

        // В правой части сразу сумма всех элементов
        int rightPart = 0;
        for (int val : arr1) rightPart += val;
        // Если сумма всех элементов нечётная, то баланса не будет
        if ((rightPart % 2) != 0) return false;

        // Сразу в левой части ничего нет
        int leftPart = 0;

        // По одному элементу перекидываем из правой части в левую, сравнивая
        for (int val : arr1) {
            // Перекидываем текущий элемент из правой части в левую
            leftPart += val;
            rightPart -= val;
            // Баланс найден
            if (leftPart == rightPart) return true;
        }

        //Баланс не был найден
        return false;
    }

    // 7. **** Написать метод, которому на вход подается одномерный массив и
    // число n (может быть положительным, или отрицательным), при этом
    // метод должен сместить все элементымассива на n позиций.
    // Для усложнения задачи нельзя пользоваться вспомогательными массивами
    private static void testArrayShiftMethod() {
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println("Наш массив:");
        System.out.println(Arrays.toString(arr1));

        System.out.println("Сместили на n = -3");
        arrayShift(arr1, -3);
        System.out.println(Arrays.toString(arr1));

        System.out.println("После ещё сместили на n = 4");
        arrayShift(arr1, 4);
        System.out.println(Arrays.toString(arr1));
    }

    // Сместить элементы массива arr1 на n позиций
    private static int[] arrayShift(int[] arr1, int n) {
        //Если смещение равно нулю или длине массива - всё остаётся на своих местах
        if ((0 == n) || (arr1.length == n)) {
            return arr1;
        }

        // Если смещение больше длины массива, то получается,
        // нам нужно смещать несколько раз по кругу, а это тоже самое,
        // что сместить на величину равную остатку от деления n на длину массива
        if (arr1.length < Math.abs(n)) {
            n = n % arr1.length;
        }

        // Смещение влево реализуем через смещение вправо
        if (n < 0) {
            n = arr1.length + n;
        }

        // Смещаем нужное количество раз вправо
        for (int i = 0; i < n; i++) {
            arr1 = arrayShiftRight(arr1);
        }

        return arr1;
    }

    // Сместить элементы массива arr1 на одну позицию вправо
    private static int[] arrayShiftRight(int[] arr1) {
        int tmp = arr1[arr1.length - 1];
        for (int i = (arr1.length - 1); i > 0; i--)
            arr1[i] = arr1[i - 1];
        arr1[0] = tmp;
        return arr1;
    }
}
