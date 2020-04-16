package com.atguigu.java4;

/**
 * created by yuqi on 2020/4/13
 *
 * @Author yuqi
 * @Description
 */
public class Girl {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Girl(String name) {
        this.name = name;
    }

    public Girl() {
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
