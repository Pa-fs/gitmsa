package ex09;

public class StringMethodStringBuilder {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append("asdfsf");
        sb.append("asdfsf");
        sb.append("asdfsf");

        System.out.println(sb);

        sb.delete(0, 2);
        System.out.println(sb);

        sb.replace(0, 5, "kkk");
        sb.reverse();
        String res = sb.toString();
        System.out.println(res);
    }
}
