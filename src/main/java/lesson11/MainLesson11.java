package lesson11;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class MainLesson11 {
    public static void main(String[] args) {
        String[] arr1 = {"Слово", "Ещё одно", "Третье", "Четвёртое", "Последнее"};
        task1(arr1);
        task2(arr1);

        additional_task();
    }

    private static void task1(String[] arr1) {
        replace(arr1, 0, 1);
        System.out.println(Arrays.toString(arr1));
    }

    private static void task2(String[] arr1) {
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

    private static void additional_task() {
        Collection<String> collection = new ArrayList<>();
        collection.add("Слово первое");
        collection.add("Слово второе");
        collection.add("Слово одинаковое");
        collection.add("Слово одинаковое");
        collection.add("Слово последнее");
        collection = uniqueCollection(collection);
        System.out.println(collection);
    }

    // Дополнительная задача по коллекциям:
    // Напишите метод, который на вход получает коллекцию объектов,
    // а возвращает коллекцию уже без дубликатов
    private static <T> Collection<T> uniqueCollection(Collection<T> collection) {
        return new HashSet<>(collection);
    }
}
