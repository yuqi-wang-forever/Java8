package com.atguigu.java5;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * created by yuqi on 2020/4/15
 *
 * @Author yuqi
 * @Description
 */
public class ForkJoinTest {

    /**
     * ForkJoin框架计算
     */
    @Test
    public void test01(){
        Instant start = Instant.now();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0,10000000000L);
        Long sum = forkJoinPool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("所用时间"+ Duration.between(start,end).toMillis());
    }
    /**
     * for循环相加
     */
    @Test
    public void test02(){
        long sum = 0;
        for (long i = 0; i < 10000000000L; i++) {
             sum += i;
        }
        System.out.println(sum);
    }
    /**
     * java8并行流
     */
    @Test
    public void test03(){
        Instant instant = Instant.now();
        LongStream longStream = LongStream.rangeClosed(0, 10000000000L);
        longStream.parallel().reduce(0,Long::sum);

        Instant instant1 = Instant.now();
        System.out.println(Duration.between(instant,instant1).toMillis());
    }
}
