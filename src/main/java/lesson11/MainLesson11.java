package lesson11;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainLesson11 {
    public static void main(String[] args) {
        String[] arr1 = {"Слово", "Ещё одно", "Третье", "Четвёртое", "Последнее"};
        replace(arr1, 0, 1);
        System.out.println(Arrays.toString(arr1));

        ArrayList<String> arrayList1 = toArrayList(arr1);
        System.out.println(arrayList1);
    }

    // Написать метод, который меняет два элемента массива местами
    // (массив может быть любого ссылочного типа)
    private static <T> void replace(T @NotNull [] arr, int index1, int index2) {
        if ((index1 >= arr.length) || (index2 >= arr.length))
            throw new ArrayIndexOutOfBoundsException("Один из индексов отсутствует в массиве!");
        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    // Написать метод, который преобразует массив в ArrayList
    private static <T> ArrayList<T> toArrayList(T[] arr) {
        return new ArrayList<>(List.of(arr));
    }
}
