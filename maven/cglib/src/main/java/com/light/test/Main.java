package com.light.test;

public class Main {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        SayHello proxyImp = (SayHello) proxy.getProxy(SayHello.class);
        proxyImp.say();
    }
}
