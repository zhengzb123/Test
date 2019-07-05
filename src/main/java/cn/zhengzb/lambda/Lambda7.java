package cn.zhengzb.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by zhengzb on 2019/3/17 18:25
 */
public class Lambda7 {

    public static void main(String[] args) {
        List<Person1> persons =
                Arrays.asList(
                        new Person1("Max", 18),
                        new Person1("Peter", 23),
                        new Person1("Pamela", 23),
                        new Person1("David", 12));

        Map<Integer, List<Person1>> map = persons.stream().collect(Collectors.groupingBy(v->v.age));
        Map<Integer, Person1> map1 = persons.stream().collect(Collectors.toMap(v->v.age,k->k, (s, a)->a));
        System.out.println(map);
        System.out.println(map1);

        String phrase = persons
                .stream()
                .filter(p -> p.age >= 18)
                .map(p -> p.name)
                .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));

        System.out.println(phrase);



        Collector<Person1, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),          // supplier
                        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
                        (j1, j2) -> j1.merge(j2),               // combiner
                        StringJoiner::toString);                // finisher

        String names = persons
                .stream()
                .collect(personNameCollector);

        System.out.println(names);
    }
}

class Person1 {
    String name;
    int age;

    Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}


