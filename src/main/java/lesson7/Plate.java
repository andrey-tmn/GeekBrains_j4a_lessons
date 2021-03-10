package lesson7;

public class Plate {
    private int quantity;
    private final int MAX_QUANTITY = 50;
    private final int MIN_QUANTITY = 20;

    public Plate() {
        quantity = (int) ((Math.random() * (MAX_QUANTITY - MIN_QUANTITY)) + MIN_QUANTITY);
    }

    public boolean getFoodToCat(int cnt) {
        if (cnt > quantity)
            return false;
        else {
            quantity -= cnt;
            return true;
        }
    }

    public int addFood(int cnt) {
        quantity += cnt;
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("В тарелке сейчас %d еды.%n", quantity);
    }

    public void printInto() {
        System.out.print(this);
    }
}
