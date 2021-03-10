package lesson8;

public class RunningTrack extends Obstacle {
    private String msg = "Беговая дорожка длиной %.2f км.%n";

    public RunningTrack() {
        super(500, 5000);
        printInfo();
    }

    @Override
    public String toString() {
        return String.format(msg, (double) super.value / 1000);
    }

    @Override
    public void printInfo() {
        System.out.print(this);
    }

    @Override
    public void overcome(Participant participant) {
        participant.run(super.value);
    }
}
