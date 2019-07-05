package cn.zhengzb.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@MainBean(beanName = "mainbean")
public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Test1.class);

        String[] beannames = context.getBeanNamesForType(Test1.class);

        //当加上@AliasFor时, 输出"mainbean"
        //当去掉@AliasFor注解后, 输出"main"
        System.out.println(beannames[0]);

        context.close();

    }

}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@interface MainBean {

    @AliasFor("value")
    String beanName() default "";

    @AliasFor("beanName")
    String value() default "";
}
