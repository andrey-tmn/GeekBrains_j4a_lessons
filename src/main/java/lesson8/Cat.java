package lesson8;

public class Cat implements Participant {
    private final int MAX_RUN = 10000;
    private final int MIN_RUN = 500;
    private final int MAX_JUMP = 350;
    private final int MIN_JUMP = 140;
    private int run;
    private int jump;
    private String name;
    private boolean atTheDistance = true;

    public Cat(String name) {
        this.name = name;
        run = (int) ((Math.random() * (MAX_RUN - MIN_RUN)) + MIN_RUN);
        jump = (int) ((Math.random() * (MAX_JUMP - MIN_JUMP)) + MIN_JUMP);
        String msg = "Кот: мяу, я — %s, бегаю до %.2f км, прыгаю до %.2f м.%n";
        System.out.printf(msg, name, (double) run / 1000, (double) jump / 100);
    }

    @Override
    public void run(int distance) {
        if (atTheDistance) {
            if (distance <= run) {
                System.out.printf("Кот %s бежит %d м.%n", name, distance);
            } else {
                atTheDistance = false;
                String s = "Кот %s бегает не более %d м, он " +
                        "не может пробежать и выбывает с дистанции.%n";
                System.out.printf(s, name, run);
            }
        }
    }

    @Override
    public void jump(int height) {
        if (atTheDistance) {
            if (height <= jump) {
                System.out.printf("Кот %s прыгает %d см.%n", name, height);
            } else {
                atTheDistance = false;
                String s = "Кот %s прыгает не выше %d см, он " +
                        "не может перепрыгнуть и выбывает с дистанции.%n";
                System.out.printf(s, name, jump);
            }
        }
    }

    @Override
    public void printFinishInfo() {
        if (atTheDistance)
            System.out.printf("%s: мяууу, я — кот и я прекрасен!%n", name);
    }
}
