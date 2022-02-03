package lesson11;

public class Apple extends Fruit implements FruitChildMarker {
    @Override
    public double getWeight() {
        return 1.0;
    }
}
