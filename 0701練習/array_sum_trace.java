public class array_sum_trace{
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        int total = 0;

        for (int i = 0; i < arr.length; i++) {
            System.out.println("加總過程：total = " + total + " + " + arr[i] + " = " + (total + arr[i]));
            total += arr[i];
        }

        System.out.println("總和為：" + total);
    }
}
//這段程式對每個陣列元素執行一次加法運算與輸出，因此其時間複雜度為 O(n)，其中 n 是陣列長度。
//每個元素處理一次（加法與印出），線性關係。
//若陣列長度加倍，執行時間也大致加倍。


