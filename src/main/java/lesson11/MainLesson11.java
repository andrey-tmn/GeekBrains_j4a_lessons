package lesson11;

import org.jetbrains.annotations.NotNull;

import java.awt.desktop.AppForegroundListener;
import java.util.*;

public class MainLesson11 {
    public static void main(String[] args) {
        String[] arr1 = {"Слово", "Ещё одно", "Третье", "Четвёртое", "Последнее"};
        task1(arr1);
        task2(arr1);
        task3();
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

    private static void task3() {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box<Apple> box1 = new Box();
        box1.add(apple1);
        box1.add(apple2);
        System.out.println(box1);

        Box<Apple> box2 = new Box();
        box2.add(apple3);
        System.out.println(box2);

        Box<Orange> box3 = new Box();
        box3.add(orange1);
        box3.add(orange2);
        System.out.println(box3);

        // Пересыпаем все яблоки из второй коробки в первую
        box1.addFromBox(box2);
        System.out.println("Коробка в которую пересыпали:");
        System.out.println(box1);
        System.out.println("Коробка из которой всё убрали:");
        System.out.println(box2);

        // Пересыпать из коробки с апельсинами в коробку с яблоками мы не можем
        //box1.addFromBox(box3);

        // Но сравнить их вес - можем (три яблока должны весить как два апельсина)
        System.out.println(box1.compare(box3));

        // Понимаю почему это работает, но не знаю что сделать,
        // чтобы таким образом нельзя было обойти ограничение по типу фруктов,
        // т.к. таким образом у меня в коробке лежат и апельсины и яблоки сразу
        //Box<Fruit> box4 = new Box<>();
        //box4.add(apple1);
        //box4.add(orange1);
        //System.out.println(box4);
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
