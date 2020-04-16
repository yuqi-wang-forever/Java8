package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * created by yuqi on 2020/4/8
 *  Java 内置的4大核心函数式接口
 *  消费型接口 Consumer<T> void accept(T t)
 *  供给型接口 Supplier<T> T get()
 *  函数型接口 Function<T,R> R apply(T t)
 *  断定型接口 Predicate<T> Boolean test(T t)
 * @Author yuqi
 */
public class LambdaTest02 {

    @Test
    public void test01(){
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("I just never blew up a sun before"+aDouble);
            }
        });

        System.out.println("************");
        // Lambda
        happyTime(200,time -> System.out.println("I just never blew a star before"+time));
    }

    public void happyTime(double time, Consumer<Double> consumer){
        consumer.accept(time);
    }

    @Test
    public void test02(){
        List<String> list = Arrays.asList("New York","Beijing","Tokyo","Tianjin");
        List<String> filterList = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("o");
            }
        });
        System.out.println(filterList);
        System.out.println("*******Lambda******");
        // Lambda
        List<String> listLambda = filterString(list,s -> s.contains("o"));
        System.out.println(listLambda);
    }
    // 根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
    public ArrayList<String> filterString(List<String> list, Predicate<String> predicate){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s:  list) {
            if (predicate.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
    public String toUpperString(MyFun<String> myFun,String s){
        return myFun.getValue(s);
    }
    @Test
    public void test03(){
        String toUpperString = toUpperString((str) -> str.toUpperCase(), "abc");
        System.out.println(toUpperString);
    }
}
