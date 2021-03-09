package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private final int MAX_APPETITE = 25;
    private final int MIN_APPETITE = 5;
    private final String satietyMsgTemplate = "Кот %s (аппетит %d) %s.%n";
    private boolean satiety = false;

    public Cat(String name) {
        this.name = name;
        appetite = (int) ((Math.random() * (MAX_APPETITE - MIN_APPETITE)) + MIN_APPETITE);
    }

    public void eat(Plate plate) {
        if(!satiety)
            satiety = plate.getFoodToCat(appetite);
    }

    @Override
    public String toString() {
        String msg = "сыт";
        if (!satiety)
            msg = "ещё голоден";
        return String.format(satietyMsgTemplate, name, appetite, msg);
    }

    public void printSatiety() {
        System.out.print(this);
    }
}
