package cn.tedu.test;

import cn.tedu.service.Emp;//接口与实体类在同一路径下
import com.thoughtworks.xstream.XStream;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.apache.commons.httpclient.HttpClient;

import java.io.IOException;

/**
 * Created by Administrator on 17.12.24.
 */
public class TestCase1 {
    @Test
    public void test(){
        JaxWsDynamicClientFactory clientFactory=JaxWsDynamicClientFactory.newInstance();
        Client client=clientFactory.createClient("http://localhost:8080/WeatherService?wsdl");
        try {
            Object[] objects=client.invoke("getWeatherService","南京");
            System.out.println(objects[0]);
            Emp p=new Emp();
            p.setName("张飞");
            p.setId((long) 3);
            p.setAge((long) 26);
            objects=client.invoke("printBean",p);
            objects=client.invoke("getXml",p);
            System.out.println(objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        String url="http://localhost/hello";
        HttpClient httpClient=new HttpClient();
        GetMethod get=new GetMethod(url);

        try {
            httpClient.executeMethod(get);
            String str=get.getResponseBodyAsString();
            System.out.println(str);
            Emp p=new Emp();
            p.setName("张飞");
            p.setId((long) 3);
            p.setAge((long) 26);
            String str1=new XStream().toXML(p);
            System.out.println(str1);
            String url1="http://localhost/hello1";
            PostMethod post = new PostMethod(url1);
          //  post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
            post.setParameter("xml",str1);
            httpClient.executeMethod(post);
            int code=post.getStatusCode();
            System.out.println(code);
            if(code==200){
                System.out.println(post.getResponseBodyAsString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
