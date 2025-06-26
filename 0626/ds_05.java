public class ds_05 {
    public static void main(String[] args) {
        int[] nums = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        System.out.println("陣列所有元素的總和為：" + sum);
    }
}
