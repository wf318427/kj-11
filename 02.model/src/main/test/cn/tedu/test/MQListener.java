package cn.tedu.test;

import cn.tedu.entity.Emp;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * Created by Administrator on 18.1.7.
 */
public class MQListener {
    @Test
    public void test(){
        {
            System.out.println("消费者");
            //ConnectionFactory factory;
            Connection connection = null;
            final Session session;
            Destination destination;
            MessageConsumer consumer;
            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
            factory.setTrustAllPackages(true);
            try {
                connection = factory.createConnection();
                connection.start();
                  //session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
                session=connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
                destination = session.createQueue("hello");
                consumer = session.createConsumer(destination);
                consumer.setMessageListener(new MessageListener() {
                    public void onMessage(Message message) {
                        try {
                            TextMessage textMsg = (TextMessage) message;
                            session.commit();
                            System.out.println(1/0);
                            System.out.println("消费者:"+textMsg.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                });

                System.in.read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
