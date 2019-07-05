package cn.zhengzb.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * FlatMap 的使用
 *
 * Created by zhengzb on 2019/3/17 18:51
 */
public class Lambda8 {


    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();

        // create foos
        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f ->IntStream.range(1, 4).forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));


        foos.stream().flatMap(f -> f.bars.stream()).forEach(b -> System.out.println(b.name));


        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4).mapToObj(i -> new Bar("Bar" + i + " <- " +f.name)).forEach(f.bars::add))
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));
    }

}

class Foo {
    String name;
    List<Bar> bars = new ArrayList<>();

    Foo(String name) {
        this.name = name;
    }
}

class Bar {
    String name;

    Bar(String name) {
        this.name = name;
    }
}


