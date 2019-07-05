package cn.zhengzb.fanx;

/**
 * 泛型上下边界
 *
 *  在使用泛型的时候，我们还可以为传入的泛型类型实参进行上下边界的限制，如：类型实参只准传入某种类型的父类或某种类型的子类。
 *
 *
 */
public class Test3 {
    public static void main(String[] args) {
        FanxClass<String> generic1 = new FanxClass<String>("11111");
        FanxClass<Integer> generic2 = new FanxClass<Integer>(2222);
        FanxClass<Float> generic3 = new FanxClass<Float>(2.4f);
        FanxClass<Double> generic4 = new FanxClass<Double>(2.56);

        //这一行代码编译器会提示错误，因为String类型并不是Number类型的子类
        //showKeyValue1(generic1);

        showKeyValue1(generic2);
        showKeyValue1(generic3);
        showKeyValue1(generic4);
    }
    /**
     * 为泛型添加上边界，即传入的类型实参必须是指定类型的子类型
     * @param obj
     */
    public static void showKeyValue1(FanxClass<? extends Number> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }



    /**
     * 在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
     * public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
     * @param container
     * @param <T>
     * @return
     */
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }
}


/**
 * 当然，不止泛型方法，泛型类也可以指定上下边界
 */
class Generic<T extends Number>{
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
