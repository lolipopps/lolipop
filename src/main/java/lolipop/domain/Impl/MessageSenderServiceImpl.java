package lolipop.domain.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import lolipop.domain.MessageSenderService;

import javax.jms.Destination;

/**
 * 名称：MessageSenderServiceImpl<br>
 * <p>
 * 描述：Jms消息（生产者）发送服务接口实现类<br>
 *
 */
//@Service
public class MessageSenderServiceImpl // implements MessageSenderService 
{
/*
    @Autowired
    private JmsTemplate jmsQueueTemplate;

    @Autowired
    private JmsTemplate jmsTopicTemplate;

    @Override
    public void sendQueue(Destination destination, String message) {
        jmsQueueTemplate.send(destination, session -> session.createTextMessage(message));
    }

    @Override
    public void sendTopic(Destination destination, String message) {
        jmsTopicTemplate.send(destination, session -> session.createTextMessage(message));
    }

    @Override
    public void sendQueue(String name, String message) {
        jmsQueueTemplate.send(name, session -> session.createTextMessage(message));
    }

    @Override
    public void sendTopic(String name, String message) {
        jmsTopicTemplate.send(name, session -> session.createTextMessage(message));
    }
    */
}
