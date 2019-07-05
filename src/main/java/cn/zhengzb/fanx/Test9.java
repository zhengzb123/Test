package cn.zhengzb.fanx;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型基础 之 PECS原则
 * Created by zhengzb on 2019/3/10 15:21
 */
public class Test9 {

    public static void main(String[] args) {

        //上面我们看到了类似<? extends T>的用法，利用它我们可以从list里面get元素，
        // 那么我们可不可以往list里面add元素呢？我们来尝试一下：
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can't add any type of object:
//         flist.add(new Apple())
//         flist.add(new Orange())
//         flist.add(new Fruit())
//         flist.add(new Object())
        flist.add(null); // Legal but uninteresting
        // We Know that it returns at least Fruit:
        Fruit f = flist.get(0);


        //答案是否定，Java编译器不允许我们这样做，为什么呢？
        // 对于这个问题我们不妨从编译器的角度去考虑。因为List<? extends Fruit> flist它自身可以有多种含义：
//        List<? extends Fruit> flist = new ArrayList<Fruit>();
//        List<? extends Fruit> flist = new ArrayList<Apple>();
//        List<? extends Fruit> flist = new ArrayList<Orange>();
//        当我们尝试add一个Apple的时候，flist可能指向new ArrayList<Orange>();
//        当我们尝试add一个Orange的时候，flist可能指向new ArrayList<Apple>();
//        当我们尝试add一个Fruit的时候，这个Fruit可以是任何类型的Fruit，而flist可能只想某种特定类型的Fruit，编译器无法识别所以会报错。


//        所以对于实现了<? extends T>的集合类只能将它视为Producer向外提供(get)元素，而不能作为Consumer来对外获取(add)元素。

//        如果我们要add元素应该怎么做呢？可以使用<? super T>：

        f1();f2();


        //这样我们可以往容器里面添加元素了，但是使用super的坏处是以后不能get容器里面的元素了，
        // 原因很简单，我们继续从编译器的角度考虑这个问题，对于List<? super Apple> list，它可以有下面几种含义：
//        List<? super Apple> list = new ArrayList<Apple>();
//        List<? super Apple> list = new ArrayList<Fruit>();
//        List<? super Apple> list = new ArrayList<Object>();
//        当我们尝试通过list来get一个Apple的时候，可能会get得到一个Fruit，这个Fruit可以是Orange等其他类型的Fruit。

        //根据上面的例子，我们可以总结出一条规律，”Producer Extends, Consumer Super”：

//        “Producer Extends” – 如果你需要一个只读List，用它来produce T，那么使用? extends T。
//         “Consumer Super” – 如果你需要一个只写List，用它来consume T，那么使用? super T。
//        如果需要同时读取以及写入，那么我们就不能使用通配符了。



        //如何阅读过一些Java集合类的源码，可以发现通常我们会将两者结合起来一起用，比如像下面这样：
//        public class Collections {
//            public static <T> void copy(List<? super T> dest, List<? extends T> src) {
//                for (int i=0; i<src.size(); i++)
//                    dest.set(i, src.get(i));
//            }
//        }

    }

       static List<Apple> apples = new ArrayList<Apple>();
        static List<Fruit> fruit = new ArrayList<Fruit>();
        static <T> void writeExact(List<T> list, T item) {
            list.add(item);
        }
        static void f1() {
            writeExact(apples, new Apple());
            writeExact(fruit, new Apple());
        }
        static <T> void writeWithWildcard(List<? super T> list, T item) {
            list.add(item);
        }
        static void f2() {
            writeWithWildcard(apples, new Apple());
            writeWithWildcard(fruit, new Apple());
        }

}

