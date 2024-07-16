package ex08;

// Person
class Person {
    private String name;
    private int age;

    public void greeting() {
        System.out.println(this.name + " hello");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Ex01 {

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        p1.setName("나");
        p1.setAge(30);
        p2.setName("너");
        p2.setAge(25);

        p1.greeting();
        p2.greeting();
    }
}
