package com.atguigu.java2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * created by yuqi on 2020/4/9
 *  方法引用的使用
 * @Author yuqi
 *  1，使用情境：当要传递给Lambda体的操作，已经有实现的方法了，可以使用方法引用
 *  2，方法引用本质上就是Lambda表达式，而Lambda表达式作为函数式接口的实例。所以方法引用也是函数式接口的实例
 *  3，使用格式： 类（或对象）：： 方法名
 *  4，具体分为如下三种情况：
 *     情况一： 对象：：静态方法
 *     情况二： 类：：静态方法
 *     情况三： 类：：非静态方法
 *  5， 方法使用的要求：要求接口中的抽象方法的形参列表和返回值类型与方法引用的形参和返回值类型相同
 */
public class MethodRefTest {
    /**
     * 情况一： 对象 ：： 实例方法
     * Consumer 中的 void Accept(T t)
     * PrintStream中的void println(T t)
     */
    @Test
    public  void test01(){
        // lambda
        Consumer<String> consumer1 = str -> System.out.println(str);
        consumer1.accept("New York");
        System.out.println("**************");
        // 方法引用
        PrintStream printStream = System.out;
        Consumer<String> consumer2 = printStream :: println;
        consumer2.accept("纽约");

    }
    /**
     * Supplier中的Tget()
     * Employee 中的String getName();
     */
    @Test
    public  void tset02(){
        // lambda
        Employee employee = new Employee(1001,"Jack",56,5000.21);
        Supplier<String> supplier1 = () -> employee.getName();
        System.out.println(supplier1.get());
        System.out.println("******");
        // 方法引用
        Supplier<String> supplier2 = employee :: getName;
        System.out.println(supplier2.get());
    }

    /**
     * 情况二：类：：静态方法
     * Comparator中的int compare(T t1,T,t2)
     * Integer中的int compare(T t1,T t2)
     */
    @Test
    public void test03(){
        // Lambda
        Comparator<Integer> comparator1 = (t1,t2) -> Integer.compare(t1,t2);
        System.out.println(comparator1.compare(5,4));
        System.out.println("***********");
        // 方法引用
        Comparator<Integer> comparator2 = Integer::compare;
        System.out.println(comparator2.compare(4,8));
    }
    /**
     * Function中的apply(T t)
     * Math 中的Long round(Double d)
     */
    @Test
    public void test04(){
        //原始
        Function<Double,Long> function1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double d) {
                return Math.round(d);
            }
        };
        System.out.println(function1.apply(6.1));
        System.out.println("*********");
        // Lambda
        Function<Double,Long> function2 = d -> Math.round(d);
        System.out.println(function2.apply(5.6));
        System.out.println("***************");
        // 方法引用
        Function<Double,Long> function3 = Math::round;
        System.out.println(function3.apply(5.3));
    }
    /**
     * 情况三：类：：实例方法 (有难度)
     * Comparator 中的 int compare(T t1,T t2)
     * String 中的 int t1.compare(t2)
     */
    @Test
    public void test05(){
        // Lambda
        Comparator<String> comparator1 = (s1,s2) -> s1.compareTo(s2);
        System.out.println(comparator1.compare("abc","def"));
        System.out.println(comparator1.compare("abc","bcd"));
        System.out.println(comparator1.compare("abc","z"));
        System.out.println("**********");
        //方法引用
        Comparator<String> comparator2 = String :: compareTo;
        System.out.println(comparator2.compare("abc","abc"));;
    }
    /**
     * BiPredicate中的Boolean test(T t1,T t2);
     * String 中的Boolean t1.equals(t2)
     */
    @Test
    public void test06(){
        BiPredicate<String,String> predicate1 = (s1,s2) -> s1.equals(s2);
        System.out.println(predicate1.test("abc","abc"));
        System.out.println("*********");
        //方法引用
        BiPredicate<String,String> predicate2 = String :: equals;
        System.out.println(predicate2.test("abc","bcd"));
    }


    /**
     * Function 中的apply(T t)
     * Employee中的String getName();
     */
    @Test
    public void test07(){
        // Lambda
        Employee employee = new Employee(1001,"Jack",56,8000.23);
        Function<Employee,String> function1 = e -> e.getName();
        System.out.println(function1.apply(employee));
        //方法引用
        Function<Employee,String> function2 = Employee::getName;
        System.out.println(function2.apply(employee));
    }
}
