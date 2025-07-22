import java.util.Scanner;

public class FibonacciExample {

    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("請輸入 n（求第 n 項費波納契數）：");
        int n = sc.nextInt();
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));

        System.out.println("Fibonacci(0) = " + fibonacci(0));
        System.out.println("Fibonacci(1) = " + fibonacci(1));
        System.out.println("Fibonacci(5) = " + fibonacci(5));
        System.out.println("Fibonacci(10) = " + fibonacci(10));
        sc.close();
    }
}
