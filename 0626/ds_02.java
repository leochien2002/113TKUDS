import java.util.Scanner;

public class ds_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("請輸入圓的半徑：");
        double radius = scanner.nextDouble();

        double area = Math.PI * Math.pow(radius, 2);

        System.out.printf("半徑為 %.2f 的圓，其面積為 %.4f%n", radius, area);

        scanner.close();
    }
}
