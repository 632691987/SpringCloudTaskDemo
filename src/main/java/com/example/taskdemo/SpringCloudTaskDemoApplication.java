package com.example.taskdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudTaskDemoApplication {

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new HelloWorldCommandLineRunner();
    }

    @Bean
    public AnotherCommandLineRunner anotherCommandLineRunner() {
        return new AnotherCommandLineRunner();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudTaskDemoApplication.class, args);
    }

}
