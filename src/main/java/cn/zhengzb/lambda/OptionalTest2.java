package cn.zhengzb.lambda;

import java.util.Optional;

/**
 *
 * Created by zhengzb on 2019/3/9 13:46
 */
public class OptionalTest2 {


    public static void main(String[] args) {
        Optional< String > firstName = Optional.of( "Tom" );
        System.out.println( "First Name is set? " + firstName.isPresent() );
        System.out.println( "First Name: " + firstName.orElseGet( () -> "[none]" ) );
        System.out.println( firstName.map( s -> "Hey " + s + "!" ).orElse( "Hey Stranger!" ) );
        System.out.println();

        System.out.println(String.format( "[%s, %d]", 1, 2 ));
    }

}
