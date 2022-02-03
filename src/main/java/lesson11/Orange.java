package lesson11;

public class Orange extends Fruit implements FruitChildMarker {
    @Override
    public double getWeight() {
        return 1.5;
    }
}
