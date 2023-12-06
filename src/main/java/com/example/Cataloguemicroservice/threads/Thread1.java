package com.example.Cataloguemicroservice.threads;

public class Thread1 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("thread1 is running");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread1 has finished");
    }
}
