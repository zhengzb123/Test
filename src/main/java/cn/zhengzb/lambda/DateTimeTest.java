package cn.zhengzb.lambda;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * java8 时间日期 api  使用
 * Created by zhengzb on 2019/3/10 14:03
 */
public class DateTimeTest {

    public static void main(String[] args) {

        //时区类可以用一个ZoneId来表示。时区类的对象可以通过静态工厂方法方便地获取。
        //打印所有默认时区
        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Europe/Berlin");
        ZoneId zone2 = ZoneId.of("Brazil/East");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        //LocalTime
        //本地时间类表示一个没有指定时区的时间，例如，10 p.m.或者17:30:15，
        // 下面的例子会用上面的例子定义的时区创建两个本地时间对象。
        // 然后我们会比较两个时间，并计算它们之间的小时和分钟的不同。
        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2)); // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween); // -3
        System.out.println(minutesBetween); // -239

        //LocalTime是由多个工厂方法组成，其目的是为了简化对时间对象实例的创建和操作，包括对时间字符串进行解析的操作。
        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late); // 23:59:59

        DateTimeFormatter germanFormatter =
                DateTimeFormatter
                        .ofLocalizedTime(FormatStyle.SHORT)
                        .withLocale(Locale.GERMAN);

        LocalTime leetTime = LocalTime.parse("13:37", germanFormatter);
        System.out.println(leetTime); // 13:37


        //LocalDate
        //本地时间表示了一个独一无二的时间，例如：2014-03-11。这个时间是不可变的，与LocalTime是同源的。
        // 下面的例子演示了如何通过加减日，月，年等指标来计算新的日期。记住，每一次操作都会返回一个新的时间对象。
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek); // FRIDAY



        //解析字符串并形成LocalDate对象，这个操作和解析LocalTime一样简单。
        DateTimeFormatter germanFormatter1 =
                DateTimeFormatter
                        .ofLocalizedDate(FormatStyle.MEDIUM)
                        .withLocale(Locale.GERMAN);

        LocalDate xmas = LocalDate.parse("24.12.2014", germanFormatter1);
        System.out.println(xmas); // 2014-12-24

        //LocalDateTime
        //LocalDateTime表示的是日期-时间。它将刚才介绍的日期对象和时间对象结合起来，形成了一个对象实例。
        // LocalDateTime是不可变的，与LocalTime和LocalDate的工作原理相同。
        // 我们可以通过调用方法来获取日期时间对象中特定的数据域。
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        DayOfWeek dayOfWeek1 = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek1); // WEDNESDAY

        Month month = sylvester.getMonth();
        System.out.println(month); // DECEMBER

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay); // 1439


        //格式化日期-时间对象就和格式化日期对象或者时间对象一样。
        // 除了使用预定义的格式以外，我们还可以创建自定义的格式化对象，然后匹配我们自定义的格式。
//        DateTimeFormatter formatter =
//                DateTimeFormatter
//                        .ofPattern("yyyy-MM-dd HH:mm");
//
//        LocalDateTime parsed = LocalDateTime.parse("Nov 03, 2014 - 07:13", formatter);
//        String string = formatter.format(parsed);
//        System.out.println(string); // Nov 03, 2014 - 07:13

    }
}