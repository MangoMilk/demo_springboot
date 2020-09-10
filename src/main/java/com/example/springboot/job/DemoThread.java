package com.example.springboot.job;

public class DemoThread extends Thread {

    private String name;

    public DemoThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++) {
            System.out.println(name + " run, i = " + i);
        }
    }
}
