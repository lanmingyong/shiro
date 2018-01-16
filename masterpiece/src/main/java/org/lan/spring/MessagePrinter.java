package org.lan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component//声明注解当前所在类为Spring容器管理的Bean
public class MessagePrinter {

    final private MessageService service;

    @Autowired//为service自动注入值
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}