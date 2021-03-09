package lesson6;

public class MainLesson6 {
    public static void main(String[] args) {
        String[] catNames = {"Василь", "Барсик", "Кроть", "Киса", "Борис", "Рыжик", "Серька"};
        String[] dogNames = {"Джек", "Майк", "Боби", "Персик", "Бой", "Байгус", "Север"};
        final int ANIMALS_CNT = 10;

        Animal[] animals = new Animal[ANIMALS_CNT];

        for (int i = 0; i < animals.length; i++) {
            if (Math.random() > 0.5) {
                Dog tmpDog = new Dog(dogNames[random(dogNames.length)]);
                animals[i] = tmpDog;
            } else {
                Cat tmpCat = new Cat(catNames[random(catNames.length)]);
                animals[i] = tmpCat;
            }

            animals[i].run(random(50,550));
            animals[i].swim(random(1,15));
            System.out.println("");
        }

        String msg = "Всего у нас %d животных, из них котов — %d, собак — %d.%n";
        System.out.printf(msg, animals.length, Cat.getCnt(), Dog.getCnt());
    }

    private static int random(int min, int max) {
        int delta = max - min;
        return random(delta) + min;
    }

    private static int random(int max) {
        if (max <= 1) return 0;
        return (int) (Math.random() * max);
    }
}
