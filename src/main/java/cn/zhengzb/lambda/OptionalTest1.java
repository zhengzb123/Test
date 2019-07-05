package cn.zhengzb.lambda;

import java.util.Optional;

/**
 *
 * Created by zhengzb on 2019/3/9 13:46
 */
public class OptionalTest1 {


    public static void main(String[] args) {
        Optional< String > fullName = Optional.ofNullable( "aaa" );
//        Optional< String > fullName = Optional.ofNullable( null );

        //如果Optional类的实例为非空值的话，isPresent()返回true，否从返回false.
        System.out.println( "Full Name is set? " + fullName.isPresent() );
        //为了防止Optional为空值，orElseGet()方法通过回调函数来产生一个默认值。
        System.out.println( "Full Name: " + fullName.orElseGet( () -> "[none]" ) );
        //map()函数对当前Optional的值进行转化，然后返回一个新的Optional实例。
        // orElse()方法和orElseGet()方法类似，但是orElse接受一个默认值而不是一个回调函数。
        System.out.println( fullName.map( s -> "Hey1 " + s + "!" ).orElse( "Hey2 Stranger!" ) );
    }

}
