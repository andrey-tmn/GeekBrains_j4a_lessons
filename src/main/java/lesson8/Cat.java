package lesson8;

public class Cat implements Participant{
    private final int MAX_RUN = 3000;
    private final int MIN_RUN = 200;
    private final int MAX_JUMP = 300;
    private final int MIN_JUMP = 120;
    private int run;
    private int jump;
    private String name;

    public Cat(String name) {
        this.name = name;
        run = (int) ((Math.random() * (MAX_RUN - MIN_RUN)) + MIN_RUN);
        jump = (int) ((Math.random() * (MAX_JUMP - MIN_JUMP)) + MIN_JUMP);
        String msg = "Кот: мяу, я — %s, бегаю до %.2f км, прыгаю до %.2f м.%n";
        System.out.printf(msg, name, (double) run / 1000, (double) jump / 100);
    }

    @Override
    public void run() {

    }

    @Override
    public void jump() {

    }

    @Override
    public void go(Obstacle obstacle) {

    }
}
