package org.lan.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//@component （把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>）
@Component
public class MessagePrinter {
    final private MessageService service;
    @Autowired
    public MessagePrinter( MessageService service){
        this.service=service;
    }
    public void printMessage(){
        System.out.println(this.service.getMessage());
        
    }
}
