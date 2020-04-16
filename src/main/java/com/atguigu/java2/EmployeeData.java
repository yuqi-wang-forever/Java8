package com.atguigu.java2;

import java.util.ArrayList;
import java.util.List;

/**
 * created by yuqi on 2020/4/9
 *
 * @Author yuqi
 */
public class EmployeeData {
    public static List<Employee>  getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001,"Jack O'Nell",56,8000.12));
        list.add(new Employee(1002,"Samantha Carter",45,9000.24));
        list.add(new Employee(1003,"Daniel Jackson",52,8500.36));
        list.add(new Employee(1004,"Teal'C",104,7000.54));
        list.add(new Employee(1005,"Hammond",66,10000.22));
        list.add(new Employee(1006,"Jonas Quinn",46,84000.11));
        list.add(new Employee(1007,"Vala Mal",46,800065));
        list.add(new Employee(1008,"Cameron Mitchell",53,9500.65));
        return list;
    }
}
