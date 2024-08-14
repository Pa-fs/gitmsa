package ex_240813;

//글자 갯수 순서로
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        for (int i = 0; i < Math.min(this.name.length(), o.name.length()) ; i++) {
            if(this.name.codePointAt(i) - o.name.codePointAt(i) != 0) {
                return this.name.codePointAt(i) - o.name.codePointAt(i);
            }
        }
        return this.name.length() - o.name.length();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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
