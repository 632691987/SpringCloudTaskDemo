package com.example.taskdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.task.configuration.TaskConfigurer;

public class AnotherCommandLineRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TaskConfigurer taskConfigurer;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==========================================");
        System.out.println(taskConfigurer.getTaskDataSource().getConnection().getSchema());
        System.out.println("==========================================");
    }
}
