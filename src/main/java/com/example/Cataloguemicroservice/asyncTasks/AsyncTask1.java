package com.example.Cataloguemicroservice.asyncTasks;

import com.example.Cataloguemicroservice.threads.Thread1;
import com.example.Cataloguemicroservice.threads.Thread2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


@Component
public class AsyncTask1 {
    Thread1 thread1=new Thread1();
    Thread2 thread2=new Thread2();
    @Async
    public void print(){
        thread1.start();
        thread2.start();
    }
}
