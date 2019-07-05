package cn.zhengzb.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 使用jdk1.7  和jdk1.8 进行排序
 * Created by zhengzb on 2019/3/3 22:45
 */
public class SortTest {

    public static void main(String[] args) {
        List<String> names1 = new ArrayList<String>();
        names1.add("Google ");
        names1.add("Runoob ");
        names1.add("Taobao ");
        names1.add("Baidu ");
        names1.add("Sina ");

        List<String> names2 = new ArrayList<String>();
        names2.add("Google ");
        names2.add("Runoob ");
        names2.add("Taobao ");
        names2.add("Baidu ");
        names2.add("Sina ");

        SortTest sortTest = new SortTest();
        sortTest.sortUsingJava7(names1);
        System.out.println("使用java7 排序:"+ names1);

        sortTest.sortUsingJava8(names2);
        System.out.println("使用java8排序："+ names2);

        new Thread(()->{

        }).start();

        //把函数（lambda表达式）作为一个参数
        //Runnable  接口上有申明他是一个函数式接口（@FunctionalInterface）， 所以可以折磨用
        Runnable runnable = ()->{System.out.println("sdfsdfsd");};
        new Thread(runnable);



    }

    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }

    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }
}
