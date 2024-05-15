import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    // 修改方法以接受三个参数，并返回三角形的类型作为字符串
    public String TriangleType(int a, int b, int c) {
        // 检查是否能构成三角形
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "非三角形";
        }

        // 判断三角形类型
        if (a == b && b == c) {
            return "等边三角形";
        } else if (a == b || a == c || b == c) {
            return "等腰三角形";
        } else {
            return "一般三角形";
        }
    }

    @Test
    public void testCheckTriangleType() {

        // 测试等边三角形
        System.out.println(  TriangleType(3, 3, 3));

        // 测试等腰三角形
        System.out.println(TriangleType(5, 6, 6)); // 应输出 "等腰三角形"

        // 测试一般三角形
        System.out.println(TriangleType(6, 7, 9)); // 应输出 "一般三角形"

        // 测试非三角形
        System.out.println(TriangleType(1, 2, 3)); // 应输出 "非三角形"

    }
}


