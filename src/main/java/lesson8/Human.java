package lesson8;

public class Human implements Participant {
    private final int MAX_RUN = 50000;
    private final int MIN_RUN = 1000;
    private final int MAX_JUMP = 180;
    private final int MIN_JUMP = 110;
    private int run;
    private int jump;
    private String name;

    public Human(String name) {
        this.name = name;
        run = (int) ((Math.random() * (MAX_RUN - MIN_RUN)) + MIN_RUN);
        jump = (int) ((Math.random() * (MAX_JUMP - MIN_JUMP)) + MIN_JUMP);
        String msg = "Человек: я участвую, меня зовут %s, бегаю до %.2f км, прыгаю до %.2f м.%n";
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
