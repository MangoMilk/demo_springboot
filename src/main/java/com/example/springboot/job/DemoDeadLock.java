package com.example.springboot.job;

public class DemoDeadLock implements Runnable {
    private static Zhangsan zs = new Zhangsan();       // 实例化static型对象
    private static Lisi ls = new Lisi();       // 实例化static型对象
    private boolean flag = false;  // 声明标志位，判断那个先说话

    @Override
    public void run() {  // 覆写run()方法
        if (flag) {
            synchronized (zs) {   // 同步张三
                zs.say();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (ls) {
                    zs.get();
                }
            }
        } else {
            synchronized (ls) {
                ls.say();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (zs) {
                    ls.get();
                }
            }
        }
    }
}
