package lesson6;

public class Cat extends Animal {
    private static int cnt = 0;
    private final int MAX_RUN_DISTANCE = 200;

    public Cat(String name) {
        super(name);
        cnt++;
    }

    @Override
    public void run(int distance) {
        if (MAX_RUN_DISTANCE >= distance)
            System.out.printf("Кот %s пробежал %d м.%n", super.name, distance);
        else
            System.out.printf("Кот %s не может пробежать больше %d m.%n",
                    super.name, MAX_RUN_DISTANCE);
    }

    @Override
    public void swim(int distance) {
        // Это не правда, коты плавают, но таково задание
        System.out.printf("Коты не умеют плавать, кот %s в том числе.%n", super.name);
    }

    public static int getCnt() {
        return cnt;
    }
}
