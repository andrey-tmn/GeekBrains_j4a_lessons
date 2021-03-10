package lesson8;

public class Wall extends Obstacle {
    private final int MAX_VAL = 150;
    private final int MIN_VAL = 10;

    public Wall() {
        super();
        value = (int) ((Math.random() * (MAX_VAL - MIN_VAL)) + MIN_VAL);
        String msg = "Человек: я участвую, меня зовут %s, бегаю до %.2f км, прыгаю до %.2f м.%n";
        System.out.printf(msg, name, (double) run / 1000, (double) jump / 100);
    }

}
