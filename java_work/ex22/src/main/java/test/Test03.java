package test;

import java.util.Arrays;
import java.util.Collections;

public class Test03 {

    private int[] solution(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());

        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 1, 3};

//        int[] clone = solution(arr);
    }
}
