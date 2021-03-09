package lesson5;

public class Person {
    private String name;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Person(String name, String position, String email,
                  String phone, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        if (age > 0)
            this.age = age;
    }

    public void printInfo() {
        String msg = "%s (%s, %s), должность: %s, возраст: %d. ЗП %.2f.%n";
        System.out.printf(msg, name, phone, email, position, age, salary);
    }

    public boolean older(int age){
        return this.age > age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18)
            this.age = age;
        else
            System.err.println("У нас сотрудник не может быть младше 18 лет!");
    }
}
