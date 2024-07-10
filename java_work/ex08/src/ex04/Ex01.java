package ex04;

class A{}
public class Ex01 {

    // int double float
    // String
    public static void main(String[] args) {
        A a = new A();
        A b = a;
        System.out.println(a==b);

        String str1 = new String("happy");
        String str2 = "happy";
        String str3 = "happy";

        System.out.println(str1 + " " + str2);
        System.out.println(str1 == str2);
        System.out.println(str2 == str3);
    }
}
