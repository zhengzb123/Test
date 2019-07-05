package cn.zhengzb.fanx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 泛型通配符 ：PECS原则
 */
public class Test4 {

    class Fruit {}
    class Apple extends Fruit {}
    class Orange extends Fruit {}



    class GenericReading {
         List<Apple> apples = Arrays.asList(new Apple());
         List<Fruit> fruit = Arrays.asList(new Fruit());
        /**
         *下面这个例子中，我们创建了一个泛型类Reader，
         * 然后在f1()中当我们尝试Fruit f = fruitReader.readExact(apples);编译器会报错，因为List<Fruit>与List<Apple>之间并没有任何的关系。
         */
         class Reader<T> {
            T readExact(List<T> list) {
                return list.get(0);
            }
        }
         void f1() {
            Reader<Fruit> fruitReader = new Reader<Fruit>();
            // Errors: List<Fruit> cannot be applied to List<Apple>.
            // Fruit f = fruitReader.readExact(apples);
        }



        /**
         *但是按照我们通常的思维习惯，Apple和Fruit之间肯定是存在联系，然而编译器却无法识别，那怎么在泛型代码中解决这个问题呢？
         * 我们可以通过使用通配符来解决这个问题：
         * 这样就相当与告诉编译器， fruitReader的readCovariant方法接受的参数只要是满足Fruit的子类就行(包括Fruit自身)，这样子类和父类之间的关系也就关联上了。
         * @param <T>
         */
        class CovariantReader<T> {
            T readCovariant(List<? extends T> list) {
                return list.get(0);
            }
        }
        void f2() {
            CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
            Fruit f = fruitReader.readCovariant(fruit);
            Fruit a = fruitReader.readCovariant(apples);
        }


        /**
         *上面我们看到了类似<? extends T>的用法，利用它我们可以从list里面get元素，那么我们可不可以往list里面add元素呢？我们来尝试一下：
         *
         * 答案是否定，Java编译器不允许我们这样做，为什么呢？对于这个问题我们不妨从编译器的角度去考虑。因为List<? extends Fruit> flist它自身可以有多种含义：
         * List<? extends Fruit> flist = new ArrayList<Fruit>();
         * List<? extends Fruit> flist = new ArrayList<Apple>();
         * List<? extends Fruit> flist = new ArrayList<Orange>();
         *当我们尝试add一个Apple的时候，flist可能指向new ArrayList<Orange>();
         * 当我们尝试add一个Orange的时候，flist可能指向new ArrayList<Apple>();
         * 当我们尝试add一个Fruit的时候，这个Fruit可以是任何类型的Fruit，而flist可能只想某种特定类型的Fruit，编译器无法识别所以会报错。
         *
         * 所以对于实现了<? extends T>的集合类只能将它视为Producer向外提供(get)元素，而不能作为Consumer来对外获取(add)元素。
         *
         */
        void f3(){
            // Wildcards allow covariance:
            List<? extends Fruit> flist = new ArrayList<Apple>();
            // Compile Error: can't add any type of object:
            // flist.add(new Apple())
            // flist.add(new Orange())
            // flist.add(new Fruit())
            // flist.add(new Object())
            flist.add(null); // Legal but uninteresting
            // We Know that it returns at least Fruit:
            Fruit f = flist.get(0);
        }


        /**
         * 如果我们要add元素应该怎么做呢？可以使用<? super T>：
         *
         * public class GenericWriting {
         *     static List<Apple> apples = new ArrayList<Apple>();
         *     static List<Fruit> fruit = new ArrayList<Fruit>();
         *     static <T> void writeExact(List<T> list, T item) {
         *         list.add(item);
         *     }
         *     static void f1() {
         *         writeExact(apples, new Apple());
         *         writeExact(fruit, new Apple());
         *     }
         *     static <T> void writeWithWildcard(List<? super T> list, T item) {
         *         list.add(item)
         *     }
         *     static void f2() {
         *         writeWithWildcard(apples, new Apple());
         *         writeWithWildcard(fruit, new Apple());
         *     }
         *     public static void main(String[] args) {
         *         f1(); f2();
         *     }
         * }
         *
         */


    }
    public static void main(String[] args) {

    }



}
