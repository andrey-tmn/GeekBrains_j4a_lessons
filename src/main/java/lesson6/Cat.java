package lesson6;

public class Cat extends Animal {
    private static int cnt = 0;

    public Cat(String name) {
        super(name, 200, 0, "Кот");
        cnt++;
    }

    public static int getCnt() {
        return cnt;
    }
}
