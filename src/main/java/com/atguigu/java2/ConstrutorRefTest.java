package com.atguigu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * created by yuqi on 2020/4/9
 *  一，构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一样
 *      抽象方法的返回值类型几位构造器所属类的类型
 *  二，数组引用
 * @Author yuqi
 */
public class ConstrutorRefTest {
    /**
     * 构造器引用
     * Supplier 中的 T get()
     * Employee的空参构造器：Employee
     */
    @Test
    public void test01(){
        //原始
        Supplier<Employee> supplier1 = new Supplier<Employee>() {
            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(supplier1.get());
        System.out.println("*************");
        //Lambda
        Supplier<Employee> supplier2 = () -> new Employee();
        System.out.println(supplier2.get());
        System.out.println("*****************");
        // 构造器引用
        Supplier<Employee> supplier3 = Employee::new;
        System.out.println(supplier3.get());
    }
    /**-
     * Function 中的R apply(T t)
     */
    @Test
    public void test02(){
        //Lambda
        Function<Integer,Employee> function1 = id -> new Employee();
        System.out.println(function1.apply(1001));
        System.out.println("********");
        // 构造器引用
        Function<Integer,Employee> function2 = Employee::new;
        System.out.println(function2.apply(1002));
    }
    /**
     * BiFunction 中的 R apply(T t,U u)
     */
    @Test
    public void test03(){
        // Lambda
        BiFunction<Integer,String,Employee> biFunction1 = (id,name) -> new Employee(id,name);
        System.out.println(biFunction1.apply(1001,"Samantha"));
        System.out.println("********");
        // 构造器引用
        BiFunction<Integer,String,Employee> biFunction2 = Employee::new;
        System.out.println(biFunction2.apply(1002,"Daniel Jackson"));
    }
    /**
     * 数组引用
     * Function中的R apply(T t)
     */
    @Test
    public void test04(){
        // Lambda
        Function<Integer,String[]> function1 = length -> new String[length];
        String[] arr1 = function1.apply(5);
        System.out.println(Arrays.toString(arr1));
        System.out.println("************");
        // 构造器
        Function<Integer,String[]> function2 = String[] :: new;
        String[] arr2 = function2.apply(7);
        System.out.println(Arrays.toString(arr2));
    }
}
