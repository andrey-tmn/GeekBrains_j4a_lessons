package lesson5;

public class MainLesson5 {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person("Мацюк Андрей Николаевич",
                    "Веб-разработчик №" + (i + 1),
                    "info@mtostudio.com", "8-800-555-84-19",
                    random(50000) + 50000, random(52) + 18);
        }
        // Выводим всех, кто старше 40
        for (int i = 0; i < persons.length; i++) {
            if(persons[i].older(40))
                persons[i].printInfo();
        }
    }
    
    // Сгенерировать случайное положительное целое число
    // от 0 (включительно) до max (невключительно)
    private static int random(int max) {
        if (max <= 1) return 0;
        return (int) (Math.random() * max);
    }
}
