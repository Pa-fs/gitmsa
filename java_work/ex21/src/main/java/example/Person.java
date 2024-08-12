package example;

// 클래스 객체 정렬은 comparable compareTo 사용해야 한다
// person 클래스를 배열로 가져오게 되면...
public class Person implements Comparable{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public int compareTo(Object o) {
//        System.out.println("this = " + this);
//        System.out.println(this.age);
//        System.out.println(((Person)o).age);
        // 1. 방법) 양수가 앞으로 온다
//        if (this.age > ((Person) o).age) {
//            return -1;
//        } else if(this.age < ((Person) o).age){
//            return 1;
//        }
//        return 0;
        // 2. 방법) this쪽 앞 오름차순
        // 반대 내림차순
        return this.age - ((Person) o).age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
