package lesson4;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    static final int MAP_SIZE = 5;
    static final int WIN_CNT = 4;

    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final char HEADER_FIRST_SYMBOL = '♥';
    static final String EMPTY = " ";

    static final char[][] MAP = new char[MAP_SIZE][MAP_SIZE];
    static final Scanner in = new Scanner(System.in);
    static final Random random = new Random();
    static int turnsCount;
    static int[] lastTurnPosHuman = new int[2];
    static int[] lastTurnPosAI = new int[2];


    public static void main(String[] args) {
        turnGame();
    }

    public static void turnGame() {

        //инициализация поля
        initMap();

        //печать поля в консоль
        printMap();

        //игра
        playGame();

    }

    private static void initMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                MAP[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        //печать заголовка
        printHeaderMap();

        //печать поля
        printBodyMap();
    }

    private static void printHeaderMap() {
        System.out.print(HEADER_FIRST_SYMBOL + EMPTY);

        for (int i = 0; i < MAP_SIZE; i++) {
            printMapNumber(i);
        }
        System.out.println();

    }

    private static void printMapNumber(int i) {
        System.out.print(i + 1 + EMPTY);
    }

    private static void printBodyMap() {
        for (int i = 0; i < MAP_SIZE; i++) {
            printMapNumber(i);
            for (int j = 0; j < MAP_SIZE; j++) {
                System.out.print(MAP[i][j] + EMPTY);
            }
            System.out.println();
        }
    }


    private static void playGame() {

        turnsCount = 0;
        while (true) {
            humanTurn();
            printMap();
            checkEnd(DOT_HUMAN);

            turnAI();
            printMap();
            checkEnd(DOT_AI);
        }
    }

    private static void humanTurn() {
        int rowNumber;
        int columnNumber;
        boolean isInputValid = true;


        System.out.println("\nХод человека! Введите номера строки и столбца");
        do {
            rowNumber = -1;
            columnNumber = -1;
            isInputValid = true;

            System.out.print("Строка: ");
            if (in.hasNextInt()) {
                rowNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
                continue;
            }

            System.out.print("Столбик: ");
            if (in.hasNextInt()) {
                columnNumber = in.nextInt() - 1;
            } else {
                processingIncorrectInput();
                isInputValid = false;
            }

        } while (!(isInputValid && isHumanTurnValid(rowNumber, columnNumber)));

        MAP[rowNumber][columnNumber] = DOT_HUMAN;
        lastTurnPosHuman[0] = rowNumber;
        lastTurnPosHuman[1] = columnNumber;
        turnsCount++;
    }

    private static void processingIncorrectInput() {
        System.out.println("Ошибка ввода! Введите число в диапазоне размера игрового поля");
        in.nextLine();
    }

    private static boolean isHumanTurnValid(int rowNumber, int columnNumber) {
        if (!isNumbersValid(rowNumber, columnNumber)) {
            System.out.println("\nПроверьте значения строки и столбца");
            return false;
        } else if (!isCellEmpty(rowNumber, columnNumber)) {
            System.out.println("\nВы выбрали занятую ячейку");
            return false;
        }

        return true;
    }

    private static boolean isNumbersValid(int rowNumber, int columnNumber) {
        return !(rowNumber >= MAP_SIZE || rowNumber < 0 || columnNumber >= MAP_SIZE || columnNumber < 0);
    }

    private static boolean isCellEmpty(int rowNumber, int columnNumber) {
        return MAP[rowNumber][columnNumber] == DOT_EMPTY;
    }

    private static void checkEnd(char symbol) {

        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Ура! Вы победили!");
            } else {
                System.out.println("Восстание близко... ИИ победил...");
            }
            System.exit(0);
        } else if (isMapFull()) {
            System.out.println("Ничья!");
            System.exit(0);
        }
    }

    private static boolean isMapFull() {
        return turnsCount == MAP_SIZE * MAP_SIZE;
    }

    private static boolean checkWin(char symbol) {
        // Последний ход текущего игрока
        int lastI = lastTurnPosAI[0];
        int lastJ = lastTurnPosAI[1];
        if (symbol != DOT_AI) {
            lastI = lastTurnPosHuman[0];
            lastJ = lastTurnPosHuman[1];
        }

        // Проходим прямые линии
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < MAP.length; i++) {
            cnt1 = (MAP[i][lastJ] == symbol) ? cnt1 + 1 : 0;
            cnt2 = (MAP[lastI][i] == symbol) ? cnt2 + 1 : 0;
            if ((WIN_CNT == cnt1) || (WIN_CNT == cnt2)) return true;
        }

        // Ищем начало обеих диагоналей
        int[] diagonal1 = {lastI, lastJ};
        while ((diagonal1[0] > 0) && (diagonal1[1] > 0)) {
            diagonal1[0]--;
            diagonal1[1]--;
        }
        int[] diagonal2 = {lastI, lastJ};
        while ((diagonal2[0] < (MAP_SIZE - 1)) && (diagonal2[1] > 0)) {
            diagonal2[0]++;
            diagonal2[1]--;
        }

        // Проходим диагонали, проверяем победу
        int cnt = 0;
        while ((diagonal1[0] <= (MAP_SIZE - 1)) && (diagonal1[1] <= (MAP_SIZE - 1))) {
            cnt = (MAP[diagonal1[0]][diagonal1[1]] == symbol) ? cnt + 1 : 0;
            if (WIN_CNT == cnt) return true;

            diagonal1[0]++;
            diagonal1[1]++;
        }
        cnt = 0;
        while ((diagonal2[0] >= 0) && (diagonal2[1] <= (MAP_SIZE - 1))) {
            cnt = (MAP[diagonal2[0]][diagonal2[1]] == symbol) ? cnt + 1 : 0;
            if (WIN_CNT == cnt) return true;

            diagonal2[0]--;
            diagonal2[1]++;
        }

        return false;
    }

    private static int[] getRandomTurn() {
        int[] newTurn = new int[2];
        newTurn[0] = random.nextInt(MAP_SIZE);
        newTurn[1] = random.nextInt(MAP_SIZE);
        return newTurn;
    }

    private static boolean checkBlockTurn(int[] cellHuman, int[] cellNewTurn) {
        return (DOT_HUMAN == MAP[cellHuman[0]][cellHuman[1]]) &&
                (DOT_EMPTY == MAP[cellNewTurn[0]][cellNewTurn[1]]);
    }

    private static int[] getBlockTurn() {
        int[] newTurn = new int[2];

        // Если есть два хода пользователя в ряд и
        // есть возможность сходить в эту же линию, то ходим
        for (int i = 0; i < 8; i++) {
            int[] tmpCellHuman = {lastTurnPosHuman[0], lastTurnPosHuman[1]};
            int[] tmpCellEmpty = {lastTurnPosHuman[0], lastTurnPosHuman[1]};

            int j = 0;
            if (j++ == i) {
                tmpCellHuman[0]--;
                tmpCellEmpty[0]++;
            } else if (j++ == i) {
                tmpCellHuman[0]++;
                tmpCellEmpty[0]--;
            }
            else if (j++ == i){
                tmpCellHuman[1]--;
                tmpCellEmpty[1]++;
            }
            else if (j++ == i) {
                tmpCellHuman[1]++;
                tmpCellEmpty[1]--;
            }
            else if (j++ == i) {
                tmpCellHuman[0]++;
                tmpCellHuman[1]++;
                tmpCellEmpty[0]--;
                tmpCellEmpty[1]--;
            } else if (j++ == i) {
                tmpCellHuman[0]--;
                tmpCellHuman[1]--;
                tmpCellEmpty[0]++;
                tmpCellEmpty[1]++;
            } else if (j++ == i) {
                tmpCellHuman[0]--;
                tmpCellHuman[1]++;
                tmpCellEmpty[0]++;
                tmpCellEmpty[1]--;
            } else if (j == i) {
                tmpCellHuman[0]++;
                tmpCellHuman[1]--;
                tmpCellEmpty[0]--;
                tmpCellEmpty[1]++;
            }

            if(isNumbersValid(tmpCellEmpty[0], tmpCellEmpty[1]) &&
                    isNumbersValid(tmpCellHuman[0], tmpCellHuman[1]) &&
                    checkBlockTurn(tmpCellHuman, tmpCellEmpty))
                return tmpCellEmpty;
        }

        // Иначе просто ходим в случайную клетку вокруг последнего хода пользователя
        return getAroundRandomTurn();
    }

    private static int[] getAroundRandomTurn() {
        int[] newTurn = new int[2];

        ArrayList<int[]> emptyCells = new ArrayList<int[]>();

        // Ищем все пустые клетки вокруг последнего хода человека
        for (int i = 0; i < 8; i++) {
            int[] tmpCell = {lastTurnPosHuman[0], lastTurnPosHuman[1]};

            int j = 0;
            if (j++ == i) tmpCell[0]--;
            else if (j++ == i) tmpCell[0]++;
            else if (j++ == i) tmpCell[1]--;
            else if (j++ == i) tmpCell[1]++;
            else if (j++ == i) {
                tmpCell[0]++;
                tmpCell[1]++;
            } else if (j++ == i) {
                tmpCell[0]--;
                tmpCell[1]--;
            } else if (j++ == i) {
                tmpCell[0]--;
                tmpCell[1]++;
            } else if (j == i) {
                tmpCell[0]++;
                tmpCell[1]--;
            }

            // Если в эту клетку можно сдедать ход - запоминаем её
            if (isNumbersValid(tmpCell[0], tmpCell[1])
                    && isCellEmpty(tmpCell[0], tmpCell[1])) {
                emptyCells.add(tmpCell);
            }
        }

        if (emptyCells.size() < 1)
            newTurn = getRandomTurn();
        else
            newTurn = emptyCells.get(random.nextInt(emptyCells.size()));

        return newTurn;
    }

    private static int[] getBestTurnForAI() {
        int[] newTurn = new int[2];

        // Стараемся занять центр поля, если он ещё не занят
        newTurn[0] = (int) Math.round((MAP_SIZE / 2) + 0.1);
        newTurn[1] = (int) Math.round((MAP_SIZE / 2) + 0.1);
        if (!isCellEmpty(newTurn[0], newTurn[1]))
            newTurn = getBlockTurn();

        return newTurn;
    }

    private static void turnAI() {
        int rowNumber;
        int columnNumber;

        System.out.println("\nХод компьютера!");

        do {
            int[] newTurn = getBestTurnForAI();
            rowNumber = newTurn[0];
            columnNumber = newTurn[1];
        } while (!isCellEmpty(rowNumber, columnNumber));

        MAP[rowNumber][columnNumber] = DOT_AI;
        lastTurnPosAI[0] = rowNumber;
        lastTurnPosAI[1] = columnNumber;
        turnsCount++;
    }
}