package ex02;

/**
 *  1 + (-2) + 3 + (-4) + .... 같은 식으로 더해나갔을때,
 *  몇까지 더해야 총합이 100이상이 되는지 구하시오
 */
public class Ex01 {

    public static void main(String[] args) {
        int sum = 0;
        int i = 0;
        for (; i < 300; i++) {
            if(i % 2 == 1) {
                sum = sum + i;
            } else {
                sum = sum + (-i);
            }
            System.out.println("i= " + i);
            System.out.println("sum = " + sum);
            if(sum == 100) break;
        }
        System.out.println(i);
    }
}
