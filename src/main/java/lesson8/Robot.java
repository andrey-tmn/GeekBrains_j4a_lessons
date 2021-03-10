package lesson8;

public class Robot implements Participant {
    private final int MAX_RUN = 500;
    private final int MIN_RUN = 50;
    private final int MAX_JUMP = 100;
    private final int MIN_JUMP = 30;
    private int run;
    private int jump;
    private String name;

    public Robot(String name) {
        this.name = name;
        run = (int) ((Math.random() * (MAX_RUN - MIN_RUN)) + MIN_RUN);
        jump = (int) ((Math.random() * (MAX_JUMP - MIN_JUMP)) + MIN_JUMP);
        String msg = "Робот: скрежет со стороны %s, он бегает до %.2f км, прыгает до %.2f м.%n";
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
