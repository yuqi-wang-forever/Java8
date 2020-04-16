package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by yuqi on 2020/4/13
 *
 * @Author yuqi
 * @Description
 *  测试Stream的终止操作
 */
public class StreamAPITest02 {
    /**
     * 1-匹配于查找
     */
    @Test
    public void test01(){
        List<Employee> employees = EmployeeData.getEmployees();
        //allMatch(Predicate p)-检查是否至少匹配所有元素
        // 练习Shi都所有的员工年龄大于18
        boolean b = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(b);

        // anyMatch(Predicate p)-检查是否至少匹配一个元素
        // 练习 ：是否存在员工的工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000.0);
        System.out.println(anyMatch);

        // noneMatch(Predicate p)-检查是佛偶没有匹配的元素
        // 练习是否存在员工名为Jack
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().startsWith("Jack"));
        System.out.println(noneMatch);
        // findFirst-返回第一个元素
        Optional<Employee> first = employees.stream().sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId())).findFirst();
        System.out.println(first);
        // findAny()-找任意一个
        Optional<Employee> any = employees.parallelStream().findAny();
        System.out.println(any);
    }
    /**
     * 匹配与查找
     */
    @Test
    public void test02(){
        List<Employee> employees = EmployeeData.getEmployees();
        // count 返回流中元素的总个数
        // 擦汗寻工资大于5000员工个个数
        long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
        System.out.println(count);
        // max(Comparator c)-返回流中最大值
        // 练习：返回最高的工资
        Stream<Double> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Double> max = salaryStream.max(Double::compare);
        System.out.println(max);
        // min(Comparator c)-返回流中最小值
        // 练习：返回最低工资的员工
        Optional<Employee> min = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(min);

        // forEach(Consumer c)-内部迭代
        employees.stream().forEach(System.out::println);
        System.out.println();
        employees.forEach(System.out::println);
    }
    /**
     * 2-终止操作-规约
     */
    @Test
    public void test03(){
        // reduce(T identity,BinaryOperator)-可以将流中元素反复结合起来，得到一个值。返回
        // 练习一，计算1-10自然数的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer reduceSum = list.stream().reduce(0, Integer::sum);
        System.out.println(reduceSum);
        // reduce(BinaryOperator)-可以将流元素反复结合起来，得到一个值，返回Optional<T>
        // 练习二，计算公司所有员工工资的综合
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Double> salaryStream = employees.stream().map(Employee::getSalary);
       // Optional<Double> sumSalary = salaryStream.reduce(Double::sum);
        Optional<Double> sumSalary = salaryStream.reduce((e1, e2) -> e1 + e2);
        System.out.println(sumSalary);
    }
    /**
     * 3，-收集
     */
    @Test
    public void test04(){
        //collect(Collector c)-将流转换成为其他模式。接收一个Collector接口的实现，用于
        // 练习一：查找工资大于6000的员工，结果为一个list或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> employeeList = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());
        employeeList.forEach(System.out::println);
        System.out.println();
        Set<Employee> employeeSet = EmployeeData.getEmployees().stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        employeeSet.forEach(System.out::println);
    }
}
