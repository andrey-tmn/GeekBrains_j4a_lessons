package lesson12;


import java.sql.Array;
import java.util.Arrays;

public class MainLesson12 {

    static final int SIZE = 10_000_000;
    static final int HALF = SIZE / 2;
    static final Object monitor = new Object();
    static float[] arr1;
    static float[] arr2 = new float[SIZE];

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        arr1 = doMathOperationInMainThread();

        long timeOfWork = System.currentTimeMillis() - startTime;

        System.out.printf("Однопоточный вариант исполнялся %d мс%n", timeOfWork);

        startTime = System.currentTimeMillis();

        doMathOperationInTwoThreads();

        timeOfWork = System.currentTimeMillis() - startTime;
        System.out.printf("Вариант в два потока исполнялся %d мс%n", timeOfWork);

        boolean arraysEqual = Arrays.equals(arr1, arr2);
        System.out.printf("Массивы одинаковые, всё верно: %b%n", arraysEqual);

        int count = 10;
        float[] arr = new float[count];
        System.arraycopy(arr1, 0, arr, 0, count);

        System.out.printf("Первые %d элементов массива:%n", count);
        System.out.println(Arrays.toString(arr));
    }

    private static void doMathOperationInTwoThreads() {
        Thread t1 = new Thread(() -> {
            float[] arr = createAndFillArray(HALF, 0);
            synchronized (monitor) {
                System.arraycopy(arr, 0, arr2, 0, HALF);
            }
        });
        Thread t2 = new Thread(() -> {
            float[] arr = createAndFillArray(HALF, HALF);
            synchronized (monitor) {
                System.arraycopy(arr, 0, arr2, HALF, HALF);
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static float[] doMathOperationInMainThread() {
        return createAndFillArray(SIZE, 0);
    }

    private static float[] createAndFillArray(int size, int startCalcI) {
        float[] arr = new float[size];

        Arrays.fill(arr, 1);

        for (int i = 0; i < arr.length; i++) {
            int iInFormula = startCalcI + i;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + iInFormula / 5) * Math.cos(0.2f + iInFormula / 5) * Math.cos(0.4f + iInFormula / 2));
        }

        return arr;
    }
}
