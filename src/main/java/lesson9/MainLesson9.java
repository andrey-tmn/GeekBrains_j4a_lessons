package lesson9;

public class MainLesson9 {
    public static void main(String[] args) {
        final int ARRAY_SIZE_I = 4;
        final int ARRAY_SIZE_J = 4;
        String[][] arr = new String[ARRAY_SIZE_I][ARRAY_SIZE_J];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = String.valueOf((int) (Math.random() * 100));
            }
        }

        // Расскомментировать для проверки MyArrayDataException
        //arr[1][1] = "НЕ ЧИСЛО";

        try {
            System.out.printf(
                    "Посчитали сумму массива 4х4, она равна = %d.%n",
                    arraySumWrap(arr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int arraySumWrap(String[][] arr)
            throws MyArraySizeException, MyArrayDataException {
        if (4 != arr.length)
            throw new MyArraySizeException();
        for (int i = 0; i < arr.length; i++) {
            if(4 != arr[i].length)
                throw new MyArraySizeException();
        }

        return arraySum(arr);
    }

    private static int arraySum(String[][] arr) throws MyArrayDataException {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    res += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return res;
    }
}
