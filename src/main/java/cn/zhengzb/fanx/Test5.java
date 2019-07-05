package cn.zhengzb.fanx;

/**
 * 泛型基础 之 泛型类 为什么要使用泛型
 * Created by zhengzb on 2019/3/10 14:47
 */
public class Test5 {
}

//定义一个常见的box类
class box{
    private String obj;

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }
}

//上面是最常见的定义类的做法，这样做的一个坏处是Box里面现在只能装入String类型的元素，
// 今后如果我们需要装入Integer等其他类型的元素，还必须要另外重写一个Box，
// 代码得不到复用，使用泛型可以很好的解决这个问题。
//这样我们的Box类便可以得到复用，我们可以将T替换成任何我们想要的类型：
//Box<Integer> integerBox = new Box<Integer>();
//Box<Double> doubleBox = new Box<Double>();
//Box<String> stringBox = new Box<String>();
class Box<T>{
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
