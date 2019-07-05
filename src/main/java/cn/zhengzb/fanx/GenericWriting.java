package cn.zhengzb.fanx;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型 PESC 原则：
 *
 * 如果我们要add元素应该怎么做呢？可以使用<? super T>：
 *
 *
 * 总结 PESC原则：
 *      Producer Extends” – 如果你需要一个只读List，用它来produce T，那么使用? extends T。
 *      “Consumer Super” – 如果你需要一个只写List，用它来consume T，那么使用? super T。
 *      如果需要同时读取以及写入，那么我们就不能使用通配符了。
 *
 *
 *
 * PESC原则在 Java源码中的使用：
 *
 *public class Collections {
 *     public static <T> void copy(List<? super T> dest, List<? extends T> src) {
 *         for (int i=0; i<src.size(); i++)
 *             dest.set(i, src.get(i));
 *     }
 * }
 *
 */
public class GenericWriting {
    static class Fruit {}
    static class Apple extends Fruit {}
    static class Orange extends Fruit {}
    static List<Apple> apples = new ArrayList<Apple>();
    static List<Fruit> fruit = new ArrayList<Fruit>();

    static <T> void writeExact(List<T> list, T item) {
        list.add(item);
    }
    static void f1() {
        writeExact(apples, new Apple());
        writeExact(fruit, new Apple());
    }

    /**
     * 这里改成<? extends T> 就不行了
     * @param list
     * @param item
     * @param <T>
     */
    static <T> void writeWithWildcard(List<? super T> list, T item) {
        list.add(item);
    }
    static void f2() {
        writeWithWildcard(apples, new Apple());
        writeWithWildcard(fruit, new Orange());
    }
    public static void main(String[] args) {
        f1(); f2();
    }
}
