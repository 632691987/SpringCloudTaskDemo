package com.example.taskdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.stereotype.Component;

@Component
public class ApplicationService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @BeforeTask
    public void methodA(TaskExecution taskExecution) {
        logger.info("=========================================");
        logger.info("BeforeTask triggered, time = {}", taskExecution.getStartTime());
        logger.info("=========================================");
    }

    @AfterTask
    public void methodB(TaskExecution taskExecution) {
        logger.info("=========================================");
        logger.info("AfterTask triggered, time = {}", taskExecution.getEndTime());
        logger.info("=========================================");
        taskExecution.setExitMessage("AFTER EXIT MESSAGE");
    }

    @FailedTask
    public void methodC(TaskExecution taskExecution, Throwable throwable) {
        logger.info("=========================================");
        logger.info("FailedTask triggered");
        logger.info("=========================================");
    }

}
