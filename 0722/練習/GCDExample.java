import java.util.Scanner;

public class GCDExample {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入第一個整數 a：");
        int a = scanner.nextInt();

        System.out.print("請輸入第二個整數 b：");
        int b = scanner.nextInt();

        int result = gcd(a, b);
        System.out.println("最大公因數 GCD(" + a + ", " + b + ") = " + result);

        System.out.println("額外測試：");
        System.out.println("GCD(48, 18) = " + gcd(48, 18));   // 6
        System.out.println("GCD(100, 25) = " + gcd(100, 25)); // 25
        System.out.println("GCD(7, 3) = " + gcd(7, 3));       // 1

        scanner.close();
    }
}
