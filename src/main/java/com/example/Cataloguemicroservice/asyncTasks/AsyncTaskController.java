package com.example.Cataloguemicroservice.asyncTasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncTaskController {
    @Autowired
    AsyncTask1 asyncTask1;

    @GetMapping("/")
    public void test(){
        System.out.println("start");
        asyncTask1.print();
        System.out.println("end");
    }
}
