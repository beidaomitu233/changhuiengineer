package Collection.collection.List;

import java.util.ArrayList;
import java.util.List;

public class ArrayList01 {

    public static void main(String[] args) {
        //屏蔽警告
        @SuppressWarnings({"all"})
        //        向上转型
        List list=new ArrayList();

//      添加元素
        list.add("beidao");
        list.add('d');
        list.add(213);
        list.add(true);
        list.add('d');
        list.add(213);
        list.add(true);

        System.out.println(list);

//        删除元素
        list.remove(true);
        list.remove(1);

        System.out.println(list);

//       查找是否包含元素
        System.out.println(list.contains('d'));
        System.out.println(list.contains(213));

//        获取元素个数
        System.out.println(list.size());

//       判断元素是否为空
        System.out.println(list.isEmpty());

//       清空
//        list.clear();

//        添加多个元素
//        实现了collection集合的都可以直接添加

        List list2=new ArrayList();

        list2.add("dasda");
        list2.add("大闹三国");

        list.addAll(list2);

        System.out.println(list);


    }
}
