package org.lan.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//注解@Configuration 是最新的用注解配置spring，也就是说这是个配置文件，
// 和原来xml配置是等效的，只不过现在用java代码进行配置 加上一个@Configuration注解就行了
@Configuration
//@ComponentScan告诉Spring 哪个packages 的用注解标识的类
// 会被spring自动扫描并且装入bean容器。
@ComponentScan
public class Application {
    @Bean
    MessageService mockMessageService(){
        return new MessageService() {
            @Override
            public String getMessage() {
                return "Hello World!";
            }
        };
    }
    public static void main(String[] args){
        ApplicationContext context=new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer=context.getBean(MessagePrinter.class);
        printer.printMessage();
    }
}
