package lesson7;

import cat.names.CatNames;
import java.io.IOException;

public class MainLesson7 {
    public static void main(String[] args) throws IOException {
        final int CATS_CNT = 10;

        Plate plate = new Plate();
        plate.printInto();
        System.out.println("Покормили котов.");
        System.out.println();
        Cat[] cats = new Cat[CATS_CNT];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat(CatNames.getCatName());
            cats[i].eat(plate);
            cats[i].printSatiety();
        }
        System.out.println();

        final int MIN_CNT_ADD = 25;
        final int MAX_CNT_ADD = 100;
        int addFoodCnt = (int) ((Math.random() * (MAX_CNT_ADD - MIN_CNT_ADD)) + MIN_CNT_ADD);
        plate.addFood(addFoodCnt);
        System.out.printf("Добавляем в тарелку %d еды.%n", addFoodCnt);
        plate.printInto();
        System.out.println("Покормили котов.");
        System.out.println();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].printSatiety();
        }
    }
}
