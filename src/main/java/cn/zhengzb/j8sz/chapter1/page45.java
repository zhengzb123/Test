package cn.zhengzb.j8sz.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/**
 * Created by zhengzb on 2019/5/5 16:03
 */
public class page45 {

    public static void main(String[] args) {

        List<Integer> result = map(Arrays.asList("asdfc","edc","sdfs"), (i)->i.length());
        List<String> result1 = map(Arrays.asList("asdfc","edc","sdfs"), (i)->"["+i.length()+"]");
        System.out.println(result);
        System.out.println(result1);



    }

    public static <T,R> List<R> map(List<T> list, Function<T, R> function){
        List<R> result = new ArrayList<>();
        list.forEach(v->{
            result.add(function.apply(v));
        });
        return result;
    }
}
