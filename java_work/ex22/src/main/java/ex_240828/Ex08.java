package ex_240828;

import java.util.Optional;

public class Ex08 {

    public static void main(String[] args) {

        Optional<String> os1 = Optional.of("안녕하세요!! ddd ");

        // map 함수를...flatMap
        // Optional flatMap 함수를 사용하면 Optional 를 직접 감싸야 한다
        String str = os1
                .flatMap(s -> Optional.of("바뀌는걸 Optional로 감싸야..."))
                .orElse("NONE");

        System.out.println(str);
    }
}
