package lesson6;

public class Dog extends Animal {
    private static int cnt = 0;
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
        cnt++;
    }

    @Override
    public void run(int distance) {
        if (MAX_RUN_DISTANCE >= distance)
            System.out.printf("Пёс %s пробежал %d м.%n", super.name, distance);
        else
            System.out.printf("Пёс %s не может пробежать больше %d m.%n",
                    super.name, MAX_RUN_DISTANCE);
    }

    @Override
    public void swim(int distance) {
        if (MAX_SWIM_DISTANCE >= distance)
            System.out.printf("Пёс %s проплыл %d м.%n", super.name, distance);
        else
            System.out.printf("Пёс %s не может проплыть больше %d m.%n",
                    super.name, MAX_SWIM_DISTANCE);
    }

    public static int getCnt() {
        return cnt;
    }
}
