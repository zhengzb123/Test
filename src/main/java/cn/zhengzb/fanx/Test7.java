package cn.zhengzb.fanx;

/**
 * 泛型基础 之 边界符
 * Created by zhengzb on 2019/3/10 15:00
 */
public class Test7 {

    //现在我们要实现这样一个功能，查找一个泛型数组中大于某个特定元素的个数，我们可以这样实现：
    //但是这样很明显是错误的，因为除了short, int, double, long, float, byte, char等原始类型，
    // 其他的类并不一定能使用操作符>，所以编译器报错，那怎么解决这个问题呢？
//    public static <T> int countGreaterThan(T[] anArray, T elem){
//        int count = 0 ;
//        for(T e : anArray){
//            if(e > elem){
//                count ++;
//            }
//        }
//        return count;
//    }

    //答案就是我们可以使用边界符，做一个类似于下面这样的声明，
    // 这样就等于告诉编译器类型参数T代表的都是实现了Comparable接口的类，
    // 这样等于告诉编译器它们都至少实现了compareTo方法。
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem){
        int count = 0;
        for (T e : anArray)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }
}
