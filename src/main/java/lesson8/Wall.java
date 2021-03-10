package lesson8;

public class Wall extends Obstacle {
    private String msg = "Стена высотой %.2f м.%n";

    public Wall() {
        super(10, 150);
        printInfo();
    }

    @Override
    public String toString() {
        return String.format(msg, (double) super.value / 100);
    }

    @Override
    public void printInfo() {
        System.out.print(this);
    }

    @Override
    public void overcome(Participant participant) {
        participant.jump(super.value);
    }
}
