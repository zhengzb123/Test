package cn.zhengzb.lambda;

/**
 * lambda 表达式的使用
 *  构造函数引用
 *  工厂模式
 *  泛型的使用
 *
 * Created by zhengzb on 2019/3/3 23:09
 */
public class Lambda3 {

    public static void main(String[] args) {

        //我们通过 Person::new 来创建一个Person类构造函数的引用。
        // Java编译器会自动地选择合适的构造函数来匹配PersonFactory.create函数的签名，
        // 并选择正确的构造函数形式。
        PersonFactory<Person> personFactory = Person::new;
//        PersonFactory<Person> personFactory = (k,v)->new Person(k,v);
        Person person = personFactory.create("Peter", "Parker");
        System.out.println(person.firstName);
        System.out.println(person.lastName);
    }
}

//定义一个专门用与生产Person类的工厂
interface PersonFactory<P extends Person>{
    P create(String firstName, String lastName);
}

//定义一个类
class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}