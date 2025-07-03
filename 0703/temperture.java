import java.util.Scanner;

public class temperture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入攝氏溫度：");
        double celsius = scanner.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("華氏溫度是：" + fahrenheit);

        scanner.close();
    }
}
