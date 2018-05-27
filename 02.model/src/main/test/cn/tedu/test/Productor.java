package cn.tedu.test;

import javax.jms.*;

import cn.tedu.entity.Emp;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import java.io.Serializable;

public class Productor {
    private  final static int SEND_NUMBER=10;
    @Test
    public void test() {

        ConnectionFactory factory;
        Connection connection=null;
        Session session;
        Destination destination;
        MessageProducer producer;
        factory=new ActiveMQConnectionFactory(
                "admin",
                "admin",
                ActiveMQConnection.DEFAULT_BROKER_URL);
        System.out.println(ActiveMQConnection.DEFAULT_USER);
        System.out.println(ActiveMQConnection.DEFAULT_PASSWORD);
        System.out.println(ActiveMQConnection.DEFAULT_BROKER_URL);
        try{
            connection=factory.createConnection();
            connection.start();
            //session=connection.createSession(true, SEND_NUMBER);
            session=connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination=session.createQueue("hello");
            producer=session.createProducer(destination);
            //producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            sendMessage(session, producer);
            Emp emp=new Emp();
            emp.setName("caocao");
            emp.setAge((long)45);
            emp.setId((long) 1);
            //sendMessageObject(session,producer,emp);
            session.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
    public void sendMessageObject(Session session,MessageProducer producer,Object o) throws JMSException {
        ObjectMessage message=session.createObjectMessage((Serializable)o);
        producer.send(message);
    }
    public static void sendMessage(Session session,MessageProducer producer) throws JMSException{
        for(int i=0;i<SEND_NUMBER;i++){
            TextMessage message=session.createTextMessage("消息生产者发送消息"+i);
            System.out.println("发送消息:"+"消息生产者发送消息"+i);
            producer.send(message);

        }
    }
}
