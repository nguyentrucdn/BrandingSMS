package com.bagasus;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by thainguy on 8/9/2016.
 */
@SpringBootApplication
@EnableAsync
@ComponentScan("com.bagasus")
public class App {
    public static void main(String[] args){

        ClassLoader classLoader = App.class.getClassLoader();
        Config rootConf = ConfigFactory.parseResources(classLoader, "application.conf");
        ConfigurationProvider.Instance().setConfig(rootConf);
        System.out.print(rootConf.entrySet());

        SpringApplication.run(App.class, args);
    }

    @Bean
    public TaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(1000);
        return executor;
    }
}
