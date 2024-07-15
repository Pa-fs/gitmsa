package ex07;

public class Ex03 {

    public static void main(String[] args) {
        int[][] nums = { {11}, {11,22}, {11,22,33}};

        System.out.println(nums.length);
        System.out.println(nums[0].length);
        System.out.println(nums[1].length);
        System.out.println(nums[2].length);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                System.out.print(nums[i][j]);
            }
            System.out.println();
        }
    }
}
