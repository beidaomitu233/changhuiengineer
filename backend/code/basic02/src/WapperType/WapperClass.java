package WapperType;

public class WapperClass {
    public static void main(String[] args) {
        // 原始数据类型变量
        int primitiveInt = 10;
// 或者使用valueOf静态方法进行装箱
        Integer wrapperInt2 = Integer.valueOf(primitiveInt);

        System.out.println(wrapperInt2.getClass());

// 手动拆箱：使用包装类对象的intValue()方法将包装类对象转换回基本数据类型
        int primitiveValue = wrapperInt2.intValue();
        System.out.println(primitiveValue);



    }
}
