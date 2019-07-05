package cn.zhengzb.lambda;

/**
 * Created by zhengzb on 2019/3/13 18:34
 */
public class test1 {
    public static void main(String[] args) {
        asd a = new asd1();
        System.out.println(a.getClass().getName()+":"+asd1.class.getName());
    }
}

interface asd{

}
class asd1 implements asd{

}
