import java.util.Scanner;

public class searchnumberbinary {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要查找的數字: ");
        int x = scanner.nextInt();

        int left = 0;
        int right = s.length - 1;
        boolean found = false;

        System.out.println("開始二分搜尋：");
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("比對中間索引 " + mid + "，值為 " + s[mid]);

            if (s[mid] == x) {
                found = true;
                break;
            } else if (s[mid] < x) {
                System.out.println("目標數字大於 " + s[mid] + "，往右半邊找");
                left = mid + 1;
            } else {
                System.out.println("目標數字小於 " + s[mid] + "，往左半邊找");
                right = mid - 1;
            }
        }

        if (found) {
            System.out.println("結果：yes，找到目標數字 " + x);
        } else {
            System.out.println("結果：no，未找到目標數字 " + x);
        }

        scanner.close();
    }
}
