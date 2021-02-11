package lesson1;

public class MainLesson1 {
    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main()
    public static void main(String[] args) {
        // 2. Переменные всех типов
        allTypesVar();

        // 3. Выражение a * (b + (c / d))
        double resTask3 = calculateExpression(2, 10, 20, 5);
        System.out.println("Посчитали 2 * (10 + (20/5)) = " + resTask3);

        // 4. Сумма в пределах от 10 до 20
        boolean resTask4 = isBetweenTenTwenty(5, 25);
        System.out.println("Сумма 5 и 25 находится между 10 и 20: " + resTask4);

        // 5. Положительное или отрицальное
        checkModuleOfNumber(55);

        // 6. Является ли число отрицательным
        boolean resTask6 = isNegativeNumber(55);
        System.out.println("Утверждение, что 55 отрицательное число: " + resTask6);

        // 7. Поприветствовать по имени
        printHello("преподаватель Тимофей");

        // 8. Високосный ли год
        chekLeapYear(2007);
    }

    // 2. Создать переменные всех пройденных типов данных,
    // и инициализировать их значения
    private static void allTypesVar() {
        // Целочисленные типы
        byte tmpB = 5;
        short tmpSh = 5000;
        int tmpI = 500000000;
        long tmpL = (long) tmpI * tmpI * tmpI * tmpI;
        // Выведем, что в итоге получилось в tmpL,
        // заодно используя тип переменной String, который тоже был в уроке
        String tmpStr = "64-битная целочисленная переменная содержит значение: ";
        tmpStr += tmpL;
        System.out.println(tmpStr);

        // Числа с плавающей запятой,
        // просто объявили и инициализировали, ничего не делаем с переменной далее,
        // т.к. в задании ничего больше делать с переменными не нужно
        double tmpF = 5.5;

        // Символьная переменная
        char tmpCh = 'A';
        System.out.println("Наш символ: " + tmpCh);

        // Логическая
        boolean flag = false;
        System.out.println("У нас тут ЛОЖЬ: " + flag);
    }

    // 3. Написать метод вычисляющий выражение a * (b + (c / d))
    // и возвращающий результат, где a, b, c, d –
    // входные параметры этого метода.
    // Помните про типы данных и их приведение
    private static double calculateExpression(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }

    // 4. Написать метод, принимающий на вход два числа,
    // и проверяющий что их сумма лежит в пределах от 10 до 20 (включительно),
    // если да – вернуть true, в противном случае – false
    private static boolean isBetweenTenTwenty(double a, double b) {
        final byte MIN = 10;
        final byte MAX = 20;
        double sum = a + b;
        return (sum >= MIN) && (sum <= MAX);
    }

    // 5. Написать метод, которому в качестве параметра
    // передается целое число, метод должен напечатать в консоль
    // положительное ли число передали, или отрицательное;
    // Замечание: ноль считаем положительным числом.
    private static void checkModuleOfNumber(int a) {
        if (a >= 0)
            System.out.println("Число " + a + " является положительным.");
        else
            System.out.println("Число " + a + " является отрицательным.");
    }

    // 6. Написать метод, которому в качестве параметра передается
    // целое число, метод должен вернуть true, если число отрицательное
    private static boolean isNegativeNumber(int a) {
        // В задании не сказано, что делать, если число положительное,
        // но логично вернуть false
        return a < 0;
    }

    // 7. Написать метод, которому в качестве параметра передается строка,
    // обозначающая имя, метод должен вывести в консоль сообщение
    // «Привет, указанное_имя!»;
    private static void printHello(String str1) {
        System.out.println("Привет, " + str1 + "!");
    }

    // 8. * Написать метод, который определяет является
    // ли год високосным, и выводит сообщение в консоль.
    // Каждый 4-й год является високосным, кроме каждого 100-го,
    // при этом каждый 400-й – високосный
    private static void chekLeapYear(int year) {
        boolean isLeapYear = false;

        // Если число делится без остатка на 4,
        // то это високосный год, за исключением 100-х годов
        if (0 == (year % 4)) {
            isLeapYear = true;
            // Это сотый год - он не високосный, если он не 400-й
            if (0 == (year % 100)) {
                isLeapYear = false;
                // Это 400-й год, он високосный
                if (0 == (year % 400))
                    isLeapYear = true;
            }
        }

        if (isLeapYear)
            System.out.println("Год " + year + " високосный!");
        else
            System.out.println("Год " + year + " НЕ високосный!");
    }
}
