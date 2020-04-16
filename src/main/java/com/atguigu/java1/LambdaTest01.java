package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * created by yuqi on 2020/4/8
 *  Lambda 表达式的使用
 *  1，距离(o1,o2) -> Integer.compare(o1,o2);
 *  2，格式
 *      -> : Lambda操作符 或 箭头操作符
 *      -> 左边 Lambda形参列表(其实就是接口中的抽象方法的型参列表)
 *      -> 右边，Lambda 体(其实就是重写的抽象方法的方法体)
 *
 *  3， Lambda 表达式的而是用 ： (分为6种情况介绍)
 *  4, Lambda表达式的本质：作为函数式接口的实例
 *  5，如果一个接口中，只实现了一个抽象方法，则此接口就是函数式接口
 *      我们可以在一个接口上使用@FunctionInterface 注解，这样可以检查它是否是一个函数式一个接口
 *
 *  总结：
 *      -> 左边 Lambda形参列表的阐述类型都可以省略（形参类型【String。。。。】，类型推断）：如果Lambda形参列表只有一个参数，括号也可省略
 *      -> 右边： Lambda体应该使用一堆{}包裹：如果Lambda只有一条执行语句（可能时return语句），可以省略大括号和return（不能省略大括号而使用return）
 * @Author yuqi
 */
public class LambdaTest01 {
    // 语法格式一 ，无参，无返回值
    @Test
    public void test1(){
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("HAIL ANUBIS");
            }
        };
        runnable1.run();
        System.out.println("******");

        // Lambda
        Runnable runnable2 = () -> {
            System.out.println("Greetings");
        };
        runnable2.run();
    }
    // 语法格式 二：Lambda 一个参数，没有返回值
    @Test
    public void test02(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("We are here for you");

        // Lambda
        Consumer<String> consumer2 = (String s) ->
        {
            System.out.println(s);
        };
        consumer2.accept("Ready to go");
    }
    //语法格式三：数据类型可以省略，因为可由编译器推断得出，成为“类型推断”
    @Test
    public void test03(){
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("We are here for you");

        // Lambda
        Consumer<String> consumer2 = (s) ->
        {
            System.out.println(s);
        };
        consumer2.accept("Ready to go");
    }
    @Test
    public void test04(){
        ArrayList<String> list = new ArrayList<>(); //类型推断
        int arr[] = {1,2,3}; //类型推断
        int arr1[] = new int[]{1,2,3};
        for (int i = 0; i < arr1.length; i++) {
            System.out.println(i);
        }

    }
    // 语法格式四： lambda 若只需要一个参数时，参数的小括号可以省略
    @Test
    public void test05(){
        // Lambda
        Consumer<String> consumer1 = (s) ->
        {
            System.out.println(s);
        };
        consumer1.accept("Just say the word");

        // Lambda 省略括号
        Consumer<String> consumer2 = s ->{
            System.out.println(s);
        };
        consumer2.accept("Just say the word");
    }
    // 语法格式五 ： Lambda 需要两个或以上的参数，多条执行语句，并且有返回值
    @Test
    public void test06(){
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println(o1);
                System.out.println(o2);
                return o1.compareTo(o2);
            }
        };
        int result1 = comparator1.compare(11,22);
        System.out.println(result1);
        System.out.println("********");
        // Lambda
        Comparator<Integer> comparator2 = (o1,o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };
        int result2 = comparator2.compare(45,23);
        System.out.println(result2);
    }
    // 语法格式六： 当Lambda体只有一条语句时，return与大括号若有，都可以省略
    @Test
    public void test07(){
        Comparator<Integer> comparator1 = (o1,o2) -> {
            return o1.compareTo(o2);
        };
        int result1 = comparator1.compare(14,23);
        System.out.println(result1);
        System.out.println("*******");
        // 省略
        Comparator<Integer> comparator2 = (o1,o2) ->
                o1.compareTo(o2);
        int result2 = comparator2.compare(16,3);
        System.out.println(result2);

    }
    @Test
    public void test08(){
    Consumer<String> consumer1 = s -> {
        System.out.println(s);
    };
    consumer1.accept("In the middle of my back swing?");

    Consumer<String> consumer2 = s -> System.out.println(s);
    consumer2.accept("In the middle of my back swing?");
    }
}
