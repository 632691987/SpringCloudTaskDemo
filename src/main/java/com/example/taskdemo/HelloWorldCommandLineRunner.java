package com.example.taskdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.task.listener.TaskLifecycleListener;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.cloud.task.repository.TaskRepository;
import org.springframework.cloud.task.repository.support.SimpleTaskRepository;

public class HelloWorldCommandLineRunner implements CommandLineRunner {

    @Autowired
    private TaskLifecycleListener lifecycleListener;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SimpleTaskRepository simpleTaskRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("==========================================");
        TaskExecution taskExecution = simpleTaskRepository.getTaskExecutionDao().getLatestTaskExecutionForTaskName("helloWorld234");
        System.out.println(taskExecution.getExecutionId());
        System.out.println("==========================================");
    }

}
