package cn.zhengzb.lambda;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * java8 中map 的使用
 * Created by zhengzb on 2019/3/10 13:37
 */
public class MapTest1 {

    public static void main(String[] args) {

        //上面的代码风格是完全自解释的：putIfAbsent避免我们将null写入；forEach接受一个消费者对象，从而将操作实施到每一个map中的值上。
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.putIfAbsent(i, "val" + i);
        }
        map.forEach((id, val) -> System.out.println(val));


        map.computeIfPresent(3, (num, val) -> val + num);
        System.out.println(map.get(3)); // val33


        map.remove(3, "val3");
        System.out.println(map.get(3)); // val33

        map.remove(3, "val33");
        System.out.println(map.get(3)); // null


        System.out.println(map.getOrDefault(42, "not found")); // not found


        //将map中的实例合并也是非常容易的：
        map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
        System.out.println(map.get(9)); // val9val9


    }
}
