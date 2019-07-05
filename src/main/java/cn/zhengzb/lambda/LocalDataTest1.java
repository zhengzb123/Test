package cn.zhengzb.lambda;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * jdk1.8 日期时间api 使用

 *  考虑到时区的api
 * Created by zhengzb on 2019/3/9 14:07
 */
public class LocalDataTest1 {

    public static void main(String[] args) {
        LocalDataTest1 localDataTest = new LocalDataTest1();
        localDataTest.testZonedDateTime();
    }

    public void testZonedDateTime(){

        // 获取当前时间日期
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }
}
