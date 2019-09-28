package org.ling.service;

import org.ling.common.bean.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverService {
    @RabbitListener(queues = {"queue3"})
    public void receive(Student student) {
        System.out.println("接收到消息并打印："+student);
    }
}
