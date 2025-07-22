public class FibonacciComparison {

    public static int fibonacciSlow(int n) {
        if (n <= 1) return n;
        return fibonacciSlow(n - 1) + fibonacciSlow(n - 2);
    }

    public static int fibonacciFast(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciFast(n - 1, memo) + fibonacciFast(n - 2, memo);
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 40;

        long start = System.currentTimeMillis();
        int slowResult = fibonacciSlow(n);
        long end = System.currentTimeMillis();
        System.out.println("Slow Fibonacci(" + n + ") = " + slowResult + ", time: " + (end - start) + " ms");

        int[] memo = new int[n + 1];
        start = System.currentTimeMillis();
        int fastResult = fibonacciFast(n, memo);
        end = System.currentTimeMillis();
        System.out.println("Fast Fibonacci(" + n + ") = " + fastResult + ", time: " + (end - start) + " ms");
    }
}
