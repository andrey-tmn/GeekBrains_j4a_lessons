package lesson8;

public abstract class Obstacle {
    protected int value;

    public Obstacle(final int MIN_VAL, final int MAX_VAL) {
        this.value = (int) ((Math.random() * (MAX_VAL - MIN_VAL)) + MIN_VAL);
    }

    abstract public void printInfo();
    abstract public void overcome(Participant participant);
}
