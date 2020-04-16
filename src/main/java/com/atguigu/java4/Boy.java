package com.atguigu.java4;

/**
 * created by yuqi on 2020/4/13
 *
 * @Author yuqi
 * @Description
 */
public class Boy {
    private Girl girl;

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() {
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
