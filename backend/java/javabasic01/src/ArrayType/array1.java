package ArrayType;

import java.util.Arrays;
import java.util.Comparator;

public class array1 {
    public static void main(String[] args) {

        Integer[] integerArray = {213, 3, 1212, 3};

        Arrays.sort(integerArray,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });

        System.out.println(Arrays.toString(integerArray));

        // 使用Lambda表达式简化匿名内部类的写法
        Arrays.sort(integerArray, (o1, o2) -> o1 - o2);
        System.out.println(Arrays.toString(integerArray));


    }
}
