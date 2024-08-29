package ex_240827;

import java.util.List;

public class Ex07 {

    public static void main(String[] args) {

        MemberRepository repository = new MemberRepository();

        List<Member> list = repository.select();
        list.stream()
                .forEach(s -> System.out.println(s));
    }
}
