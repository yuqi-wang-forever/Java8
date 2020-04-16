package com.atguigu.java5;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * created by yuqi on 2020/4/15
 *
 * @Author yuqi
 * @Description
 */
public class LocalDateTimeTest {

    /**
     * ZoneDate,ZoneTime,ZoneDateTime
     */
    @Test
    public void test07(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        // StreamAPI 对集合的操作
        availableZoneIds.forEach(System.out::println);

        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("US/Michigan"));
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = localDateTime1.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);


    }

    /**
     * DateTimeFormatter:格式化时间日期
     */
    @Test
    public void test06(){
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE;
        LocalDateTime localDateTime1 = LocalDateTime.now();
        String format = localDateTime1.format(isoDateTime);
        System.out.println(format);
        System.out.println();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String format1 = localDateTime1.format(dateTimeFormatter);
        String format2 = dateTimeFormatter.format(localDateTime1);

        System.out.println(format1);
        System.out.println(format2);
        // 从自动逸格式转换为原始格式
        LocalDateTime parse = localDateTime1.parse(format1, dateTimeFormatter);
        System.out.println("原始"+parse);

    }
    /**
     * TemporalAdjusters:时间矫正器
     */
    @Test
    public void test05(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间"+now);
        LocalDateTime dateTime = now.withDayOfMonth(10);
        System.out.println("定义的几号"+dateTime);

        LocalDateTime localDateTime = now.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println("下一个周六是几号" + localDateTime);

        // 自定义下一个工作日
        LocalDateTime workDay = now.with(l -> {
            LocalDateTime localDateTime1 = (LocalDateTime) l;

            DayOfWeek dayOfWeek = localDateTime1.getDayOfWeek();

            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return localDateTime1.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return localDateTime1.plusDays(2);
            } else {
                return localDateTime1.plusDays(1);
            }
        });
        System.out.println("下一个工作日"+workDay);
    }
    /**
     * Period:计算两个日期之间的间隔
     */
    @Test
    public void test04(){
        LocalDate localDate1 = LocalDate.of(2018,06,26);
        LocalDate now = LocalDate.now();
        System.out.println("两个日期之间的时间间隔"+Period.between(now,localDate1));


    }

    /**
     * 3，Duration : 计算两个时间之间差了多少秒
     */
    @Test
    public void test03() throws InterruptedException {
        Instant instant1 = Instant.now();
        Thread.sleep(1000);
        Instant instant2 = Instant.now();
        Duration between = Duration.between(instant1, instant2);
        System.out.println("计算两个时间之间差了多少秒"+between);
        System.out.println("计算两个时间之间差了多少毫秒"+between.toMillis());
        System.out.println("**************************");
        LocalDateTime localDateTime1 = LocalDateTime.now();
        Thread.sleep(1000);
        LocalDateTime localDateTime2 = LocalDateTime.now();
        long between1 = Duration.between(localDateTime1, localDateTime2).toMillis();
        System.out.println("Duration计算两个时间之间的间隔"+between1);


    }
    
    /**
     * 2,Instant:时间戳（以unix元年：1970年一月一日零时零分零秒到某个时间之间的毫秒值
     */
    @Test
    public void test02(){
        Instant instant1 = Instant.now();
        System.out.println("格林尼治天文台时间"+instant1);
        //偏移日期时间
        OffsetDateTime offsetDateTime = instant1.atOffset(ZoneOffset.ofHours(8));
        System.out.println("北京时间，格林尼治天文台时间加上八小时"+offsetDateTime);

        System.out.println("获取毫秒值"+instant1.toEpochMilli());

        Instant instant2 = Instant.ofEpochSecond(60);
        System.out.println("unix元年60秒后的时间"+instant2);

    }
    /**
     * 1， LocalDate LocalTime LocalTime
     */
    @Test
    public void test01(){
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println("当前系统时间"+localDateTime1);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 04, 15, 11, 22, 33);
        System.out.println("自定义时间"+localDateTime2);

        LocalDateTime localDateTime3 = localDateTime1.plusYears(1);
        System.out.println("当前系统时间加上一年"+localDateTime3);

        LocalDateTime localDateTime4 = localDateTime1.minusYears(2);
        System.out.println("当前系统时间减去一年"+localDateTime4);

        System.out.println("当前年份"+localDateTime1.getYear());
        System.out.println("当前月份，英文几月"+localDateTime1.getMonth());
        System.out.println("当前几月阿拉伯数字"+localDateTime1.getMonthValue());
        System.out.println("当前几号阿拉伯数字"+localDateTime1.getDayOfMonth());
        System.out.println("当前周几，英文"+localDateTime1.getDayOfWeek());
        System.out.println("现在是一年中的第几天"+localDateTime1.getDayOfYear());
        System.out.println("当前几时"+localDateTime1.getHour());
        System.out.println("当前几分"+localDateTime1.getMinute());
        System.out.println("当前几秒"+localDateTime1.getSecond());

    }
}
