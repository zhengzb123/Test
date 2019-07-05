package cn.zhengzb.fanx;

import org.apache.commons.logging.Log;

/**
 * 泛型应用之1:泛型类
 *
 * 泛型类型用于类的定义中，被称为泛型类。通过泛型可以完成对一组类的操作对外开放相同的接口。最典型的就是各种容器类，如：List、Set、Map。
 *
 * 基本写法：
 * class 类名称 <泛型标识：可以随便写任意标识号，标识指定的泛型的类型>{
 *   private 泛型标识 /*（成员变量类型）* var;
 *    .....
 *    *
 *  }
 *}
 *
 */

//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class FanxClass<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public FanxClass(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    public T getKey(){ //泛型方法getKey的返回值类型为T，T的类型由外部指定
        return key;
    }


    /**
     * 泛型类的使用
     * @param args
     */
    public static void main(String[] args) {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        FanxClass<Integer> genericInteger = new FanxClass<Integer>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        FanxClass<String> genericString = new FanxClass<String>("key_vlaue");
        System.out.println("泛型测试key is " + genericInteger.getKey());
        System.out.println("泛型测试key is " + genericString.getKey());



        /*
        定义的泛型类，就一定要传入泛型类型实参么？并不是这样，在使用泛型的时候如果传入泛型实参，则会根据传入的泛型实参做相应的限制，
        此时泛型才会起到本应起到的限制作用。如果不传入泛型类型实参的话，在泛型类中使用泛型的方法或成员变量定义的类型可以为任何的类型。
        看下面实例：
         */
        FanxClass generic = new FanxClass("111111");
        FanxClass generic1 = new FanxClass(4444);
        FanxClass generic2 = new FanxClass(55.55);
        FanxClass generic3 = new FanxClass(false);
    }
}


