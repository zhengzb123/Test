package cn.zhengzb.lambda;

/**
 * Created by zhengzb on 2019/3/12 18:39
 */
public class Lambda5 {

    public static void main(String[] args) {
        Object obj = "sdf";
        Lambda4.of(obj).ifExit((s)->System.out.println(s)).ifNotExit((d)->System.out.println(d));
    }
}
