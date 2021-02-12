package lesson2;

public class SpiralFillMatrix {
    public static void main(String[] args) {
        // Создаём матрицу случайного размера от 1х1 до 10х10
        int[][] matrix = new int[random(1, 10)][random(1, 10)];

        //Количество элементов в матрице
        int cnt = matrix.length * matrix[0].length;
        // Указатели на текущий элемент
        int x = 0, y = 0;
        // Направление, по которому движемся:
        // 1 - вниз, 2 - вправо, 3 - вверх, 4 - влево
        int direction = 1;
        // Границы незаполненной части матрицы
        // (можно без них, просто проверять, ноль или уже не ноль соседний столбец/строка,
        // хоть и так можно, но совершенно не нужно, с этими 4 переменными просто быстрее
        // работает, меньше проверок и легче написать и проще понять код)
        int empty_start_x = 0;
        int empty_end_x = matrix.length - 1;
        int empty_start_y = 0;
        int empty_end_y = matrix[0].length - 1;

        // Заполняем нашу матрицу по спирали
        for (int i = 0; i < cnt; i++) {
            // Заполняем текущий элемент
            matrix[x][y] = i + 1;
            // В зависимости от направления определяем следующий элемент
            switch (direction) {
                // Идём вниз
                case 1: {
                    // Если можно просто идти вниз, то и идём вниз
                    if ((x + 1) <= empty_end_x)
                        x++;
                    else {
                        // Вниз больше некуда идти, идём вправо
                        direction++;
                        y++;
                        // Слева столбец заполнен
                        empty_start_y++;
                    }

                    break;
                }
                // Идём вправо
                case 2: {
                    // Если можно просто идти вправо, то идём
                    if ((y + 1) <= empty_end_y)
                        y++;
                    else {
                        // Вправо больше некуда идти, идём вверх
                        direction++;
                        x--;
                        // Строка снизу заполнена
                        empty_end_x--;
                    }
                    break;
                }
                // Идём вверх
                case 3: {
                    // Если можно просто идти вверх, то идём
                    if ((x - 1) >= empty_start_x)
                        x--;
                    else {
                        // Вверх больше некуда идти, идём влево
                        direction++;
                        y--;
                        // Справа столбец заполнен
                        empty_end_y--;
                    }
                    break;
                }
                case 4: {
                    //Если можно просто идти влево, то идём
                    if ((y - 1) >= empty_start_y)
                        y--;
                    else {
                        // Влево больше некуда идти, идём вниз
                        direction = 1;
                        x++;
                        // Строка сверху заполнена
                        empty_start_x++;
                    }
                    break;
                }
            }
        }

        showMatrix(matrix);
    }

    // Сгенерировать случайное положительное целое число
    // от 0 (включительно) до max (невключительно)
    public static int random(int max) {
        if (max <= 1) return 0;
        return (int) (Math.random() * max);
    }

    // Сгенерировать случайное положительное целое число
    // от min (включительно) до max (невключительно)
    public static int random(int min, int max) {
        if (max <= 1) return 0;
        int delta = max - min;
        if (delta <= 0) return min;
        return random(delta) + min;
    }

    // Красиво вывести нашу матрицу
    private static void showMatrix(int[][] arr1) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.printf("%-4d", arr1[i][j]);
            }
            System.out.println();
        }
    }
}
