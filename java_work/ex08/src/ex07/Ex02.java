package ex07;

import java.util.Arrays;

public class Ex02 {

    public static void main(String[] args) {
        int[][] nums = new int[3][3];
        int tmp = 10;
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(nums[i], tmp);
            tmp = tmp + 10;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int[] tmpArr;
            tmpArr = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmpArr;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
}
