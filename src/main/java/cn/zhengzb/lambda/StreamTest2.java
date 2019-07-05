package cn.zhengzb.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 流操作测试
 * Created by zhengzb on 2019/3/9 13:17
 */
public class StreamTest2 {

    public static void main(String[] args) {
        final Collection< Task > tasks = Arrays.asList(
                new Task( Status.OPEN, 5 ),
                new Task( Status.OPEN, 13 ),
                new Task( Status.CLOSED, 8 )
        );


        /**
         * 第一，task集合被转换化为其相应的stream表示。
         * 然后，filter操作过滤掉状态为CLOSED的task。
         * >>>下一步，mapToInt操作通过Task::getPoints这种方式调用每个task实例的getPoints方法把Task的stream转化为Integer的stream。<<<
         * 最后，用sum函数把所有的分数加起来，得到最终的结果。
         */
        final long totalPointsOfOpenTasks = tasks
                .stream()
                .filter( task -> task.getStatus() == Status.OPEN )
                .mapToInt( Task::getPoints )
                .sum();

        System.out.println( "Total points: " + totalPointsOfOpenTasks );



        //这个例子和第一个例子很相似，但这个例子的不同之处在于这个程序是并行运行的，其次使用reduce方法来算最终的结果。
        final double totalPoints = tasks
                .stream()
                .parallel()
                .map( task -> task.getPoints() ) // or map( Task::getPoints )
                .reduce( 0, Integer::sum );

        System.out.println( "Total points (all tasks): " + totalPoints );



        //经常会有这个一个需求：我们需要按照某种准则来对集合中的元素进行分组。Stream也可以处理这样的需求，下面是一个例子：
        final Map< Status, List< Task >> map = tasks
                .stream()
                .collect( Collectors.groupingBy( Task::getStatus ) );
        System.out.println( map );


        //让我们来计算整个集合中每个task分数（或权重）的平均值来结束task的例子。
        final Collection< String > result = tasks
                .stream()                                        // Stream< String >
                .mapToInt( Task::getPoints )                     // IntStream
                .asLongStream()                                  // LongStream
                .mapToDouble( points -> points / totalPoints )   // DoubleStream
                .boxed()                                         // Stream< Double >
                .mapToLong( weigth -> ( long )( weigth * 100 ) ) // LongStream
                .mapToObj( percentage -> percentage + "%" )      // Stream< String>
                .collect( Collectors.toList() );                 // List< String >

        System.out.println( result );
    }

    private enum Status {
        OPEN, CLOSED
    };


    private static final class Task {
        private final Status status;
        private final Integer points;

        Task( final Status status, final Integer points ) {
            this.status = status;
            this.points = points;
        }

        public Integer getPoints() {
            return points;
        }

        public Status getStatus() {
            return status;
        }

        @Override
        public String toString() {
            return String.format( "[%s, %d]", status, points );
        }
    }

}
