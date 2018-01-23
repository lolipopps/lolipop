package lolipop.domain;

import javax.jms.Destination;

/**
 * 名称：MessageSenderService<br>
 * <p>
 * 描述：Jms消息生产者（发送）服务接口<br>
 */
public interface MessageSenderService {

    /**
     * 一对一消息方法
     *
     * @param destination   消息目的地
     * @param message       消息内容
     */
    void sendQueue(Destination destination, final String message);

    /**
     * 发布、订阅消息发送
     *
     * @param destination   消息目的地
     * @param message       消息内容
     */
    void sendTopic(Destination destination, final String message);


    /**
     * 一对一消息发送
     *
     * @param name      队列名称
     * @param message   消息内容
     */
    void sendQueue(String name, final String message);

    /**
     * 发布、订阅消息发送
     *
     * @param name      队列名称
     * @param message   消息内容
     */
    void sendTopic(String name, final String message);

}
