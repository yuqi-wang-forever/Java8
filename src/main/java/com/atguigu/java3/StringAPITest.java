package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * created by yuqi on 2020/4/13
 *
 * @Author yuqi
 * @Description
 *     1,Stream关注的是对数据的运算，与CPU打交道
 *      集合关注的是数据的存储，与内存打交道
 *     2，
 *      ①Stream 自己不会存储元素
 *      ②Stream 不会改变元对象。相反，他们会返回一个持有结果的新Stream
 *      ③Stream 操作时延迟执行的。这意味着他们会等到需要结果的时候才执行
 *      3，Stream 执行流程
 *          ①Stream的实例化
 *          ②一系列的中间操作
 *          ③终止操作
 *      4，说明
 *          ①一个中间操作链，对数据源的数据进行处理
 *          ②一旦执行终止操作，就执行中间操作链，并产生结果。之后不会在被使用
 *
 *   测试Stream的实例化
 */
public class StringAPITest {
    /**
     * 创建Stream方式一：通过集合
     */
    @Test
    public void test01(){
        List<Employee> employees = EmployeeData.getEmployees();
        // default Stream<E> stream() : 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        //default Stream<E> paralleStream():返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }
    /**
     * 创建Stream方式二：通过数组
     */
    @Test
    public void test02(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays 类的static<T> Stream<T> Stream(T[] array):返回一个流
        IntStream stream = Arrays.stream(arr);

        Employee employee1 = new Employee(1001,"Jack");
        Employee employee2 = new Employee(1002,"Hammond");
        Employee[] arrEmp = new Employee[]{employee1,employee2};
        Stream<Employee> employeeStream = Arrays.stream(arrEmp);
    }
    /**
     * 创建方式三：通过Stream的of
     */
    @Test
    public void test03(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);

    }
    /**
     *创建Stream方式四 创建无限流
     */
    @Test
    public void test04(){
        // 迭代
        //public static<T> Stream<T> iterate(final T seed.final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);
        // 生成
        // public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
