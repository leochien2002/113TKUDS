public class FactorialExample {

    public static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static String factorialExpression(int n) {
        if (n < 0) {
            return "不定義";
        }
        if (n == 0) {
            return "定義為 1（數學上正確）";
        }

        StringBuilder expression = new StringBuilder();
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
        System.out.println("factorial(3)： " + factorialExpression(3));
        System.out.println("factorial(5)： " + factorialExpression(5));
        System.out.println("factorial(0)： " + factorialExpression(0));
    }
}

