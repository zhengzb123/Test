package cn.zhengzb.lambda;

/**
 * lambda 表达式的使用
 *  方法和构造函数引用
 *
 * Created by zhengzb on 2019/3/3 23:09
 */
public class Lambda2 {
    static class Something{
        String startsWith(String s) {
            return String.valueOf(s.charAt(0));
        }
    }
    public static void main(String[] args) {
        Something something = new Something();

        //简洁写法
//        Converter<String, String> converter = something::startsWith;

        //完整写法
        Converter<String, String> converter = (s)->something.startsWith(s);
        String converted = converter.convert("Java");
        System.out.println(converted);

    }


    @FunctionalInterface
    interface Converter<F, T>{
        T convert(F from);
    }
}
