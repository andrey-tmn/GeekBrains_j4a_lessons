package lesson9;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int i, int j) {
        super(String.format(
                "В ячейке [%d][%d] значение, которое невозможно привести к целому числу.",
                i, j));
    }
}
