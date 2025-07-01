import java.util.Scanner;

public class searchnumber {
    public static void main(String[] args) {
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入要查找的數字: ");
        int x = scanner.nextInt();

        boolean found = false;

        System.out.println("開始對比：");
        for (int i = 0; i < s.length; i++) {
            System.out.println("比對第 " + (i + 1) + " 個元素，值為 " + s[i]);
            if (s[i] == x) {
                found = true;
                break;
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

