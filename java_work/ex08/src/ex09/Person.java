package ex09;

public class Person {

    private String idNumber;
    private String passport;

    public Person() {
    }

    public Person(String idNumber) {
        this();
        this.idNumber = idNumber;
        passport = "";
    }

    public Person(String idNumber, String passport) {
        this(idNumber);
        this.passport = passport;
    }

    public void show() {
        System.out.println("idNumber= " + idNumber);
        System.out.println("passport= " + passport);
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNumber='" + idNumber + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
