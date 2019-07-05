package cn.zhengzb.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 流操作测试
 * Created by zhengzb on 2019/3/9 13:17
 */
public class StreamTest1 {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,4,3,5,6,1,2);

        //map用户映射流中的每一个元素到结果
        numbers.stream().map(v->v * v).forEach(System.out::println);

        //filter用户过滤流中的元素
        numbers.stream().filter(v->v>2).forEach(System.out::println);

        //limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
        System.out.println("--------------------------------------------------");
        Random random = new Random();
        random.ints().limit(3).forEach(System.out::println);

        //sorted 方法用于对流进行排序
        System.out.println("--------------------------------------------------");
        random.ints().limit(10).sorted().forEach(System.out::println);


        //并行（parallel）程序
        //parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出空字符串的数量：
        System.out.println("--------------------------------------------------");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.parallelStream().filter(v->v.isEmpty()).count();
        System.out.println(count);


        //Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素
        strings.stream().filter(v->v.isEmpty()).collect(Collectors.toList());

        System.out.println("--------------------------------------------------");
        List<String> string1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        //合并字符串
        String str2 = string1.stream().filter(v->!v.isEmpty()).collect(Collectors.joining(" , "));
        System.out.println(str2);


        //计算集合中所有数之和
        System.out.println("-----------------------------------------------------");
        List<Integer> sumList = Arrays.asList(1,4,2,4,5);
        int sum = sumList.stream().mapToInt(v->v).sum();
        System.out.println(sum);

    }
}
