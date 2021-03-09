package lesson6;

public abstract class Animal {
    protected String name;
    protected int MAX_RUN_DISTANCE;
    protected int MAX_SWIM_DISTANCE;
    protected String animalType;

    protected Animal(String name, int MAX_RUN_DISTANCE, int MAX_SWIM_DISTANCE, String animalType) {
        this.name = name;
        this.MAX_RUN_DISTANCE = MAX_RUN_DISTANCE;
        this.MAX_SWIM_DISTANCE = MAX_SWIM_DISTANCE;
        this.animalType = animalType;
    }

    public Animal(String name) {
        this(name, 0, 0, "Животное");
    }

    public void run(int distance) {
        if (MAX_RUN_DISTANCE <= 0)
            System.out.printf("%s не умеет бегать, в т.ч. %s.%n", animalType, name);
        else if (MAX_RUN_DISTANCE >= distance)
            System.out.printf("%s %s пробежал %d м.%n", animalType, name, distance);
        else
            System.out.printf("%s %s не может пробежать больше %d м.%n",
                    animalType, name, MAX_RUN_DISTANCE);
    }

    public void swim(int distance) {
        if (MAX_SWIM_DISTANCE <= 0)
            System.out.printf("%s не умеет плавать, в т.ч. %s.%n", animalType, name);
        else if (MAX_SWIM_DISTANCE >= distance)
            System.out.printf("%s %s проплыл %d м.%n", animalType, name, distance);
        else
            System.out.printf("%s %s не может проплыть больше %d м.%n",
                    animalType, name, MAX_SWIM_DISTANCE);
    }
}
