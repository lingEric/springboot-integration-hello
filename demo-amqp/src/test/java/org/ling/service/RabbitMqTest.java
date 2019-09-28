package org.ling.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ling.common.bean.Student;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RabbitMqTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Test
    public void testDeclare() {
        //参数列表分别是：1.交换器名称,2.是否持久化,3.是否自动删除【指的是当最后一个与它绑定的队列删除时，是否自动删除该交换机】
        TopicExchange topicExchange = new TopicExchange("default.topic", true, false);
        DirectExchange directExchange = new DirectExchange("default.direct", true, false);
        FanoutExchange fanoutExchange = new FanoutExchange("default.fanout", true, false);
        HeadersExchange headersExchange = new HeadersExchange("default.headers", true, false);
        rabbitAdmin.declareExchange(topicExchange);
        rabbitAdmin.declareExchange(directExchange);
        rabbitAdmin.declareExchange(fanoutExchange);
        rabbitAdmin.declareExchange(headersExchange);

        //1.队列名称,2.声明一个持久队列,3.声明一个独立队列,4.是否自动删除队列
        Queue queue1 = new Queue("queue1", true, false, false);
        Queue queue2 = new Queue("queue2", true, false, false);
        Queue queue3 = new Queue("queue3", true, false, false);
        Queue queue4 = new Queue("queue4", true, false, false);
        rabbitAdmin.declareQueue(queue1);
        rabbitAdmin.declareQueue(queue2);
        rabbitAdmin.declareQueue(queue3);
        rabbitAdmin.declareQueue(queue4);

        //1.queue:绑定的队列,2.topicExchange:绑定到那个交换器,3.test.send.topic:绑定的路由名称[routing key]
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue1).to(fanoutExchange));
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue2).to(fanoutExchange));
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue3).to(topicExchange).with("mq.*"));
        rabbitAdmin.declareBinding(BindingBuilder.bind(queue4).to(directExchange).with("mq.direct"));
    }

    @Test
    public void testSendMessage() {
        //1.交换机，2.路由键，3.发送的消息体【这里的消息体会自动转换为消息，也可以自己构建消息对象】
        rabbitTemplate.convertAndSend("default.topic","mq.whatever",new Student(1,"mmp","male",234));
    }

    @Test
    public void testReceive() {
        Student student = (Student) rabbitTemplate.receiveAndConvert("queue3");
        System.out.println(student);
    }
}