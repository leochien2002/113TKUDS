import java.util.Scanner;

public class additionb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int intValue = scanner.nextInt();
        
        double doubleValue = scanner.nextDouble();
        
        double result = intValue + doubleValue;
        
        System.out.printf("%.2f\n", result);
        
        scanner.close();
    }
}
