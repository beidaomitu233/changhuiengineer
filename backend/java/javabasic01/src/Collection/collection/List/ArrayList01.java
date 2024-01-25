package Collection.collection.List;

import java.util.ArrayList;
import java.util.Iterator;
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

//       containsAll 查找多个元素是否都存在
        System.out.println(list.containsAll(list2));

//        删除多个元素
        list.removeAll(list2);

        System.out.println(list);

        Iterator iterator=list.iterator();
        while (iterator.hasNext()) {
//          编译类型设置为Object类可以接收所有的运行类型的子类。
            Object next =  iterator.next();
            System.out.println("obj="+next);
        }

        for (Object o : list) {
            System.out.println(o);
        }

//       List接口单独的特征

        list.add(2,"第一个元素");
        System.out.println(list);

        System.out.println("查找元素位置");
        System.out.println(list.indexOf('d'));

        System.out.println("获取元素");
        System.out.println(list.get(2));

        System.out.println("获取位置是最后一个所查找的元素");
        System.out.println(list.lastIndexOf(213));

        System.out.println("删除固定位置id元素，并返回");
        System.out.println(list.remove(1));

        System.out.println("替换某个位置的元素值，需要存在");
        list.set(2, "重新设置");
        System.out.println(list);

        System.out.println("截取一个区间的内容，左开右闭区间");
        System.out.println(list.subList(0, 3));


    }
}
