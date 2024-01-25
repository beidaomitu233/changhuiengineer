package Collection.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMap01 {
    public static void main(String[] args) {
        Map HashMap001=new HashMap();

        /**
         *  key的相同由hash计算的得出，如果hash值相同就是一样的
         *
         * key不可以相同，value可以相同。
         * null也是一样的规则。
         *
         * **/
        HashMap001.put("书名","哈利波特：圣器");
        HashMap001.put("书名","哈利波特：圣火");

        HashMap001.put(new Object(),new Halibote("hali"));

        System.out.println(HashMap001);



    }
}

 class MapMethodsDemo {
    public static void main(String[] args) {
        // 创建一个HashMap实例
        Map<String, Integer> map = new HashMap<>();

        // 添加元素
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);

        // 显示集合大小
        System.out.println("Size of the map: " + map.size());

        // 判断是否包含某个键
        System.out.println("Does map contain 'Apple'? " + map.containsKey("Apple"));

        // 根据键获取值
        System.out.println("Value associated with 'Apple': " + map.get("Apple"));

        // 判断是否包含某个值
        System.out.println("Does map contain the value 2? " + map.containsValue(2));

        // 删除元素
        map.remove("Banana");
        System.out.println("After removing 'Banana': " + map);

        // 清空整个Map
        map.clear();
        System.out.println("After clearing the map: " + map);

        // 遍历Map
        map.put("Apple", 1);
        map.put("Banana", 2);
        for (Map.Entry entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 使用键集合遍历
        for (String key : map.keySet()) {
            System.out.println("Key: " + key);
        }

        // 使用值集合遍历
        for (Integer value : map.values()) {
            System.out.println("Value: " + value);
        }

        //使用遍历器
//       这是entey里面的方法keySet()
//       通过key获取value
        Set keyset =map.keySet();
        Iterator iterator=keyset.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            System.out.println(key+"-"+map.get(key));
            
        }
    }
}
