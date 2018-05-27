package cn.tedu.test;

import javax.jms.*;

import cn.tedu.entity.Emp;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

public class Constomer {
    @Test
    public  void test() {
        System.out.println("消费者");
        //ConnectionFactory factory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageConsumer consumer;
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("admin", "admin", ActiveMQConnection.DEFAULT_BROKER_URL);
        factory.setTrustAllPackages(true);
        try {
            connection = factory.createConnection();
            connection.start();
            session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);
            destination = session.createQueue("hello");
            consumer = session.createConsumer(destination);
            while (true) {
                //TextMessage message = (TextMessage) consumer.receive(100000);
                ObjectMessage message= (ObjectMessage) consumer.receive();
                session.commit();
                if (message != null) {
                    //System.out.println(message.getText());
                    Emp emp= (Emp) message.getObject();
                    System.out.println(emp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
