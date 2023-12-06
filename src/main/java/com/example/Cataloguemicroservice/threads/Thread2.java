package com.example.Cataloguemicroservice.threads;

public class Thread2 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("thread2 is running");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread2 has finished");
    }
}
