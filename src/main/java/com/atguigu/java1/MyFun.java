package com.atguigu.java1;

/**
 * created by yuqi on 2020/4/13
 *
 * @Author yuqi
 * @Description
 */
@FunctionalInterface
public interface MyFun<T> {
    public T getValue(T ts);
}
