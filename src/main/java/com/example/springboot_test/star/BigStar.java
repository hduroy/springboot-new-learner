package com.example.springboot_test.star;

/**
 * 学习动态代理
 * 代理可以无侵入式的给对象增强其他功能
 * 代理里面就是对象要被代理的方法
 * 通过接口保证，后面的对象和代理需要实现同一个接口，接口中就是被代理的所有方法
 */
public class BigStar implements Star {
    private String name;

    //构造函数
    public BigStar(){

    }

    public BigStar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //实现接口方法
    @Override
    public String sing(String name){
        System.out.println(this.name + "正在唱" + name);
        return "谢谢";
    }

    @Override
    public String dance(String name) {
        System.out.println(this.name + "正在跳" + name);
        return "thanks";
    }
}
