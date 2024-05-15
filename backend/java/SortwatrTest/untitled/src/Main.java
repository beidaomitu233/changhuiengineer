import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, c;

        // 输入三条边
        System.out.println("请输入三角形的三条边长：");
        if (!scanner.hasNextInt() || (a = scanner.nextInt()) < 1 || a > 100) {
            System.out.println("请输入1～100之间的整数");
            return;
        }
        if (!scanner.hasNextInt() || (b = scanner.nextInt()) < 1 || b > 100) {
            System.out.println("请输入1～100之间的整数");
            return;
        }
        if (!scanner.hasNextInt() || (c = scanner.nextInt()) < 1 || c > 100) {
            System.out.println("请输入1～100之间的整数");
            return;
        }

        // 检查是否能构成三角形
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("非三角形");
            return;
        }

        // 判断三角形类型
        if (a == b && b == c) {
            System.out.println("等边三角形");
        } else if (a == b || a == c || b == c) {
            System.out.println("等腰三角形");
        } else {
            System.out.println("一般三角形");
        }
    }
}