package cn.zhengzb.fanx;

import java.util.ArrayList;

/**
 *
 * 泛型基础 之 类型擦除
 * Created by zhengzb on 2019/3/10 15:51
 */
public class Test10 {

    public static void main(String[] args) {
        //思考下面一段代码
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2); // true
    }
}
