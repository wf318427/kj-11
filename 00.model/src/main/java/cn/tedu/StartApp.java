package cn.tedu;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

/**
 * Created by Administrator on 17.10.8.
 */
@SpringBootApplication
public class StartApp {
    public static void main(String[] args) {
        //sssssssss
        SpringApplication.run(StartApp.class,args);
    }
    @Bean
    public Queue queue() {
        //xxxxxxxxxxxxx
        return new ActiveMQQueue("sample.queue");
    }
}
