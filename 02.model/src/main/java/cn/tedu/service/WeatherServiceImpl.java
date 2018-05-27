package cn.tedu.service;

import cn.tedu.entity.Emp;
import com.sun.org.apache.xerces.internal.impl.XMLStreamFilterImpl;
import com.sun.org.apache.xpath.internal.objects.XString;
import com.thoughtworks.xstream.XStream;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * Created by Administrator on 17.12.23.
 */
@Service
@WebService
public class WeatherServiceImpl implements WeatherService {
    @WebMethod
    public String getWeatherService(String city){
        return city+"good";
    }
    @WebMethod
    public void printBean(Emp emp) {
        System.out.println(emp);
    }
    @WebMethod
    public String getXml(Emp emp) {
        XStream xStream=new XStream();
        String xml=xStream.toXML(emp);
        return xml;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/WeatherService",new WeatherServiceImpl());
        System.out.println("sucess");
    }
}

