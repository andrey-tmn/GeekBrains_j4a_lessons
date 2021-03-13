package lesson9;

public class MyArraySizeException extends Exception {
    public MyArraySizeException() {
        super("Допустим массив только размера 4x4, передан массив другого размера.");
    }
}
