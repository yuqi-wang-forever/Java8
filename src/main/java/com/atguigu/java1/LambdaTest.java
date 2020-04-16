package com.atguigu.java1;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * created by yuqi on 2020/4/8
 *
 * @Author yuqi
 */
public class LambdaTest {
    @Test
    public void test01(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("HAIL ANUBIS");
            }
        };
        runnable1.run();

        System.out.println("********");

        Runnable runnable2 = () -> System.out.println("Greetings");

        runnable2.run();
    }

    @Test
    public void test02(){
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        Integer result1 = comparator1.compare(12,21);
        System.out.println(result1);
        System.out.println("**********");
        // Lambda 表达式写法
        Comparator<Integer> comparator2 = (o1,o2) -> Integer.compare(11,9);

        int result2 =  comparator2.compare(11,6);
        System.out.println(result2);
        System.out.println("**********");
        // 方法引用方式
        Comparator<Integer> comparator = Integer::compare;
        int result3 = comparator.compare(15,5);
        System.out.println(result3);
    }
}
