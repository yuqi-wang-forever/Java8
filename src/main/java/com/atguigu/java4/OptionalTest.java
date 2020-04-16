package com.atguigu.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * created by yuqi on 2020/4/13
 *
 * @Author yuqi
 * @Description
 *      Optional类：为了在程序中避免出现空指针异常而创建的
 *      常用的方法：ofNullable(T t)
 *              orElse(T t)
 */
public class OptionalTest {
    /**
     * Optional.of(T t):创建一个Optional实例，t必须非空
     *
     */
    @Test
    public void test01(){
        Girl girl = new Girl();
        girl = null;
        // of(T t):保证t时非空的
        Optional<Girl> optionalGirl = Optional.of(girl);
        System.out.println(optionalGirl);
    }
    /**
     * Optional.empty();创建一个空的Optional实例
     */
    @Test
    public void test02(){
        Girl girl = new Girl();
        Optional<Girl> empty = Optional.empty();
        System.out.println(empty);
    }

    /**
     * Optional.ofNullable(T t):t可以为null
     */
    @Test
    public void test03(){
        Girl girl = new Girl();
        girl = null;
        // ofNullable(T t):t可以为null
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
        // orElse(T t):如果当前的Optional内部封装的t是空的，则返回内部的t
        // 如果内部的t是空的，则返回orElse()方法中的参数t。
        Girl girl1 = optionalGirl.orElse(new Girl("Samantha"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }
    @Test
    public void test04(){
        Boy boy = new Boy();
        String name =getGirlName(boy);
        System.out.println(name);
    }

    /**
     *  优化后的getGirlName()
     * @param boy
     * @return
     */
    public String getGirlName1(Boy boy){
        if (boy!=null){
            Girl girl = boy.getGirl();
            if (girl!=null){
                return girl.getName();
            }
        }
        return null;
    }
    @Test
    public void test05(){
        Boy boy = new Boy();
        String name =getGirlName(boy);
        System.out.println(name);
    }
    /**
     * 使用Optional类的getGirlName()；
     */
    public String getGirlName2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        // 此时的boy1一定非空
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("Sam")));
        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        // girl1一定非空
        Girl girl1 = girlOptional.orElse(new Girl("Samantha Carter"));

        return girl1.getName();
    }
    @Test
    public void test06(){
        Boy boy = null;
        // boy = new Boy();
         boy = new Boy(new Girl("Janet"));
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}
