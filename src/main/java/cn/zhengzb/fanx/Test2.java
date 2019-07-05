package cn.zhengzb.fanx;

/**
 * 泛型通配符:
 *
 *  我们知道Ingeter是Number的一个子类，同时在特性章节中我们也验证过Generic<Ingeter>与Generic<Number>实际上是相同的一种基本类型。
 *  那么问题来了，在使用Generic<Number>作为形参的方法中，能否使用Generic<Ingeter>的实例传入呢？
 *  在逻辑上类似于Generic<Number>和Generic<Ingeter>是否可以看成具有父子关系的泛型类型呢？
 *
 *  看下面实例：
 *
 */
public class Test2 {
    public static void main(String[] args) {
        FanxClass<Integer> gInteger = new FanxClass<Integer>(123);
        FanxClass<Number> gNumber = new FanxClass<Number>(456);
        FanxClass<String> sNumber = new FanxClass<String>("789");

        /*
        通过提示信息我们可以看到FanxClass<Integer>不能被看作为`FanxClass<Number>的子类。
        由此可以看出:同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。
         */
        //showKeyValue(gInteger);这个方法编译器会为我们报错：FanxClass<java.lang.Integer> cannot be applied to FanxClass<java.lang.Number>



        showKeyValue(gNumber);


        //使用泛型通配符
        showKeyValue1(gInteger);//这里就不会报错了
        showKeyValue1(gNumber);
        showKeyValue1(sNumber);
    }

    public static void showKeyValue(FanxClass<Number> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    /**
     * 如何解决上面的问题？
     * 总不能为了定义一个新的方法来处理FanxClass<Integer>类型的类，这显然与java中的多太理念相违背。
     * 因此我们需要一个在逻辑上可以表示同时是FanxClass<Integer>和FanxClass<Number>父类的引用类型。由此类型通配符应运而生。
     *
     *
     * 这里为什么不能写成FanxClass<T>  ?
     *  因为类型通配符一般是使用？代替具体的类型实参，注意了，此处’？’是类型实参，而不是类型形参 。
     *  重要说三遍！此处’？’是类型实参，而不是类型形参 ！ 此处’？’是类型实参，而不是类型形参 ！
     *  再直白点的意思就是，此处的？和Number、String、Integer一样都是一种实际的类型，可以把？看成所有类型的父类。是一种真实的类型。
     *
     *
     * @param obj
     */
    public static void showKeyValue1(FanxClass<?> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }

    /**
     * 这里就是泛型方法了，效果和showKeyValue1方法效果一样，两者有什么区别呢？
     * @param obj
     * @param <T>
     */
    public static <T> void showKeyValue1_1(FanxClass<T> obj){
        System.out.println("泛型测试key value is " + obj.getKey());
    }
}
