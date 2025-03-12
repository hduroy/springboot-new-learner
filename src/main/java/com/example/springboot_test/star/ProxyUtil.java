package com.example.springboot_test.star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    /**
     * 方法作用：
     * 给一个明星的对象，创建一个代理对象
     *
     * @param bigstar
     * @return 返回一个代理对象
     * @throws Exception
     */
    public static Star createProxy(BigStar bigstar) {
//        //创建一个代理对象
//        StarInvocationHandler handler = new StarInvocationHandler();
//        //设置要代理的对象
//        handler.setTarget(star);
//        //创建代理对象
//        Star proxy = (Star) handler.createProxy();

        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),//类加载器
                new Class[]{Star.class},//代理对象要实现的接口
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        return null;
//                    }
//                }
                (proxy, method, args) -> {
                    //判断方法名
                    System.out.println("代理对象的方法执行了");
                    if ("sing".equals(method.getName())) {
                        System.out.println("代理准备唱歌");
                    }
                    //执行被代理对象的方法
                    if ("dance".equals(method.getName())) {
                        System.out.println("代理对象准备跳舞");
                    }
                    return method.invoke(bigstar, args);
                }
        );
        return star;

    }
}
