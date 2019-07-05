package cn.zhengzb.fanx;

import java.util.Arrays;
import java.util.List;

/**
 * 泛型基础 之 通配符
 *
 * Created by zhengzb on 2019/3/10 15:16
 */
public class Test8 {
    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());

    //定义一个泛型类
    static class Reader<T> {
        T readExact(List<T> list) {
            return list.get(0);
        }
    }

    //f1()中当我们尝试Fruit f = fruitReader.readExact(apples);
    // 编译器会报错，因为List<Fruit>与List<Apple>之间并没有任何的关系。
    static void f1() {
        Reader<Fruit> fruitReader = new Reader<Fruit>();
//         Errors: List<Fruit> cannot be applied to List<Apple>.
//         Fruit f = fruitReader.readExact(apples);
    }

    //但是按照我们通常的思维习惯，Apple和Fruit之间肯定是存在联系，
    // 然而编译器却无法识别，那怎么在泛型代码中解决这个问题呢？我们可以通过使用通配符来解决这个问题：
    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f2() {
        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
        Fruit f = fruitReader.readCovariant(fruit);
        Fruit a = fruitReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1();
    }

}
class Fruit {}
class Apple extends Fruit {}
class Orange extends Fruit {}