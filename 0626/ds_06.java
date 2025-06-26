import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        int[] nums = new int[10];
        Random rand = new Random();
        System.out.print("隨機數值：");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(100);
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        System.out.println("最大值是：" + max);
    }
}
