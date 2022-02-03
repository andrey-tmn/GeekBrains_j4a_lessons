package lesson11;

import java.util.ArrayList;

public class Box<T extends Fruit & FruitChildMarker> {
    private ArrayList<T> fruits = new ArrayList<>();
    private double weight = 0;

    public void add(T addFruits) {
        fruits.add(addFruits);
        weight += addFruits.getWeight();
    }

    private void clear() {
        fruits.clear();
        weight = 0;
    }

    private ArrayList<T> getAll() {
        return fruits;
    }

    public void addFromBox(Box<T> sourceBox) {
        if (sourceBox.equals(this)) {
            return;
        }

        fruits.addAll(sourceBox.getAll());
        weight += sourceBox.getWeight();
        sourceBox.clear();
    }

    public double getWeight() {
        return weight;
    }

    public boolean compare(Box<?> compareBox) {
        return Math.abs(this.weight - compareBox.getWeight()) < 0.0000001;
    }

    @Override
    public String toString() {
        return "Коробка с весом " + getWeight() + ", фруктов в ней " + fruits.size();
    }
}
