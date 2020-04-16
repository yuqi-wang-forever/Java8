package com.atguigu.java3;

import com.atguigu.java2.Employee;
import com.atguigu.java2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * created by yuqi on 2020/4/13
 *
 * @Author yuqi
 * @Description
 *  测试Stream的中间操作
 */
public class StreamAPITest01 {
    /**
     * 1，筛选与切片
     */
    @Test
    public void test01(){
        List<Employee> employees = EmployeeData.getEmployees();
        //filter(Predicate p) 接收Lambda，从流中排除某些元素。
        Stream<Employee> stream = employees.stream();
        // 练习查询员工表中薪资大于8000的员工信息
        stream.filter(e -> e.getSalary() > 8000).forEach(System.out::println);
        System.out.println();
        //limit(n)-截断流，是元素不超过给定数量
        employees.stream().limit(5).forEach(System.out::println);
        System.out.println();
        //skip(n)-跳过怨怒是，返回一个扔掉了前n个元素的流。若流中元素不足n个则返回一个空格。与limit(n) 互补
        employees.stream().skip(5).forEach(System.out::println);
        System.out.println();
        //distinct()-筛选，通过流所生成元素的hashCode() 和equals()祛除重复元素
        employees.add(new Employee(1010,"Jack",56,110000.01));
        employees.add(new Employee(1010,"Jack",56,110000.01));
        employees.add(new Employee(1012,"Jack",56,110000.01));
        employees.add(new Employee(1013,"Jack",56,110000.01));
        employees.add(new Employee(1014,"Jack",56,110000.01));
        employees.stream().distinct().forEach(System.out::println);
    }
    /**
     * 映射
     */
    @Test
    public void test02(){

         //map(Function f)-接收一个函数作为参数，将元素转换成其他形式或提取信息，该函数会被会被应用到每个元素上，并将其映射成一个元素
        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);
        // 方法引用
        //list.stream().map(String::toUpperCase).forEach(System.out::println);
        //练习一 ：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Employee> stream = employees.stream();
        Stream<String> stringStream = stream.map(e -> e.getName());
        //Stream<String> stringStream = stream.map(Employee :: getName);
        stringStream.filter(name -> name.length() > 5).forEach(System.out::println);
        System.out.println();
        // 练习二
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest01::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        System.out.println();
        //flatMap(Function f)接收袷函数作为参数，将流中的每一个值都换成另一个类，然后把所有流连接成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest01::fromStringToStream);
        characterStream.forEach(System.out::println);

    }

    /**
     * 将字符串中的多个字符转换成为对应的Stream的实例
     * @param str
     * @return
     */
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c : str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }
    /**
     * 类比map(Function f) 和 flatmap(Function f)
     *  map 相当于list 中的add() 集合里有一个集合 流中有另一个流
     *  flatmap类似于addall() 把list2中的数据变为list1中的元素
     */
    @Test
    public void test03(){
        List list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List list2 = new ArrayList();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list1.add(list2);
        //list1.addAll(list2);
        System.out.println(list1);
    }
    /**
     * 3-排序
     */
    @Test
    public void test04(){
        //sorted()- 自然排序
        List<Integer> integerList = Arrays.asList(-7,67,12, 34, 25, 64, 81);
        integerList.stream().sorted().forEach(System.out::println);
       /* //抛异常原因：Employee没有实现Comparator接口
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted().forEach(System.out::println);*/
       //sorted(Comparator c) -定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) -> {
                int ageValue = Integer.compare(e1.getAge(),e2.getAge());
                if (ageValue!=0){
                    return ageValue;
                }else {
                    return -Double.compare(e1.getSalary(),e2.getSalary());
                }
    }).forEach(System.out::println);
    }
}
