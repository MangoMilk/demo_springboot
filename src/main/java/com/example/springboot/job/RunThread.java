package com.example.springboot.job;

// create
// run
// join
// sleep
// interrupt/stop
// daemon
// priority
// yield
// synchronized
// lock/semaphore

// getState
// isAlive
// getName
// activeCount
// getPriority
// isInterrupted
public class RunThread {
    public static void main(String[] args) {
//        DemoRunnable d1 = new DemoRunnable("Thread-A");
        DemoRunnable d2 = new DemoRunnable("Thread-B");

//        Thread t1 = new Thread(d1);
        Thread t1 = new Thread(d2);
        Thread t2 = new Thread(d2);
        Thread t3 = new Thread(d2);
        t1.start();
        t2.start();
        t3.start();

//        Thread t1 = new DemoThread("Thread-A");
//        Thread t2 = new DemoThread("Thread-B");

//        t1.setPriority(Thread.MIN_PRIORITY);
//        t1.start();
//        try{
//            t1.join();    // force execute, other thread can't run concurrently.
//            Thread.sleep(2000);
//        }catch (InterruptedException e) {
//            System.out.println("main thread sleep is interrupted.") ;
//        }

//        t1.interrupt();   // interrupt one of running thread. In this case, t1.interrupt() will interrupt main thread.

//        t2.setDaemon(true);   // set daemon thread.
//        t2.setPriority(Thread.NORM_PRIORITY);
//        t2.setPriority(Thread.MAX_PRIORITY);
//        t2.start();

//        DemoDeadLock t1 = new DemoDeadLock();      // 控制张三
//        DemoDeadLock t2 = new DemoDeadLock();      // 控制李四
//        t1.flag = true;
//        t2.flag = false;
//        Thread thA = new Thread(t1);
//        Thread thB = new Thread(t2);
//        thA.start();
//        thB.start();
    }
}
