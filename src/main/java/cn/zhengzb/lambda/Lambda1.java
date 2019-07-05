package cn.zhengzb.lambda;

/**
 * lambda 表达式的使用
 * Created by zhengzb on 2019/3/3 23:09
 */
public class Lambda1 {

    public static void main(String[] args) {
        Lambda1 lambda1 = new Lambda1();
        //几种lanmbda表达式的申明方式

        // 类型声明
        MathOperation addition = (int a, int b)-> a+b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a-b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {return a * b;};

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        //把函数作为一个方法的参数进行使用
        System.out.println("10 + 5 = " + lambda1.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambda1.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambda1.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambda1.operate(10, 5, division));

        // 不用括号
        GreetingService greetingService = message -> System.out.println("Hello "+ message);

        //用括号
        GreetingService greetingService1 = (message) -> System.out.println("Hello "+message);

        greetingService.sayMessage("Runoob");
        greetingService1.sayMessage("Google");



    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
}
