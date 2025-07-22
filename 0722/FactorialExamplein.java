import java.util.Scanner;

public class FactorialExamplein {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static String factorialExpression(int n) {
        if (n < 0) {
            return "錯誤：階乘僅定義在非負整數上。";
        }
        if (n == 0) {
            return "factorial(0)：定義為 1（數學上正確）";
        }

        StringBuilder expression = new StringBuilder();
        expression.append("factorial(").append(n).append(")：");

        for (int i = n; i > 0; i--) {
            expression.append(i);
            if (i > 1) {
                expression.append(" × ");
            }
        }

        expression.append(" = ").append(factorial(n));
        return expression.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入一個非負整數：");
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            System.out.println(factorialExpression(number));
        } else {
            System.out.println("輸入錯誤：請輸入一個整數。");
        }

        scanner.close();
    }
}
