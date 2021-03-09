package lesson6;

public class Dog extends Animal {
    private static int cnt = 0;

    public Dog(String name) {
        super(name, 500, 10, "Пёс");
        cnt++;
    }

    public static int getCnt() {
        return cnt;
    }
}
