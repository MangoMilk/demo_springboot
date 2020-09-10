package com.example.springboot.job;

public class DemoRunnable implements Runnable {

    private String name;

    private int ticket = 10;

    public DemoRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//     for(int i=0; i<10; i++) {
//         if (i==2) {
////             Thread.currentThread().yield();
////             Thread.yield();
//         }
//         try{
//             Thread.sleep(500);
//             System.out.println(Thread.currentThread().getName() + " run, i = " + i);
//         }catch (Exception e) {
//             System.out.println(e.getMessage());
//         }
//     }

        for(int i=0; i<15; i++) {
            // synchronized object
//            synchronized (this) {
//                if (ticket>0) {
//                    try{
//                        Thread.sleep(300);
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("卖票: ticket="+ticket--);
//                }
//            }
            this.sale();
        }
    }

    // synchronized method
    synchronized public void sale() {
        if (ticket>0) {
            try{
                Thread.sleep(300);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            System.out.println("卖票: ticket="+ticket--);
        }
    }
}
